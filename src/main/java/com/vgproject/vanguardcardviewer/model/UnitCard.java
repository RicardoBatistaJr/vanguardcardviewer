package com.vgproject.vanguardcardviewer.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
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
    private String imageurlen;
    private String imageurljp;
    private String flavor;
    private String effect;
    private List<String> sets;
}
