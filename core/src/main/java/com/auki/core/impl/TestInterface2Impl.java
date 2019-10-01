package com.auki.core.impl;

import org.osgi.service.component.annotations.Component;

import com.auki.core.services.Test2Interface;

@Component(service = Test2Interface.class, immediate=true)
public class TestInterface2Impl implements Test2Interface {

	 public String CreatePage2() 
	    {
	    return "Testing with Sevice inside Service";
	    }
}
