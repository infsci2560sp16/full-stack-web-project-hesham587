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

public class ArticleController {
    private static ArrayList<Map<String, String>> arrayList ;
    Gson gson = new Gson();

    public ArticleController(final ArticleService ArticleService) {
       
        
        get("/Article", (req, res) -> {
            return ArticleService.getAllBooks();
        }, gson::toJson);

        get("/Article/:id", (req, res) -> {
			String id = req.params(":id");
			 
                         arrayList=ArticleService.getOneArticle(id);
			if (!arrayList.isEmpty()) {
				return arrayList;
			}
			
			return "[{\"" + id + "\":\"Could not find the Article you search for please try again. \"}]";
		}, gson::toJson);
    
    }

}
