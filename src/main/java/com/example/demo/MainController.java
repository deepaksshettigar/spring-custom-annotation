package com.example.demo;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.AuditServiceImpl;
import com.example.demo.LogExecutionTime;
import com.example.demo.AuditProperties;


@RestController
public class MainController {
	
	@Autowired
	AuditService auditService; 
	
	
	@LogExecutionTime
	@RequestMapping("/service/audit")
	public String controller() {
		
		
		/*
		 * Class<? extends HelloController> cls = this.getClass(); Method mth = null;
		 * try { mth = cls.getMethod("hello"); } catch (NoSuchMethodException |
		 * SecurityException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); } LogExecutionTime annotation =
		 * mth.getAnnotation(LogExecutionTime.class);
		 * System.out.println("annotation enabled : " + annotation.enabled());
		 */
		
		AuditMessage auditMessage = new AuditMessage();
		auditMessage.put("record.id", "001");
		auditMessage.put("record.msg", "Audit Message Record");
		
		List<AuditMessage> listAuditMessages = new ArrayList<>();
		listAuditMessages.add(auditMessage);
		auditService.audit(listAuditMessages);
		
		System.out.println("Audit Service :: Continue to do some work");
		int interval = 5000;
		try {
			Thread.sleep(interval);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Controller :: task " + interval + " ms";
	}

	
}