package com.kleine.liefde.biglife.ketorecipes.repositories;

import com.kleine.liefde.biglife.ketorecipes.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by Erik on 3/4/2018.
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByCategoryName(String categoryName);
}
