package com.umanizales.api_programacion.api_programacion.controller;
import com.umanizales.api_programacion.api_programacion.model.Kid;
import com.umanizales.api_programacion.api_programacion.model.dto.AddPositionDTO;
import com.umanizales.api_programacion.api_programacion.service.ListDEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/listde")
public class ListDEController {
    @Autowired
    private ListDEService listDEService;

    @PostMapping(path = "/add")
    public String add(@RequestBody Kid kid)
    {
        return listDEService.add(kid);
    }

    @PostMapping(path = "/addtostart")
    public String addKidToStart(@RequestBody Kid kid)
    {
        return listDEService.addToStart(kid);
    }

    @GetMapping(path = "/deletetoposition")
    public String deleteToPosition(@RequestBody int position)
    {
        return listDEService.deleteToPosition(position);
    }

    @PostMapping(path = "/deletebydata")
    public String deleteByData(@RequestBody Kid kid)
    {
        return listDEService.deleteByData(kid);
    }

    @GetMapping(path = "/invert")
    public String invert() throws Exception {return listDEService.invert();}

    @GetMapping(path = "/mixbygender")
    public String mixByGender() {return listDEService.mixByGender();}

    @GetMapping(path = "/count")
    public String count()
    {
        return listDEService.count();
    }

    @PostMapping(path = "/addtoposition")
    public String addToPosition(AddPositionDTO addPositionDTO)
    {
        return listDEService.addToPosition(addPositionDTO);
    }

}
