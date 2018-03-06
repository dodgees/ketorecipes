package com.kleine.liefde.biglife.ketorecipes.repositories;

import com.kleine.liefde.biglife.ketorecipes.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by Erik on 3/4/2018.
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);
}
