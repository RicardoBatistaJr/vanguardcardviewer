package com.vgproject.vanguardcardviewer.client;

import com.vgproject.vanguardcardviewer.config.CardSearchInterfaceConfig;
import com.vgproject.vanguardcardviewer.dto.UnitCardResponse;
import com.vgproject.vanguardcardviewer.model.JsonIncome;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@FeignClient(value="card", url="https://card-fight-vanguard-api.ue.r.appspot.com/api/v1", configuration =
    CardSearchInterfaceConfig.class)
@RestController
public interface CardSearchClient {

    @GetMapping("/cards")
    JsonIncome getAllCardsFeign();

    @GetMapping("/cards?name={name}")
    UnitCardResponse getCardByName(@PathVariable(value = "name") String name);
}
