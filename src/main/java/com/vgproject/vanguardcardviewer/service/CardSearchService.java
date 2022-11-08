package com.vgproject.vanguardcardviewer.service;

import com.vgproject.vanguardcardviewer.client.CardSearchClient;
import com.vgproject.vanguardcardviewer.dto.UnitCardResponse;
import com.vgproject.vanguardcardviewer.model.UnitCard;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardSearchService {
    public final CardSearchClient cardSearchClient;

    public List<UnitCardResponse> getAllCards(){
        List<UnitCard> cards = cardSearchClient.getAllCardsFeign().getData();
        List<UnitCardResponse> response = new ArrayList<>();
        for(UnitCard card: cards){
            UnitCardResponse unitCardResponse = new UnitCardResponse(card);
            response.add(unitCardResponse);
        }
        return response;
    }
}
