package dev.academy.academyFarms.farm;

import java.util.List;
import java.util.Map;


public interface FarmRepositoryCustom {
    List<Farm> findAllByParams(Map<String,String> params);
}
