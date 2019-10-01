package com.auki.core.impl;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.auki.core.services.PageService;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;


@Component(service = PageService.class, immediate=true)
public class PageServiceImpl implements PageService {
	

	@Reference
	private ResourceResolverFactory resolverFactory;
	private ResourceResolver resourceResolver; 
   
	public String CreatePage(String pageName) 
    {
//    String pagePath = "/content/auki/test/offerlandingpage";
//    String templatePath = "/apps/auki/templates/page-home";
//    String pageTitle = "Testing Page Automation";
   
    PageManager pageManager=resourceResolver.adaptTo(PageManager.class);
//    Page newPage;   
    Page currentPage = pageManager.getPage("/content/page/en/");    
    return currentPage.getTitle();  
 
   
    
   
//    	try {
//    		
//			newPage = pageManager.create(pagePath, pageName, templatePath, pageTitle);
//			Node pageNode = newPage.adaptTo(Node.class);
//			Node jcrNode = null;
//			 if (newPage.hasContent()) {
//
//				 
//				    jcrNode = newPage.getContentResource().adaptTo(Node.class);
//				   
//				   } else {                   
//				    try {
//						jcrNode = pageNode.addNode("jcr:content", "cq:PageContent");
//					} catch (RepositoryException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				   } 
//			return "Hi";
//		} catch (WCMException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//   
//         
//    return pageName; 
   
 
}
 
}
