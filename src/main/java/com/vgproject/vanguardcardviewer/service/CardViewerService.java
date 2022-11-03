package com.vgproject.vanguardcardviewer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.vgproject.vanguardcardviewer.dto.UnitCardResponse;
import com.vgproject.vanguardcardviewer.model.JsonIncome;
import com.vgproject.vanguardcardviewer.model.UnitCard;
import java.util.ArrayList;
import java.util.List;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CardViewerService {

    public UnitCardResponse getCard(@NonNull int id){
        String uri = "https://card-fight-vanguard-api.ue.r.appspot.com/api/v1/card?id="+Integer.toString(id);
        UnitCardResponse response = new UnitCardResponse(convertJsonToUnitCard(uri));
        return response;
    }

    public List<UnitCardResponse> getAllCards() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String uri = "https://card-fight-vanguard-api.ue.r.appspot.com/api/v1/cards";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);
        JsonIncome jsonIncome = mapper.readValue(result, JsonIncome.class);
        return convertUnitCardListToResponseList(jsonIncome.getData());
    }

    public UnitCard convertJsonToUnitCard(String uri){
        RestTemplate restTemplate = new RestTemplate();
        String stringJson = restTemplate.getForObject(uri, String.class);
        Gson gson = new Gson();
        UnitCard unitCard = gson.fromJson(stringJson, UnitCard.class);
        return unitCard;
    }

    public List<UnitCardResponse> convertUnitCardListToResponseList(List<UnitCard> unitCards){
        List<UnitCardResponse> unitCardResponses = new ArrayList<>();
        for(UnitCard card : unitCards){
            UnitCardResponse unitCardResponse = new UnitCardResponse(card);
            unitCardResponses.add(unitCardResponse);
        }
        return unitCardResponses;
    }
}
