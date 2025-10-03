package com.manuBank.accounts.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAwareImp")
public class AuditAwareImp implements AuditorAware {
    @Override
    public Optional getCurrentAuditor() {
        return Optional.of("Account_microservices_yrl");
    }
}
