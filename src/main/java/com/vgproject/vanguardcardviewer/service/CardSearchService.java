package com.vgproject.vanguardcardviewer.service;

import com.vgproject.vanguardcardviewer.client.CardSearchClient;
import com.vgproject.vanguardcardviewer.dto.UnitCardDto;
import com.vgproject.vanguardcardviewer.dto.UnitCardResponse;
import com.vgproject.vanguardcardviewer.exception.CardNotFoundException;
import com.vgproject.vanguardcardviewer.model.UnitCard;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardSearchService {

    public final CardSearchClient cardSearchClient;

    public UnitCardResponse getCardById(Integer id){
        UnitCard teste = cardSearchClient.getCardById(id);
        UnitCardResponse response = new UnitCardResponse(teste);
        return response;
    }

    public List<UnitCardResponse> getCards(UnitCardDto unitCardDto, Integer page){
        List<UnitCard> cards = cardSearchClient.getCards(unitCardDto, page).getData();
//        if(cards.isEmpty()) throw new CardNotFoundException();'

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
