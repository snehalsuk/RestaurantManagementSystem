package io;

import entities.Ingredient;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class IngredientIO {

    public List<Ingredient> readIngredientList(String filePath) throws FileNotFoundException {
        List<String>lines= InputOutputReader.readFile(filePath);
        List<Ingredient> res=new ArrayList<>();
        for(String line:lines){
            String[] sp=line.split(" ");
            res.add(new Ingredient(sp[0],Double.parseDouble(sp[1]),Double.parseDouble(sp[2])));
        }
        System.out.println("Read"+lines.size()+"ingredients");
        return res;
    }
}
