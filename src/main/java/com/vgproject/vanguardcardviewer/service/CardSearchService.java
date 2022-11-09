package com.vgproject.vanguardcardviewer.service;

import com.vgproject.vanguardcardviewer.client.CardSearchClient;
import com.vgproject.vanguardcardviewer.dto.UnitCardDto;
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

    public UnitCard getCardById(Integer id){
        return cardSearchClient.getCardById(id);
    }

    public List<UnitCardResponse> getCards(String name, String clan){
        List<UnitCard> cards = cardSearchClient.getCards(name, clan).getData();
        return parseToUnitCardResponse(cards);
    }

    private List<UnitCardResponse> parseToUnitCardResponse(List<UnitCard> unitCards){
        List<UnitCardResponse> response = new ArrayList<>();
        for(UnitCard card: unitCards){
            UnitCardResponse unitCardResponse = new UnitCardResponse(card);
            response.add(unitCardResponse);
        }
        return response;
    }
}
