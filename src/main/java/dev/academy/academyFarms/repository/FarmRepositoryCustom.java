package dev.academy.academyFarms.repository;

import dev.academy.academyFarms.model.Farm;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface FarmRepositoryCustom {
    List<Farm> findAllByParams(Map<String,String> params);
}
