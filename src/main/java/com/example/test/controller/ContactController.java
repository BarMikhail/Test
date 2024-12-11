package com.example.test.controller;

import com.example.test.dto.ContactDto;
import com.example.test.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers/{customerId}/contacts")
public class ContactController {

    private final ContactService contactService;

    //Получение всех контактов по ID клиента
    @GetMapping
    public List<ContactDto> getAllContactsByCustomerId(@PathVariable Long customerId) {
        return contactService.getAllContactsByCustomerId(customerId);
    }

    //Получение всех контактов по ID клиента и типу контакта
    @GetMapping("/type/{type}")
    public List<ContactDto> getAllContactsByCustomerIdAndType(@PathVariable Long customerId, @PathVariable String type) {
        return contactService.getAllContactsByCustomerIdAndType(customerId, type);
    }

    //Создание нового контакта
    @PostMapping
    public ContactDto createContact(@PathVariable Long customerId, @RequestBody ContactDto contactDto) {
        return contactService.createContact(customerId, contactDto);
    }
}
