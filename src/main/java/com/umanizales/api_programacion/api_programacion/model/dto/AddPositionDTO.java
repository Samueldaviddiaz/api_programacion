package com.umanizales.api_programacion.api_programacion.model.dto;
import com.umanizales.api_programacion.api_programacion.model.Kid;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class AddPositionDTO {

    private int position;
    private Kid kid;
}