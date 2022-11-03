package com.vgproject.vanguardcardviewer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vgproject.vanguardcardviewer.dto.UnitCardDto;
import com.vgproject.vanguardcardviewer.dto.UnitCardResponse;
import com.vgproject.vanguardcardviewer.service.CardViewerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name = "get-cards", url = "https://card-fight-vanguard-api.ue.r.appspot.com/api/v1/cards")
@Controller
public class CardViewerController {

    @Autowired
    CardViewerService cardViewerService;

    @GetMapping ("/getAllCards")
    public ResponseEntity<List<UnitCardResponse>> getAllCards() throws JsonProcessingException {
        List<UnitCardResponse> result = cardViewerService.getAllCards();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/getCardById")
    public ResponseEntity<UnitCardResponse> getCardById(@RequestBody UnitCardDto unitCardDto){
            if(unitCardDto.getId() == 0){
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }else{
                UnitCardResponse unitCardResponse = cardViewerService.getCard(unitCardDto.getId());
                return ResponseEntity.status(HttpStatus.OK).body(unitCardResponse);
            }
    }
}
