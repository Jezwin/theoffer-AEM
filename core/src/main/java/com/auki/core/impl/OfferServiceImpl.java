package com.auki.core.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ValueMap;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.auki.core.models.OfferModel;
import com.auki.core.services.OfferService;
import com.day.cq.wcm.api.Page;




@Component(service = OfferService.class, immediate=true)
public class OfferServiceImpl implements OfferService {
	

	@Reference
	private ResourceResolverFactory resourceResolverFactory; 
	
	
	
   
	public ArrayList<OfferModel> ListOffer() 
    {
		ArrayList<OfferModel> offerList = new ArrayList<>();
		final Map<String, Object> params = new HashMap<>();
		params.put(ResourceResolverFactory.SUBSERVICE, "testing");
		ResourceResolver resourceResolver = null;
		
		try {
			resourceResolver = resourceResolverFactory.getServiceResourceResolver(params);
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			String pagePath = "/content/auki/test/offerlandingpage";
		    Resource resource = resourceResolver.getResource(pagePath);
		    Page parentPage = resource.adaptTo(Page.class);
		    Iterator<Page> children = parentPage.listChildren();
		    while(children.hasNext()) {
		    	Page childPage = children.next();
		    	String childName = childPage.getName();
			    try {
			    
	
			    	Resource getResource = resourceResolver.getResource("/content/auki/test/offerlandingpage/"+childName+"/jcr:content/root/responsivegrid/image");
			 	    ValueMap properties = getResource.adaptTo(ValueMap.class);
			 	    String imagePath = properties.get("fileReference", String.class);
			 	    String title = properties.get("jcr:createdBy", String.class);
			 	    String description = properties.get("jcr:created", String.class);
			 	    OfferModel newOffer = new OfferModel(imagePath, title, description);
			 	    offerList.add(newOffer);
			 	   
			    
			    }
			    catch(Exception e) {
			    	
			    }
		    }
			
		}
		catch(Exception e) {
			
		}
		
		return offerList;
	 }

		
	
 }

