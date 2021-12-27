package dev.academy.academyFarms.farm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
