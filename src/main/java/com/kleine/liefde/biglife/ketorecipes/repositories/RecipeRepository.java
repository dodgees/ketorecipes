package com.kleine.liefde.biglife.ketorecipes.repositories;

import com.kleine.liefde.biglife.ketorecipes.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by Erik on 3/4/2018.
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    Optional<Recipe> findByCategories(String category);
}
