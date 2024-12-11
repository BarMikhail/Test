package com.example.test.controller;


import com.example.test.dto.CustomerDto;
import com.example.test.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;


    //Поиск всех клиента
    @GetMapping
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomer();
    }

    //Поиск клиента по id
    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }


    //Создание клиента
    @PostMapping
    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.createCustomer(customerDto);
    }
}
