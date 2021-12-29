package dev.academy.academyFarms.controller;

import dev.academy.academyFarms.model.Farm;
import dev.academy.academyFarms.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/farm")
public class FarmController {

    private final FarmService farmService;

    @Autowired
    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    @GetMapping("list")
    public Map<String, List<String>> getTypes() {
       return farmService.getLocations();
    }

    @GetMapping
    public List<Farm> getFarms(@RequestParam Map<String,String> params) {

        if (params.isEmpty()) {
            return farmService.findAll();
        }
        else {
            return farmService.getFarms(params);
        }
    }

}
