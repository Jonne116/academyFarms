package dev.academy.academyFarms.repository;

import dev.academy.academyFarms.model.Farm;

import java.util.List;
import java.util.Map;


public interface FarmRepositoryCustom {
    List<Farm> findAllByParams(Map<String,String> params);
}
