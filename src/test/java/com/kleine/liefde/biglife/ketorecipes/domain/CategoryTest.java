package com.kleine.liefde.biglife.ketorecipes.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Erik on 3/9/2018.
 */
public class CategoryTest {

    Category category;

    @Before
    public void setUp(){
        category = new Category();
    }

    @Test
    public void getCategoryName() throws Exception {
        Long idValue = 4l;

        category.setId(idValue);

        assertEquals(idValue, category.getId());
    }

    @Test
    public void getId() throws Exception {
    }

    @Test
    public void getRecipes() throws Exception {
    }

}