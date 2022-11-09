package com.vgproject.vanguardcardviewer.controller;

import com.vgproject.vanguardcardviewer.dto.UnitCardDto;
import com.vgproject.vanguardcardviewer.dto.UnitCardResponse;
import com.vgproject.vanguardcardviewer.model.Data;
import com.vgproject.vanguardcardviewer.model.UnitCard;
import com.vgproject.vanguardcardviewer.service.CardSearchService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class CardSearchController {

    private final CardSearchService cardSearchService;

    @GetMapping("/getCards")
    @ResponseStatus(HttpStatus.OK)
    List<UnitCardResponse> getCards(@RequestParam (required = false) String name,
                                    @RequestParam(required = false) String clan){
        return cardSearchService.getCards(name, clan);
    }


    @GetMapping("/getCardById")
    ResponseEntity<UnitCard> getCardById(@RequestParam ("id") Integer id){
        return new ResponseEntity<>(cardSearchService.getCardById(id), HttpStatus.OK);
    }
}
