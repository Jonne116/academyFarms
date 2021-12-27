package dev.academy.academyFarms.farm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/farm")
public class FarmController {

    private final FarmService farmService;

    @Autowired
    public FarmController(FarmService farmService) {

        this.farmService = farmService;

    }

    @GetMapping
    public List<Farm> getFarms(@RequestParam Map<String,String> params) {

        return farmService.getFarms(params);

    }

}
