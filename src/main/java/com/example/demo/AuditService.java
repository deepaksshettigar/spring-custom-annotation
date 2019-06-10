package com.example.demo;

import java.util.List;
import java.util.concurrent.Future;

public interface AuditService {
	Future<String> audit(List<AuditMessage> listAuditMessages);
}
