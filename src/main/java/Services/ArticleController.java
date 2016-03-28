package Services;

import com.google.gson.Gson;
import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Date;

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
			
			String id = req.params(":id");

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
		
		
	/*	get("/test", (req, res) -> {
            Map<String, Object> data = new HashMap<>();
            data.put("status", "live");
            data.put("now", new Date());

            String xml =    "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                            "<note>" +
                                "<to>You</to>" +
                                "<from>Me</from>" +
                                "<heading>Reminder</heading>" +
                                "<body>Don't forget me this weekend!</body>" +
                            "</note>";
            res.type("text/xml");
            return xml;
        });*/
	
	
	}

}
