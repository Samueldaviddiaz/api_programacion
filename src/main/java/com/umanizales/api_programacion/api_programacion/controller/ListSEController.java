package com.umanizales.api_programacion.api_programacion.controller;

import com.umanizales.api_programacion.api_programacion.model.Kid;
import com.umanizales.api_programacion.api_programacion.model.Node;
import com.umanizales.api_programacion.api_programacion.model.dto.AddPositionDTO;
import com.umanizales.api_programacion.api_programacion.model.dto.FirstLetterAgeDTO;
import com.umanizales.api_programacion.api_programacion.model.dto.RangeByAgeDTO;
import com.umanizales.api_programacion.api_programacion.service.ListSEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/listse")
public class ListSEController {
    @Autowired
    private ListSEService listSEService;

    @GetMapping
    public Node getList()
    {
        return listSEService.getList().getHead();
    }

    @PostMapping(path = "/add")
    public String add(@RequestBody Kid kid)
    {
        return listSEService.add(kid);
    }

    @PostMapping(path = "/addtostart")
    public String addKidToStart(@RequestBody Kid kid)
    {
        return listSEService.addToStart(kid);
    }

    @GetMapping(path = "/deletetoposition")
    public String deleteToPosition(@RequestBody int position)
    {
        return listSEService.deleteToPosition(position);
    }

    @PostMapping(path = "/deletebydata")
    public String deleteByData(@RequestBody Kid kid)
    {
        return listSEService.deleteByData(kid);
    }

    @GetMapping(path = "/changefirstlast")
    public String changeFirstLast()
    {
        return listSEService.changeFirstLast();
    }

    @GetMapping(path = "/invert")
    public String invert()
    {
        return listSEService.invert();
    }

    @GetMapping(path = "/mixbygender")
    public String mixByGender() {return listSEService.mixByGender();}

    @GetMapping(path = "/count")
    public String count()
    {
        return listSEService.count();
    }

    @PostMapping(path = "/addtoposition")
    public String addToPosition(AddPositionDTO addPositionDTO)
    {
        return listSEService.addToPosition(addPositionDTO);
    }

    @PostMapping (path = "/deleteletterage")
    public String deleteLetterAge(@RequestBody FirstLetterAgeDTO firstLetterAgeDTO) {return listSEService.deleteLetterAge(firstLetterAgeDTO);}

    @GetMapping (path = "/mix")
    public String mix() {return listSEService.mix();}

    @GetMapping (path = "/rangebyage")
    public List<RangeByAgeDTO> ranges(){return listSEService.getRange();}

}
