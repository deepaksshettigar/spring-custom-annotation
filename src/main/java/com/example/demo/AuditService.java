package com.example.demo;

import java.util.concurrent.Future;

public interface AuditService {
	Future<String> audit(AuditMessage auditRecord);
}
