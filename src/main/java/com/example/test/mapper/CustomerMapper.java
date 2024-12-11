package com.example.test.mapper;

import com.example.test.dto.CustomerDto;
import com.example.test.model.Customer;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerMapper {

    public static CustomerDto toDto(Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .build();
    }

    public static Customer toEntity(CustomerDto customerDto) {
        return Customer.builder()
                .id(customerDto.getId())
                .name(customerDto.getName())
                .build();
    }
}
