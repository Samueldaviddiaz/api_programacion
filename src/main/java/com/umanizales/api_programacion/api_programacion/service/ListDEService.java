package com.umanizales.api_programacion.api_programacion.service;
import com.umanizales.api_programacion.api_programacion.model.Kid;
import com.umanizales.api_programacion.api_programacion.model.ListDE;
import com.umanizales.api_programacion.api_programacion.model.Node;
import com.umanizales.api_programacion.api_programacion.model.dto.AddPositionDTO;
import com.umanizales.api_programacion.api_programacion.model.dto.FirstLetterAgeDTO;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ListDEService {
    private ListDE list= new ListDE();

    public Node getAllLinked(){
        return this.list.enlist();
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

    public  String invert() throws Exception {
        list.invert();
        return "Kids changes";
    }
    public  String mixByGender()
    {
        list.mixByGender();
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
}

