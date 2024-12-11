package com.example.test.repository;

import com.example.test.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByCustomerId(Long customerId);

    List<Contact> findByCustomerIdAndType(Long customerId, String type);
}
