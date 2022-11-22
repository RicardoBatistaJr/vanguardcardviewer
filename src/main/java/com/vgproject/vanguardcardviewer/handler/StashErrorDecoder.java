package com.vgproject.vanguardcardviewer.handler;

import com.vgproject.vanguardcardviewer.exception.ApiCallException;
import com.vgproject.vanguardcardviewer.exception.CardNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import static feign.FeignException.errorStatus;

public class StashErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() >= 400 && response.status() <= 499) {
            return new CardNotFoundException();
        }
        if (response.status() >= 500 && response.status() <= 599) {
            return new ApiCallException();
        }
        return errorStatus(methodKey, response);
    }
}
