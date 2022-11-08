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
    private String imageurlen;
}
