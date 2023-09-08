package com.challenge.transfer.service;

import com.challenge.transfer.entity.recipient.GetRecipientRequest;
import com.challenge.transfer.entity.recipient.GetRecipientResponse;
import org.springframework.http.ResponseEntity;

public interface RecipientService {
    ResponseEntity<?> getRecipientInformation(Integer recipientId);
}
