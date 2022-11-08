package com.vgproject.vanguardcardviewer.controller;

import com.vgproject.vanguardcardviewer.model.JsonIncome;
import com.vgproject.vanguardcardviewer.model.UnitCard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@FeignClient(value="card", url="https://card-fight-vanguard-api.ue.r.appspot.com/api/v1", decode404 = true)
@RestController
public interface FeignTestInterface {

    @RequestMapping(method = RequestMethod.GET, value = "/cards")
    JsonIncome getAllCardsFeign();
}
