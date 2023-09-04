package com.challenge.transfer.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestOperations;

@Component
public class RestHelper {

    @Autowired
    private RestOperations restTemplate;

    public String createUrl(String urlBase, String path) {
        final String url = urlBase + path;
        return url;
    }

    public <T> ResponseEntity<T> executeServiceCall(String urlCall, HttpEntity<?> requestEntity,
                                                             Class<T> responseType, HttpMethod method) {
        try {
            final ResponseEntity<T> response
                    = this.restTemplate.exchange(urlCall, method, requestEntity, responseType);
            return response;
        } catch(HttpStatusCodeException e) {
            return (ResponseEntity<T>) ResponseEntity.status(e.getRawStatusCode())
                    .headers(e.getResponseHeaders())
                    .body(e.getResponseBodyAsString());
        } catch (ResourceAccessException e) {
            return (ResponseEntity<T>) ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body("Service unavailable due to a network issue.");
        } catch (RestClientException e) {
            return (ResponseEntity<T>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal server error occurred.");
        }
    }
}
