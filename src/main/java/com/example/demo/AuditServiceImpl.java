package com.example.demo;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class AuditServiceImpl implements AuditService {
	
		@LogExecutionTime(enabled=true)
		@Async
		@Override
		public Future<String> audit(AuditMessage auditMessageRecord) {
			System.out.println("Auditing Aysnc Service" + auditMessageRecord.get("record.id"));
			try {
				Thread.sleep(7000);
				return new AsyncResult<String>("hello world !!!!");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
			
		}

}
