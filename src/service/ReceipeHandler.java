package service;

import entities.Ingredient;
import entities.Receipe;
import exception.InsufficientIngredientExp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReceipeHandler {

    public void checIfAvailableToPrepare(Receipe receipe, List<Ingredient> ingredientList) {

        Map<Ingredient, Double> composition = receipe.getComposition();
        Map<Ingredient, Double> insufficientIngredient = new HashMap<>();
        for (Ingredient inv : ingredientList) {
            if (composition.containsKey(inv)) {

                double qtyUsed = composition.get(inv);
                if (qtyUsed > inv.getQty()) {
                    insufficientIngredient.put(inv, qtyUsed - inv.getQty());
                }
            }
            if (insufficientIngredient.size() > 0) {
                throw new InsufficientIngredientExp(insufficientIngredient);
            }
        }
    }



    }
