package com.example.demo;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
		@LogExecutionTime(enabled=true)
		@Async
		public Future<String>  utilMethod(String args) {
			System.out.println("UtilMethod " + args);
			try {
				Thread.sleep(8000);
				return new AsyncResult<String>("hello world !!!!");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
			
		}

}
