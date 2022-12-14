package com.vgproject.vanguardcardviewer.model;

import java.util.List;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@lombok.Data
@NoArgsConstructor
@Component
public class Data {
    List<UnitCard> data;

    public Data(List<UnitCard> data){
        this.data = data;
    }
}
