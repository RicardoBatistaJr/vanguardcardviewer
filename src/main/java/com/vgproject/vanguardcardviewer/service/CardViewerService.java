package com.vgproject.vanguardcardviewer.service;

import com.google.gson.Gson;
import com.vgproject.vanguardcardviewer.dto.UnitCardResponse;
import com.vgproject.vanguardcardviewer.model.UnitCard;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CardViewerService {

    public UnitCardResponse buscarCard(@NonNull int id){
        String uri = "https://card-fight-vanguard-api.ue.r.appspot.com/api/v1/card?id="+Integer.toString(id);
        RestTemplate restTemplate = new RestTemplate();
        String stringJson = restTemplate.getForObject(uri, String.class);
        Gson gson = new Gson();
        UnitCard unitCard = gson.fromJson(stringJson, UnitCard.class);
        UnitCardResponse response = new UnitCardResponse(unitCard);
        System.out.println(unitCard.toString());
        System.out.println(response.toString());
        return response;
    }
}
