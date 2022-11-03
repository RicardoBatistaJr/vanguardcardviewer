package com.vgproject.vanguardcardviewer.controller;

import com.vgproject.vanguardcardviewer.dto.UnitCardResponse;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name = "get-cards", url = "https://card-fight-vanguard-api.ue.r.appspot.com/api/v1/cards")
public interface FeignTestInterface {
    @GetMapping("/getAllCardsFeign")
    List<UnitCardResponse> getAllCardsFeign();
}
