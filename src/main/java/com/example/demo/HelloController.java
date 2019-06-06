package com.example.demo;

import java.lang.reflect.Method;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloController {
	
	@Autowired
	HelloService helloService; 
	
	@LogExecutionTime(enabled=true)
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
		helloService.utilMethod("Start");
		System.out.println("HC : Continue to do some work");
		int interval = 2000;
		try {
			Thread.sleep(interval*2);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Hello Working for " + interval + " ms";
	}

	
}