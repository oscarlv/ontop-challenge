package com.challenge.transfer.service;

import com.challenge.transfer.entity.recipient.GetRecipientResponse;
import com.challenge.transfer.helper.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import static com.challenge.transfer.TransferConstants.PATH_GET_RECIPIENT;

@Service
public class RecipientServiceImpl implements RecipientService{

    @Value("${service.recipient.base.url}")
    private String baseUrlRecipient;

    @Autowired
    private RestHelper restHelper;

    @Override
    public GetRecipientResponse getRecipientInformation(Integer recipientId) {
        UriComponents builder
                = UriComponentsBuilder
                .fromUriString(PATH_GET_RECIPIENT).buildAndExpand(recipientId);

        String recipientServiceUrl = restHelper.createUrl(baseUrlRecipient, builder.toString());

        return restHelper.executeServiceCall(recipientServiceUrl, null,
                GetRecipientResponse.class, HttpMethod.GET);
    }
}
