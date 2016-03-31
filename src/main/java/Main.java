import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.heroku.sdk.jdbc.DatabaseUrl;
import Services.*;



public class Main {

  public static void main(String[] args) {

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");
	
		Object user = new ArticleController(new ArticleService());
	
	

    get("/hello", (req, res) -> "Hello World, this me Hisham");
	
	
get("/validate", (req, res) ->{
	return (XMLValidation.validateXMLSchema("articles.xsd", "articles.xml")); /*+ XMLValidation.validateXMLSchema("http://localhost:5000/Employee.xsd", "http://localhost:5000/EmployeeResponse.xml"));*/

});
    get("/index", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());
		
		
		 get("/about", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
			
			 String contents[]  = {"Interactive Blog for Information Security learners","The blog is intended to target those who have an interest in learning good information security practices and Information Security Forensics but they do not have a solid background in the field","As a student in the Information Security track in the iSchool, I find it difficult to find good resources for information security that are easy to grasp even if you do not have a solid background in the field. Usually, the resources on the web either too advanced or they require to read other material from another resources. This project, iBlog, will act as an intermediate learning resource for those who want to master the information security and do not have a good background","An individual or a small group usually runs a blog. However, this blog, iBlog, will be more interactive so everyone can create posts or comment on others more openly rather than being managed by an individual. The reason why I want to make it a blog and not a conventional website is that I want users to interact and generate contents more freely without feeling of being judged by experts since this blog will target people who are newly interested in the field of information security."};
            attributes.put("contents", contents);

            return new ModelAndView(attributes, "about.ftl");
        }, new FreeMarkerEngine());
		//-------------------------------------------------------------
		  get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
           // attributes.put("articles", new String[]{"Selfie + money + Snapchat = robbed! Don't flash your cash...", "Police destroy evidence with 10 failed passcode attempts on iPhone","Facebook 'Message Requests' lets you contact anyone, even if you're not friends","You gotta touch the banana for Wi-Fi access, says sys admin"});
			
			attributes.put("article1", "Selfie + money + Snapchat = robbed! Don't flash your cash...");
			 attributes.put("author1", "Paul Ducklin ");
			  attributes.put("rate1", "1");
			 attributes.put("date1", "September 24, 2014");
    attributes.put("article2", " Police destroy evidence with 10 failed passcode attempts on iPhone");
	 attributes.put("author2", "Lisa Vaas");
	  attributes.put("rate2", "2");
	  attributes.put("date2", "September 18, 2014");
	attributes.put("article3", " Facebook 'Message Requests' lets you contact anyone, even if you're not friends");
		 attributes.put("author3", "Lee Munson");
		  attributes.put("date3", "on August 24, 2014");
	    attributes.put("article4", " You gotta touch the banana for Wi-Fi access, says sys admin");
			 attributes.put("author4", "Lisa Vaas");
			  attributes.put("date4", "on July 8, 2014");
			    attributes.put("rate4", "2");
		//  attributes.put("article5", "Hello World!");
		  //  attributes.put("article6", "Hello World!");
		  
		  
            return new ModelAndView(attributes, "home.ftl");
        }, new FreeMarkerEngine());
		//----------------------------------------------------------------------------------
 get("/home2", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
           // attributes.put("articles", new String[]{"Selfie + money + Snapchat = robbed! Don't flash your cash...", "Police destroy evidence with 10 failed passcode attempts on iPhone","Facebook 'Message Requests' lets you contact anyone, even if you're not friends","You gotta touch the banana for Wi-Fi access, says sys admin"});
			
			attributes.put("article1", "This is a freemarker field:Selfie + money + Snapchat = robbed! Don't flash your cash...");
			 attributes.put("author1", "Paul Ducklin ");
			 attributes.put("date1", "September 24, 2014");
    attributes.put("article2", " This is a freemarker field: Police destroy evidence with 10 failed passcode attempts on iPhone");
	 attributes.put("author2", "Lisa Vaas");
	  attributes.put("date2", "September 18, 2014");
	attributes.put("article3", " This is a freemarker field:  Facebook 'Message Requests' lets you contact anyone, even if you're not friends");
		 attributes.put("author3", "Lee Munson");
		  attributes.put("date3", "on August 24, 2014");
	    attributes.put("article4", " This is a freemarker field: You gotta touch the banana for Wi-Fi access, says sys admin");
			 attributes.put("author4", "Lisa Vaas");
			  attributes.put("date4", "on July 8, 2014");
		//  attributes.put("article5", "Hello World!");
		  //  attributes.put("article6", "Hello World!");
		  
		  
            return new ModelAndView(attributes, "home.ftl");
        }, new FreeMarkerEngine());
		
		
		
		//---------------------------------------------------------------
    get("/db", (req, res) -> {
      Connection connection = null;
      Map<String, Object> attributes = new HashMap<>();
      try {
        connection = DatabaseUrl.extract().getConnection();

        Statement stmt = connection.createStatement();
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

        ArrayList<String> output = new ArrayList<String>();
        while (rs.next()) {
          output.add( "Read from DB: " + rs.getTimestamp("tick"));
        }

        attributes.put("results", output);
        return new ModelAndView(attributes, "db.ftl");
      } catch (Exception e) {
        attributes.put("message", "There was an error: " + e);
        return new ModelAndView(attributes, "error.ftl");
      } finally {
        if (connection != null) try{connection.close();} catch(SQLException e){}
      }
    }, new FreeMarkerEngine());

  }

}


