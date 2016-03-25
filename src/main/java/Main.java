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

public class Main {

  public static void main(String[] args) {

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");

    get("/hello", (req, res) -> "Hello World, this me Hisham");

    get("/index", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());
		
		//-------------------------------------------------------------
		  get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("article1", "This is a freemarker field:Selfie + money + Snapchat = robbed! Don’t flash your cash…");
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
		//----------------------------------------------------------------------------------

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


