package com.vgproject.vanguardcardviewer.dto;

import com.vgproject.vanguardcardviewer.model.UnitCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class UnitCardResponse {
    private int id;
    private String name;
    private String clan;
    private String imageUrl;

    public UnitCardResponse(@NonNull UnitCard unitCard){
        this.id = unitCard.getId();
        this.name = unitCard.getName();
        this.clan = unitCard.getClan();
        if(unitCard.getImageUrlEn() != null || !unitCard.getImageUrlEn().isEmpty()){
            this.imageUrl = unitCard.getImageUrlEn();
        }else{ this.imageUrl = unitCard.getImageUrlJp();}
    }
}
