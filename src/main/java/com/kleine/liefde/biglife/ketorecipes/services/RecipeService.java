package com.kleine.liefde.biglife.ketorecipes.services;

import com.kleine.liefde.biglife.ketorecipes.domain.Recipe;

import java.util.Set;

/**
 * Created by Erik on 3/7/2018.
 */
public interface RecipeService {

    Set<Recipe> getRecipes();
}
