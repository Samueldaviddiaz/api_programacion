package com.umanizales.api_programacion.api_programacion.service;

import com.umanizales.api_programacion.api_programacion.model.Kid;
import com.umanizales.api_programacion.api_programacion.model.ListSE;
import com.umanizales.api_programacion.api_programacion.model.dto.AddPositionDTO;
import com.umanizales.api_programacion.api_programacion.model.dto.FirstLetterAgeDTO;
import com.umanizales.api_programacion.api_programacion.model.dto.RangeByAgeDTO;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class ListSEService {
    private ListSE list;

    public ListSEService() {
        list = new ListSE();
        list.add(new Kid("1002654940", "Jeronimo Murillo", (byte) 19, 'M'));
        list.add(new Kid("34344343", "Pedro Pérez", (byte) 16, 'M'));
        list.add(new Kid("475473456", "Paula Sánchez", (byte) 20, 'F'));
    }
    public String add(Kid kid)
    {
        list.add(kid);
        return "Kid added";
    }

    public String addToStart(Kid kid)
    {
        list.addToStart(kid);
        return "Kid added";
    }

    public  String deleteToPosition(int position)
    {
        list.deleteToPosition(position);
        return "Kid delete";
    }

    public  String deleteByData(Kid kid)
    {
        list.deleteByData(String.valueOf(kid));
        return "Kid delete";
    }

    public  String changeFirstLast()
    {
        list.changeFirstLast();
        return "Kids changes";
    }

    public  String invert()
    {
        list.invert();
        return "Kids changes";
    }
    public  String mixByGender()
    {
        list.mixByGender();
        return "Kids mix";
    }

    public  String deleteLetterAge(FirstLetterAgeDTO firstLetterAgeDTO)
    {
        list.deleteLetterAge(firstLetterAgeDTO);
        return "Kid add";
    }

    public  String mix()
    {
        list.mix();
        return "Kids mix";
    }
    public String count()
    {
        list.count();
        return "Kid successfully delete";
    }
    public  String addToPosition(AddPositionDTO addPositionDTO)
    {
        list.addToPosition(addPositionDTO);
        return "Kid add";}

    public List<RangeByAgeDTO> getRange()
    {
        List<RangeByAgeDTO> ranges= new ArrayList<>();
        ranges.add(new RangeByAgeDTO(1,4,list.rangeByAge(1,4)));
        ranges.add(new RangeByAgeDTO(5,10, list.rangeByAge(5,9)));
        ranges.add(new RangeByAgeDTO(10,14, list.rangeByAge(10,14)));
        ranges.add(new RangeByAgeDTO(15,18, list.rangeByAge(15,18)));
        return ranges;
    }
}