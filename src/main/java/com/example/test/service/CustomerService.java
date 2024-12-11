package com.example.test.service;

import com.example.test.exception.NotFoundException;
import com.example.test.dto.CustomerDto;
import com.example.test.mapper.CustomerMapper;
import com.example.test.model.Customer;
import com.example.test.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<CustomerDto> getAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(CustomerMapper::toDto)
                .collect(Collectors.toList());
    }

    public CustomerDto getCustomerById(Long id) {
        return CustomerMapper.toDto(customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found")));
    }

    @Transactional
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.toEntity(customerDto);
        customerRepository.save(customer);
        return CustomerMapper.toDto(customer);
    }
}
