package com.vgproject.vanguardcardviewer.config;

import com.vgproject.vanguardcardviewer.client.CardSearchClient;
import com.vgproject.vanguardcardviewer.dto.UnitCardDto;
import com.vgproject.vanguardcardviewer.exception.ApiCallException;
import com.vgproject.vanguardcardviewer.model.Data;
import com.vgproject.vanguardcardviewer.model.UnitCard;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CardSearchClientFallbackFactory implements FallbackFactory<CardSearchClient> {


    @Override
    public CardSearchClient create(Throwable cause) {
        return new CardSearchClient() {
            @Override
            public UnitCard getCardById(Integer id) {
                return new UnitCard();
            }

            @Override
            public Data getCards(UnitCardDto unitCardDto) {
                UnitCard un = new UnitCard();
                un.setName("placeholder");
                un.setImageurlen("https://m.media-amazon.com/images/I/8187kSHhJCL._AC_SY606_.jpg");
                List<UnitCard> list = new ArrayList<>();
                list.add(un);
                return new Data(list);
            }
        };
    }
}
