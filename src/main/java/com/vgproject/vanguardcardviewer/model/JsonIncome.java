package com.vgproject.vanguardcardviewer.model;

import com.google.gson.annotations.SerializedName;
import com.vgproject.vanguardcardviewer.dto.UnitCardResponse;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonIncome {
    List<UnitCardResponse> data;
}
