package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class AuditMessage {
	
	Map<String, Object> auditMessageMap = new HashMap<>();
	
	AuditMessage() {
		
	}
	
	public void put(String key, Object value) {
		this.auditMessageMap.put(key, value);
	}
	
	public Object get(String key) {
		return this.auditMessageMap.get(key);
	}
		

}
