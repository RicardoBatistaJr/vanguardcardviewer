package com.vgproject.vanguardcardviewer.controller;

import com.vgproject.vanguardcardviewer.dto.UnitCardResponse;
import com.vgproject.vanguardcardviewer.service.CardSearchService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class CardSearchController {

    private final CardSearchService cardSearchService;

    @GetMapping("/getAllCards")
    ResponseEntity<List<UnitCardResponse>> getAllCards(){
        return new ResponseEntity<>(cardSearchService.getAllCards(), HttpStatus.OK);
    }
}
