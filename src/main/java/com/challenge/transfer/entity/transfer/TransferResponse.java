package com.challenge.transfer.entity.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TransferResponse {
    private Integer transactionId;
    private String transactionType;
    private String completedDate;
}
