package com.manuBank.accounts.repository;

import com.manuBank.accounts.entity.Accounts;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    Optional<Accounts> findByCustomerId(Integer customerId);

    @Transactional
    @Modifying
    public void deleteByCustomerId(Integer customerId);

}
