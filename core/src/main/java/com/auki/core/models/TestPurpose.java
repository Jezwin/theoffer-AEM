package com.auki.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import com.auki.core.services.TestInterface;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;


@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TestPurpose {

	 @Inject
	 private TestInterface testinterface;
	 
	 @Inject
	 private String text;
	 
	
	 
	 public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}



	@PostConstruct
	 protected void init() {
		 text = testinterface.CreatePage();
	 }
	 
}
