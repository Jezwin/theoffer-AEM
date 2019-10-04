package com.auki.core.models;


import java.util.ArrayList;
import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;

import com.auki.core.services.OfferService;
import com.day.cq.wcm.api.Page;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;


@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class OfferList {


	 
	 @Inject
	 private ResourceResolver resourceResolver; 
	 
	 @Inject
	 private String text;
	 
	 @Inject
	 private String eventStartDate;
	 
	 @Inject
	 private String eventEndDate;
	 
	 

	 
	


	public String getEventStartDate() {
		return eventStartDate;
	}


	public void setEventStartDate(String eventStartDate) {
		this.eventStartDate = eventStartDate;
	}


	public String getEventEndDate() {
		return eventEndDate;
	}


	public void setEventEndDate(String eventEndDate) {
		this.eventEndDate = eventEndDate;
	}



	private String childName;

	 
	 public String getChildName() {
		return childName;
	}


	public void setChildName(String childName) {
		this.childName = childName;
	}



	 private ArrayList<OfferModel> offerList = new ArrayList<>();
	 
	
	 
	

//
//	public Page getPage() {
//		return page;
//	}
//
//
//	public void setPage(Page page) {
//		this.page = page;
//	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}
	
	


	@PostConstruct
	 protected void init() {
		
		try {
			String pagePath = "/content/auki/test/offerlandingpage";
		    Resource resource = resourceResolver.getResource(pagePath);
		    Page parentPage = resource.adaptTo(Page.class);
		    Iterator<Page> children = parentPage.listChildren();
		    while(children.hasNext()) {
		    	Page childPage = children.next();
		    	childName = childPage.getName();
			    try {
			    
	
			    	Resource getResource = resourceResolver.getResource("/content/auki/test/offerlandingpage/"+childName+"/jcr:content/root/responsivegrid/image");
			 	    ValueMap properties = getResource.adaptTo(ValueMap.class);
			 	    String imagePath = properties.get("fileReference", String.class);
			 	    String title = properties.get("jcr:createdBy", String.class);
			 	    String description = properties.get("jcr:created", String.class);
			 	    OfferModel newOffer = new OfferModel(imagePath, title, description);
			 	    offerList.add(newOffer);
			 	   
			    
			    }
			    catch(Exception e) {}
		    }
		      
//			page = parentPage;
			
		}
		catch(Exception e) {}
	 }


	
	 public ArrayList<OfferModel> getOffer() {
			return offerList;
		}


	
	 
}
