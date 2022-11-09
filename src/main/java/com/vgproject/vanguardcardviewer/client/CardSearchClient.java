package com.vgproject.vanguardcardviewer.client;

import com.vgproject.vanguardcardviewer.config.CardSearchInterfaceConfig;
import com.vgproject.vanguardcardviewer.dto.UnitCardDto;
import com.vgproject.vanguardcardviewer.model.Data;
import com.vgproject.vanguardcardviewer.model.UnitCard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="cardSearchFeignClient", url="https://card-fight-vanguard-api.ue.r.appspot.com/api/v1",
    configuration =
    CardSearchInterfaceConfig.class)
public interface CardSearchClient {

    @GetMapping("/cards")
    Data getCards(@RequestParam(required = false)String name,
                     @RequestParam(required = false)String clan);


    @GetMapping("/card")
    UnitCard getCardById(@RequestParam("id") Integer id);
}
