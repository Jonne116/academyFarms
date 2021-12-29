package dev.academy.academyFarms.repository;

import dev.academy.academyFarms.model.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FarmRepository extends FarmRepositoryCustom, JpaRepository<Farm, Long> {

    @Query(value = "SELECT location FROM farm GROUP BY location", nativeQuery = true)
    List<String> getLocations();

    @Query(value = "SELECT sensor_type FROM farm GROUP BY sensor_type", nativeQuery = true)
    List<String> getSensorTypes();

}
