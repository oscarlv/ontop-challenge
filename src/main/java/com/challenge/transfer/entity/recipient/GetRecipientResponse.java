package com.challenge.transfer.entity.recipient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetRecipientResponse {
    private int recipientId;
    private int userId;
    private String routingNumber;
    private String nationalId;
    private String accountNumber;
}
