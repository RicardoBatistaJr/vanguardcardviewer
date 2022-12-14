package com.vgproject.vanguardcardviewer.controller;

import com.vgproject.vanguardcardviewer.dto.UnitCardDto;
import com.vgproject.vanguardcardviewer.dto.UnitCardResponse;
import com.vgproject.vanguardcardviewer.model.UnitCard;
import com.vgproject.vanguardcardviewer.service.CardSearchService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class CardSearchController {

    @Autowired
    private CardSearchService cardSearchService; //Add final in case of use Constructor

//    public CardSearchController(CardSearchService cardSearchService) {this.cardSearchService = cardSearchService;}


    @GetMapping("/getCardById")
    @ResponseStatus(HttpStatus.OK)
    UnitCardResponse getCardById(@RequestParam ("id") Integer id){
        return cardSearchService.getCardById(id);
    }

    @GetMapping("/getCardsByObject")
    @ResponseStatus(HttpStatus.OK)
    List<UnitCardResponse> getCards(UnitCardDto unitCardDto){
        return cardSearchService.getCards(unitCardDto);
    }

}
