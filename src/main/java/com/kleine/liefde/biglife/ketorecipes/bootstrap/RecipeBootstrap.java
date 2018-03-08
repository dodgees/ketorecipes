package com.kleine.liefde.biglife.ketorecipes.bootstrap;

import com.kleine.liefde.biglife.ketorecipes.domain.*;
import com.kleine.liefde.biglife.ketorecipes.repositories.CategoryRepository;
import com.kleine.liefde.biglife.ketorecipes.repositories.RecipeRepository;
import com.kleine.liefde.biglife.ketorecipes.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by jt on 6/13/17.
 */
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes() {

        List<Recipe> recipes = new ArrayList<>(2);

        //get UOMs
        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");

        if(!eachUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        if(!tableSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        if(!teaSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");

        if(!dashUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");

        if(!pintUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> cupsUomOptional = unitOfMeasureRepository.findByDescription("Cup");

        if(!cupsUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> toTasteOptional = unitOfMeasureRepository.findByDescription("taste");

        if(!cupsUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> poundsOptional = unitOfMeasureRepository.findByDescription("Pounds");

        if(!cupsUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        //get optionals
        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure tableSpoonUom = tableSpoonUomOptional.get();
        UnitOfMeasure teaspoonUom = teaSpoonUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure pintUom = dashUomOptional.get();
        UnitOfMeasure cupsUom = cupsUomOptional.get();
        UnitOfMeasure toTasteUom = toTasteOptional.get();
        UnitOfMeasure poundsUom = poundsOptional.get();

        Optional<Category> dinnerCategoryOptional = categoryRepository.findByCategoryName("Dinner");

        if(!dinnerCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Optional<Category> americanCategoryOptional = categoryRepository.findByCategoryName("American");

        if(!dinnerCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Optional<Category> mexicanCategoryOptional = categoryRepository.findByCategoryName("Mexican");

        if(!dinnerCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Category dinnerCategory = dinnerCategoryOptional.get();
        Category americanCategory = americanCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();

        //Yummy Guac
        Recipe chickenTenderLazoneRecipe = new Recipe();
        chickenTenderLazoneRecipe.setDescription("Chicken Tender Lazone");
        chickenTenderLazoneRecipe.setPrepTime(10);
        chickenTenderLazoneRecipe.setCookTime(0);
        chickenTenderLazoneRecipe.setDifficulty(Difficulty.EASY);
        chickenTenderLazoneRecipe.setDirections("1. In a bowl combine the smoked paprika, garlic powder, onion powder, cayenne pepper, dried oregano, dried basil, and some salt and pepper to taste." +
                "\n" +
                "2. In a medium sized mixing bowl place your chicken tenderloins then add the tablespoon of olive oil and seasoning mix. Mix together well." +
                "\n" +
                "3. Melt 3 tablespoons of the butter in a large skillet. Use medium-high heat. Add the chicken tenderloins and cook for about 3-4 minutes on each side. The chicken should reach 165°F. Once they are done set them aside on a plate. I usually cook these in two batches." +
                "\n" +
                "4. Cook the spiral zucchini and season with salt and pepper. You can saute in another pan or cook in the microwave. Drain any excess water." +
                "\n" +
                "5. Add 2 tablespoons of butter to the skillet that you cooked the chicken in." +
                "\n" +
                "6. Whisk in the cup of cream. The whisk and cream should lift up the browned bits off the bottom of the pan. Whisk in the xanthan gum and the sauce will thicken up. Taste to check the seasoning and add additional salt or pepper as needed." +
                "\n" +
                "7. Serve with the zucchini and chicken. You can layer it like I did here, or toss with the zoodles and serve the chicken on top." +
                "\n" +
                "\n" +
                "Read more: https://www.ruled.me/chicken-tender-lazone/");

        Notes chickenTenderLaxoneNotes = new Notes();
        chickenTenderLaxoneNotes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");

        chickenTenderLazoneRecipe.setNotes(chickenTenderLaxoneNotes);

        //very redundent - could add helper method, and make this simpler
        chickenTenderLazoneRecipe.addIngredient(new Ingredient("smoked paprika", new BigDecimal(2), teaspoonUom));
        chickenTenderLazoneRecipe.addIngredient(new Ingredient("garlic powder", new BigDecimal(".5"), teaspoonUom));
        chickenTenderLazoneRecipe.addIngredient(new Ingredient("onion powder", new BigDecimal(.5), tableSpoonUom));
        chickenTenderLazoneRecipe.addIngredient(new Ingredient("cayenne pepper", new BigDecimal(.5), tableSpoonUom));
        chickenTenderLazoneRecipe.addIngredient(new Ingredient("dried oregano", new BigDecimal(.5), tableSpoonUom));
        chickenTenderLazoneRecipe.addIngredient(new Ingredient("dried basil", new BigDecimal(.5), tableSpoonUom));
        chickenTenderLazoneRecipe.addIngredient(new Ingredient("salt and pepper", new BigDecimal(0), toTasteUom));
        chickenTenderLazoneRecipe.addIngredient(new Ingredient("chicken tenderloins", new BigDecimal(1.25), poundsUom));
        chickenTenderLazoneRecipe.addIngredient(new Ingredient("heavy whipping cream", new BigDecimal(1), cupsUom));
        chickenTenderLazoneRecipe.addIngredient(new Ingredient("xanthan gum", new BigDecimal(.25), teaspoonUom));

        chickenTenderLazoneRecipe.getCategories().add(dinnerCategory);

        //add to return list
        recipes.add(chickenTenderLazoneRecipe);

        //Yummy Tacos
        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setDescription("Spicy Grilled Chicken Taco");
        tacosRecipe.setCookTime(9);
        tacosRecipe.setPrepTime(20);
        tacosRecipe.setDifficulty(Difficulty.MODERATE);

        tacosRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvtrAnNm");

        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvu7Q0MJ");

        tacosRecipe.setNotes(tacoNotes);

        tacosRecipe.addIngredient(new Ingredient("Ancho Chili Powder", new BigDecimal(2), tableSpoonUom));
        tacosRecipe.addIngredient(new Ingredient("Dried Oregano", new BigDecimal(1), teaspoonUom));
        tacosRecipe.addIngredient(new Ingredient("Dried Cumin", new BigDecimal(1), teaspoonUom));
        tacosRecipe.addIngredient(new Ingredient("Sugar", new BigDecimal(1), teaspoonUom));
        tacosRecipe.addIngredient(new Ingredient("Salt", new BigDecimal(".5"), teaspoonUom));
        tacosRecipe.addIngredient(new Ingredient("Clove of Garlic, Choppedr", new BigDecimal(1), eachUom));
        tacosRecipe.addIngredient(new Ingredient("finely grated orange zestr", new BigDecimal(1), tableSpoonUom));
        tacosRecipe.addIngredient(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), tableSpoonUom));
        tacosRecipe.addIngredient(new Ingredient("Olive Oil", new BigDecimal(2), tableSpoonUom));
        tacosRecipe.addIngredient(new Ingredient("boneless chicken thighs", new BigDecimal(4), tableSpoonUom));
        tacosRecipe.addIngredient(new Ingredient("small corn tortillasr", new BigDecimal(8), eachUom));
        tacosRecipe.addIngredient(new Ingredient("packed baby arugula", new BigDecimal(3), cupsUom));
        tacosRecipe.addIngredient(new Ingredient("medium ripe avocados, slic", new BigDecimal(2), eachUom));
        tacosRecipe.addIngredient(new Ingredient("radishes, thinly sliced", new BigDecimal(4), eachUom));
        tacosRecipe.addIngredient(new Ingredient("cherry tomatoes, halved", new BigDecimal(".5"), pintUom));
        tacosRecipe.addIngredient(new Ingredient("red onion, thinly sliced", new BigDecimal(".25"), eachUom));
        tacosRecipe.addIngredient(new Ingredient("Roughly chopped cilantro", new BigDecimal(4), eachUom));
        tacosRecipe.addIngredient(new Ingredient("cup sour cream thinned with 1/4 cup milk", new BigDecimal(4), cupsUom));
        tacosRecipe.addIngredient(new Ingredient("lime, cut into wedges", new BigDecimal(4), eachUom));

        tacosRecipe.getCategories().add(mexicanCategory);
        tacosRecipe.getCategories().add(dinnerCategory);
        tacosRecipe.getCategories().add(americanCategory);

        recipes.add(tacosRecipe);
        return recipes;
    }
}
