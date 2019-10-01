package com.auki.core.impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.auki.core.services.Test2Interface;
import com.auki.core.services.TestInterface;


@Component(service = TestInterface.class, immediate=true)


public class TestInterfaceImpl implements TestInterface {
	
	 @Reference
	 private Test2Interface test2interface;
	 
	 private String toReturn;
	 

	 public String CreatePage() 
	    {
		toReturn= test2interface.CreatePage2();
	    return toReturn;
	    }
}
