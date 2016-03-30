package Services;

import com.google.gson.Gson;
import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Date;
import static spark.Spark.*;

import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.heroku.sdk.jdbc.DatabaseUrl;
import spark.Request;
import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class ArticleController {
    private static ArrayList<Map<String, String>> arrayList ;
    Gson gson = new Gson();

    public ArticleController(final ArticleService articleService) {
       
        
        get("/Article", (req, res) -> {
			
            return articleService.getAllArticle();
        }, gson::toJson);

        get("/Article/:id", (req, res) -> {
			
			Integer id = Integer.parseInt(req.params(":id"));


			 arrayList= articleService.getOneArticle(id);
			if (!arrayList.isEmpty()) {
				return arrayList;
			}
			
			return "[{\"" + id + "\":\"Could not find the Article you search for please try again. \"}]";
		}, gson::toJson);
		
  
     get("/WSxml", (req, res) -> {
            //Map<String, Object> data = new HashMap<>();
          
 //arrayList= articleService.getAllArticleXML();
 res.type("text/xml");
 return  articleService.getAllArticleXML();
 //return articleService.getAllArticleXML();
 
		
        });
		  get("/WSxml/:d", (req, res) -> {
         
String id = req.params(":d");
if (id == null){
	return id ;
	
}

	String result =articleService.getoneArticleXML(id);

	if (result != null){
		res.type("text/xml");
 return  result;
 
		
	}
		else {
			return "error occured!!" + id;
		} 
 
	
	});
	get("/check", (req, res) ->{
//	return (XMLValidation.validateXMLSchema("articles.xsd", "articles.xml")); /*+ XMLValidation.validateXMLSchema("http://localhost:5000/Employee.xsd", "http://localhost:5000/EmployeeResponse.xml"));*/
return "getNumberOfArticles = " + articleService.getNumberOfArticles() + "getArticleTitle= " + articleService.getArticleTitle();
});

post("/test", (req, res) ->{
	 Integer ArticleIDs = articleService.getNumberOfArticles() + 1;
     String   ArticleTitle = req.queryParams("title");
     String   ArticleAuthors = req.queryParams("author");
     // String  ArticleDate = req.queryParams("date");
     String   ArticleBody = req.queryParams("body");
	//	String   ArticleImages = req.queryParams("image");
		//String   ArticleBody = req.queryParams("body");
		Date date = new Date();

           
            
            String cont = articleService.createArticle(ArticleTitle, ArticleAuthors, date.toString(), ArticleBody);
            if(!cont.equals("")){
            return "To check the recently entered article in Json format by using a web service <a href='Article/"+ ArticleIDs +"'>click here</a> <p> OR </p> <p> To check the recently entered article in HTML page that calls another web serivce <a href='jsonHtml2.html?id="+ ArticleIDs +"'>click here</a> </p>"; 
			}
            return "Error";
	});


}
}
