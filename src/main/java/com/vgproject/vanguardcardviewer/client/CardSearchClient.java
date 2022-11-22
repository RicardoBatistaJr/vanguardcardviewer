package com.vgproject.vanguardcardviewer.client;

import com.vgproject.vanguardcardviewer.config.CardSearchClientFallbackFactory;
import com.vgproject.vanguardcardviewer.config.CardSearchInterfaceConfig;
import com.vgproject.vanguardcardviewer.dto.UnitCardDto;
import com.vgproject.vanguardcardviewer.model.Data;
import com.vgproject.vanguardcardviewer.model.UnitCard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(value="cardSearchFeignClient", url="${api.Baseurl}",
                                            configuration = CardSearchInterfaceConfig.class,
                                            fallbackFactory = CardSearchClientFallbackFactory.class
                                            )
public interface CardSearchClient {

    @GetMapping("/card")
    UnitCard getCardById(@RequestParam("id") Integer id);

    @GetMapping("/cards")
    Data getCards(@SpringQueryMap UnitCardDto unitCardDto);

}
