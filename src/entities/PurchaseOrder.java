package entities;

import java.util.Map;

public class PurchaseOrder {
    private double amount;
    private Map<Ingredient,Integer>Composition;

    public PurchaseOrder(double amount, Map<Ingredient, Integer> composition) {
        this.amount = amount;
        Composition = composition;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Map<Ingredient, Integer> getComposition() {
        return Composition;
    }

    public void setComposition(Map<Ingredient, Integer> composition) {
        Composition = composition;
    }
}
