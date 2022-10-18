package com.vgproject.vanguardcardviewer.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class UnitCard {
    private int id;
    private String name;
    private String clan;
    @SerializedName("imageurlen")
    private String imageUrlEn;
    @SerializedName("imageurljp")
    private String imageUrlJp;
    private String flavor;
    private String effect;
    private String set;
}
