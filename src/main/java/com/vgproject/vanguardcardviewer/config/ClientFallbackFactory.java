package com.vgproject.vanguardcardviewer.config;

import com.vgproject.vanguardcardviewer.client.CardSearchClient;
import com.vgproject.vanguardcardviewer.dto.UnitCardDto;
import com.vgproject.vanguardcardviewer.model.Data;
import com.vgproject.vanguardcardviewer.model.UnitCard;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ClientFallbackFactory implements FallbackFactory<CardSearchClient>, CardSearchClient{
    private final String imageUrl;
    public ClientFallbackFactory(@Value("${api.DefaultCardUrl}") String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public CardSearchClient create(Throwable cause) {
        final var unitCard = new UnitCard("not_found", imageUrl);
        return new CardSearchClient() {
            @Override
            public UnitCard getCardById(Integer id) {
                return unitCard;
            }
            @Override
            public Data getCards(UnitCardDto unitCardDto) {
                return new Data(List.of(unitCard));
            }
        };
    }

    @Override
    public UnitCard getCardById(Integer id) {
        return null;
    }

    @Override
    public Data getCards(UnitCardDto unitCardDto) {
        return null;
    }
}
