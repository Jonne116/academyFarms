package dev.academy.academyFarms.service;

import dev.academy.academyFarms.model.Farm;
import dev.academy.academyFarms.repository.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FarmService {

    private final FarmRepository farmRepository;

    @Autowired
    public FarmService(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }



    public List<Farm> getFarms(Map<String,String> params) {
        return farmRepository.findAllByParams(params);
    }

    public List<Farm> findAll() {
        return farmRepository.findAll();
    }

    public Map<String, List<String>> getLocations() {
        Map<String, List<String>> result = new HashMap<>();
        result.put("location", farmRepository.getLocations());
        result.put("sensorType", farmRepository.getSensorTypes());
        return result;
    }
}
