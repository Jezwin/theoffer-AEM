package com.auki.core.impl;
 
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
 
 
import java.util.HashMap;
import java.util.Map;

import javax.jcr.Node;

import org.apache.jackrabbit.commons.JcrUtils;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ValueMap;

import com.auki.core.services.PageService;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
 
 
@Component
public class PageServiceImpl implements PageService {
     
     
    //Inject a Sling ResourceResolverFactory
    @Reference
	private ResourceResolverFactory resourceResolverFactory; 
     
     
    public void CreatePage(String name,String description,String date,String imagePath) 
    {
    String pagePath = "/content/auki/test/offerlandingpage";
    String templatePath = "/conf/auki/settings/wcm/templates/offer-template";
    String pageTitle = name;
    String pageName = name;
    Page newPage = null;
    PageManager pageManager; 
     
     
    final Map<String, Object> params = new HashMap<>();
	params.put(ResourceResolverFactory.SUBSERVICE, "testing");
	ResourceResolver resolver = null;
	
	try {
		resolver = resourceResolverFactory.getServiceResourceResolver(params);
	} catch (LoginException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       
    try {

        pageManager = resolver.adaptTo(PageManager.class); 
        newPage = pageManager.create(pagePath, pageName, templatePath, pageTitle);
//        if (newPage != null) {
//        	Node newNode = newPage.adaptTo(Node.class);
//        	Node cont = newNode.getNode("jcr:content");
//        	Node titleNode = JcrUtils.getNodeIfExists(cont, "root/responsivegrid/title");
//        	titleNode.setProperty("jcr:title", "name");
//        	Node imageNode = JcrUtils.getNodeIfExists(cont, "root/responsivegrid/image");
//        	imageNode.setProperty("fileReference", imagePath);
//        	Node descriptionNode = JcrUtils.getNodeIfExists(cont, "root/responsivegrid/image");
//        	descriptionNode.setProperty("fileReference", imagePath);
//        }
       
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    	
    String pgName =  newPage.getName();
    
	Resource getResourceTitle = resolver.getResource("/content/auki/test/offerlandingpage/"+pgName+"/jcr:content/root/responsivegrid/title");
	ModifiableValueMap mapTitle = getResourceTitle.adaptTo(ModifiableValueMap.class);
	mapTitle.put("jcr:title", name);
	mapTitle.put("jcr:lastModified", date);
	Resource getResourceText = resolver.getResource("/content/auki/test/offerlandingpage/"+pgName+"/jcr:content/root/responsivegrid/text");
	ModifiableValueMap mapText = getResourceText.adaptTo(ModifiableValueMap.class);
	mapText.put("text", description);
	Resource getResourceImage = resolver.getResource("/content/auki/test/offerlandingpage/"+pgName+"/jcr:content/root/responsivegrid/image");
	ModifiableValueMap mapImage = getResourceImage.adaptTo(ModifiableValueMap.class);
	mapImage.put("fileReference", imagePath);
	try {
		getResourceTitle.getResourceResolver().commit();
		getResourceText.getResourceResolver().commit();
		getResourceImage.getResourceResolver().commit();
	} catch (PersistenceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}