package entities;

import java.util.List;
import java.util.Map;

public class Receipe {


    private String name;
    private Map<Ingredient, Double> Composition;
    private double amount;

    public Receipe(String name, Map<Ingredient, Double> composition, double amount) {
        this.name = name;
        Composition = composition;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Ingredient, Double> getComposition() {
        return Composition;
    }

    public void setComposition(Map<Ingredient, Double> composition) {
        Composition = composition;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override

        public String toString(){
            return "Name="+this.name+"," +
                    " Amount="+this.amount+
                    ", Ingredients="+this.Composition;
        }
    }

