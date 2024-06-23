package com.avdhesh.fluxkart.service.serviceCode;

import com.avdhesh.fluxkart.entity.Contact;
import com.avdhesh.fluxkart.entity.LinkPrecedence;
import com.avdhesh.fluxkart.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact consolidateContact(String email, String phoneNumber) {
        List<Contact> existingContacts = contactRepository.findByEmailOrPhoneNumber(email, phoneNumber);

        // If no existing contacts, create a new primary contact
        if (existingContacts.isEmpty()) {
            Contact newContact = new Contact();
            newContact.setEmail(email);
            newContact.setPhoneNumber(phoneNumber);
            newContact.setLinkPrecedence(LinkPrecedence.PRIMARY);
            newContact.setCreatedAt(new Date());
            newContact.setUpdatedAt(new Date());
            contactRepository.save(newContact);
            return newContact;
        }

        // Logic to consolidate contacts and link them
        // ...

        return existingContacts.get(0); // Simplified return for now
    }
}
