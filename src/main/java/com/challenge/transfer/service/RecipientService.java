package com.challenge.transfer.service;

import com.challenge.transfer.entity.recipient.GetRecipientRequest;
import com.challenge.transfer.entity.recipient.GetRecipientResponse;

public interface RecipientService {
    GetRecipientResponse getRecipientInformation(Integer recipientId);
}
