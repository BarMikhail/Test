package com.example.test.mapper;

import com.example.test.dto.ContactDto;
import com.example.test.model.Contact;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ContactMapper {

    public static ContactDto toDto(Contact contact) {
        return ContactDto.builder()
                .id(contact.getId())
                .type(contact.getType())
                .value(contact.getValue())
                .build();
    }

    public static Contact toEntity(ContactDto contactDto) {
        return Contact.builder()
                .id(contactDto.getId())
                .type(contactDto.getType())
                .value(contactDto.getValue())
                .build();
    }
}
