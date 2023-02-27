package com.vgproject.vanguardcardviewer.dto;

import com.google.gson.annotations.SerializedName;
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
    private String imageurl;

    private String effect;

    private String flavor;

    public UnitCardResponse(@NonNull UnitCard unitCard){
        this.id = unitCard.getId();
        this.name = unitCard.getName();
        this.clan = unitCard.getClan();
        this.effect = unitCard.getEffect();
        this.flavor = unitCard.getFlavor();
        if(unitCard.getImageurlen() == null || unitCard.getImageurlen().isEmpty()){
            this.imageurl = unitCard.getImageurljp();
        }else{ this.imageurl = unitCard.getImageurlen();}
    }

}
