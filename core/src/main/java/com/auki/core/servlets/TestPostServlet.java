package com.auki.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.auki.core.services.PageService;

@Component(service=Servlet.class,
property={
        Constants.SERVICE_DESCRIPTION + "=Test Post Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_POST,
//        "sling.servlet.resourceTypes="+ "auki/components/structure/page",
        "sling.servlet.paths="+ "/bin/test2",
        "sling.servlet.extensions=" + "json"
})

public class TestPostServlet extends SlingAllMethodsServlet  {

	private static final long serialVersionUID = 1L;
	
	@Reference
	private PageService pageService;
	
	
 
    @Override
    protected void doPost(final SlingHttpServletRequest req,
            final SlingHttpServletResponse resp) throws ServletException, IOException {
    		
	    	
	    	String name = req.getParameter("name");
	    	String description = req.getParameter("description");
	    	String date = req.getParameter("date");
	    	String imagePath = req.getParameter("imagepath");
	    	pageService.CreatePage(name, description, date, imagePath);
	    	
	    	JSONObject obj = new JSONObject();
	    	
    		try {
    
				obj.put("name", name);
				obj.put("desc", description);
				obj.put("date", date);
				obj.put("imagepath", imagePath);
				//obj.put("page", page);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		resp.setContentType("application/json");
 	        resp.setCharacterEncoding("utf-8");
    		resp.getWriter().write(obj.toString());
    		
    		
    		
        
    }
}
