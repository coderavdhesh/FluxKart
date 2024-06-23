package com.avdhesh.fluxkart.controller;

import com.avdhesh.fluxkart.entity.Contact;
import com.avdhesh.fluxkart.service.serviceCode.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/identify")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public ResponseEntity<?> identify(@RequestBody Map<String, Object> payload) {
        String email = (String) payload.get("email");
        String phoneNumber = (String) payload.get("phoneNumber");

        Contact consolidatedContact = contactService.consolidateContact(email, phoneNumber);

        // Build the response payload
        Map<String, Object> response = new HashMap<>();
        response.put("primaryContactId", consolidatedContact.getId());
        response.put("emails", Collections.singletonList(consolidatedContact.getEmail()));
        response.put("phoneNumbers", Collections.singletonList(consolidatedContact.getPhoneNumber()));
        response.put("secondaryContactIds", new ArrayList<>()); // Simplified for now

        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("contact", response);

        return ResponseEntity.ok(responseBody);
    }
}
