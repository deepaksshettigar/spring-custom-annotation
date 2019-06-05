package com.example.demo;

import java.lang.reflect.Method;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		/*
		 * Class<? extends HelloController> cls = this.getClass(); Method mth = null;
		 * try { mth = cls.getMethod("hello"); } catch (NoSuchMethodException |
		 * SecurityException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); } LogExecutionTime annotation =
		 * mth.getAnnotation(LogExecutionTime.class);
		 * System.out.println("annotation enabled : " + annotation.enabled());
		 */
		utilMethod("Start");
		
		int interval = 2000;
		try {
			Thread.sleep(interval*2);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Hello Working for " + interval + " ms";
	}

	@LogExecutionTime(enabled=true)
	private String utilMethod(String args) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("UtilMethod " + args);
		return "UtilMethod " + args;
	}
}