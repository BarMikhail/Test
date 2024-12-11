package com.example.test.service;

import com.example.test.dto.ContactDto;
import com.example.test.mapper.ContactMapper;
import com.example.test.model.Contact;
import com.example.test.model.Customer;
import com.example.test.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class ContactService {

    private ContactRepository contactRepository;

    public List<ContactDto> getAllContactsByCustomerId(Long customerId) {
        List<Contact> contacts = contactRepository.findByCustomerId(customerId);
        return contacts.stream()
                .map(ContactMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<ContactDto> getAllContactsByCustomerIdAndType(Long customerId, String type) {
        List<Contact> contacts = contactRepository.findByCustomerIdAndType(customerId, type);
        return contacts.stream()
                .map(ContactMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public ContactDto createContact(Long customerId, ContactDto contactDto) {
        Contact contact = ContactMapper.toEntity(contactDto);
        contact.setCustomer(new Customer());
        contact.getCustomer().setId(customerId);
        contact = contactRepository.save(contact);
        return ContactMapper.toDto(contact);
    }
}
