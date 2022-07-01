package io;

import entities.Ingredient;
import entities.Receipe;
import exception.InvalidIngredientException;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReceipeIO {

    public List<Receipe> readReceipeList(String filePath,List<Ingredient>ingredientList) throws FileNotFoundException {

        List<String> lines = InputOutputReader.readFile(filePath);
        List<Receipe> receipeList = new ArrayList<>();
        for (String line : lines) {
            String[] sp = line.split(" ");
            String receipeName = sp[0];
            double amount = Double.parseDouble(sp[1]);
            Map<Ingredient, Double> composition = new HashMap<>();


            for (int i = 2; i < sp.length; i += 2) {
                String ingredientName = sp[i];
                double qty = Double.parseDouble(sp[i +1]);
                boolean flag=false;
                for (int j = 0; j < ingredientList.size(); j++) {
                    flag=true;
                    composition.put(ingredientList.get(i), qty);
                    break;
                }


            if(flag==false){
                throw new InvalidIngredientException("Ingredient"+ingredientName+"not found!");
            }

                }

            Receipe receipe = new Receipe(receipeName, composition, amount);
            receipeList.add(receipe);
        } System.out.println("Read "+receipeList.size()+"receipe");
            return receipeList;
        }



}