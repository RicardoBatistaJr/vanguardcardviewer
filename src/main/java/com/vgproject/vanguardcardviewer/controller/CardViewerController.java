package com.vgproject.vanguardcardviewer.controller;

import com.vgproject.vanguardcardviewer.dto.UnitCardDto;
import com.vgproject.vanguardcardviewer.service.CardViewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;

@Controller
public class CardViewerController {

    @Autowired
    CardViewerService cardViewerService;

    @GetMapping ("/getAllCards")
    public ResponseEntity<String> getAllCards(){
        String uri = "https://card-fight-vanguard-api.ue.r.appspot.com/api/v1/cards";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/getCard")
    public String getCard(@RequestBody UnitCardDto unitCardDto){
        cardViewerService.buscarCard(unitCardDto.getId());
        return "";
    }
}
