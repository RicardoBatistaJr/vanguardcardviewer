package com.vgproject.vanguardcardviewer.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class Data {
    List<UnitCard> data;
}