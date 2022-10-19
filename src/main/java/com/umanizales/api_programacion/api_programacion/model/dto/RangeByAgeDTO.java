package com.umanizales.api_programacion.api_programacion.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class RangeByAgeDTO {
    private int rangeStart;
    private int rangeEnd;
    private int quantity;}