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
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

import com.auki.core.models.OfferModel;
import com.auki.core.services.OfferService;
import com.day.cq.wcm.api.Page;




@Component(service = OfferService.class, immediate=true)
@Designate(ocd = OfferServiceImpl.Config.class)
public class OfferServiceImpl implements OfferService {
	
	@ObjectClassDefinition(name = "Test config", description = "Test config properties" )
	public static @interface Config {
		@AttributeDefinition(name = "path value")
		String path_value() default "/content/auki/test/offerlandingpage";
		
		@AttributeDefinition(name = "max offer")
		int max_offer() default 4;
		
	}
	

	@Reference
	private ResourceResolverFactory resourceResolverFactory; 
	
	private String pathValue;
	
	private int maxOffer;
	
	@Activate
	protected void activate(final Config config) {
		this.pathValue = config.path_value();
		this.maxOffer = config.max_offer();
	}
	
	
	
   
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
			//String pagePath = "/content/auki/test/offerlandingpage";
		    Resource resource = resourceResolver.getResource(pathValue);
		    Page parentPage = resource.adaptTo(Page.class);
		    Iterator<Page> children = parentPage.listChildren();
		    int count =1;
		    while(children.hasNext() && count<=maxOffer) {
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
			    count++;
		    }
			
		}
		catch(Exception e) {
			
		}
		
		return offerList;
	 }

		
	
 }

