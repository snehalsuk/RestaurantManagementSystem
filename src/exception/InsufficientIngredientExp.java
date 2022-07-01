package exception;

import entities.Ingredient;

import java.util.Map;

public class InsufficientIngredientExp extends RuntimeException {

    private Map<Ingredient,Double>insufficientIngredients;

    public InsufficientIngredientExp(Map<Ingredient, Double> insufficientIngredients) {
        this.insufficientIngredients = insufficientIngredients;
    }

    public Map<Ingredient, Double> getInsufficientIngredients() {
        return insufficientIngredients;
    }

    public void setInsufficientIngredients(Map<Ingredient, Double> insufficientIngredients) {
        this.insufficientIngredients = insufficientIngredients;
    }
}
