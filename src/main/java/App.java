import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {

    	String layout = "templates/layout.vtl";
		// To locate the resources for the project
		// staticFileLocation("/public");
		//Port Number
		port(1234);
		//form route
    	get("/", (request, response) -> {
    		Map<String, Object> model = new HashMap<String, Object> ();
    		model.put("template", "templates/form.vtl");
    		return new ModelAndView(model, layout);
    	}, new VelocityTemplateEngine());

    	//story route
    	get("/story", (request, response) -> {
    		Map<String, Object> model = new HashMap<String, Object> ();
    		//get the params from the form that is submitted
    		 model.put("person1", request.queryParams("person1"));
		      model.put("person2", request.queryParams("person2"));
		      model.put("animal", request.queryParams("animal"));
		      model.put("exclamation", request.queryParams("exclamation"));
		      model.put("verb", request.queryParams("verb"));
		      model.put("noun", request.queryParams("noun"));
    		model.put("template", "templates/story.vtl");
    		return new ModelAndView(model, layout);
    	}, new VelocityTemplateEngine());
    	
    }
}
