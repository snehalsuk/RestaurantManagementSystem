package service;

import entities.Ingredient;
import exception.InsufficientMoneyExp;

import java.util.List;
import java.util.Map;

public class IngredientHandler {


    public static void view(List<Ingredient> ingredientList) {

        for (Ingredient ingredient : ingredientList) {

            System.out.println(ingredient.toString());

        }

    }

    public boolean isPossibleToOrderIngredient(Ingredient ingredient, double qty, double availableMoney) {
        if (availableMoney > ingredient.getRate() * qty) {
            return true;
        } else {
            return false;
        }
    }

    public void isPossibleToOrderIngredient(Map<Ingredient, Double> ingredientsToOrder, double availableMoney) {
        double moneyReq = 0.0;
        for (Ingredient ingredient : ingredientsToOrder.keySet()) {
            double qtyToOrder = ingredientsToOrder.get(ingredient);
            double rate = ingredient.getRate();
            moneyReq += rate * qtyToOrder;
        }
        if (availableMoney < moneyReq) {
            throw new InsufficientMoneyExp("insufficentMoney");
//        }
        }

    }
}