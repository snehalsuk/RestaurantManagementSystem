import entities.*;
import exception.IngredientNotFoundExp;
import exception.InsufficientMoneyExp;
import exception.ReceipeNotFoundExp;
import io.AccountIO;
import io.IngredientIO;
import io.ReceipeIO;
import service.AccountHandler;
import service.IngredientHandler;
import service.ReceipeHandler;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RestaurantManagementSystem {


    private static List<Ingredient> ingredientList;
    private static List<Expense> expenseList;
    private static List<Sales> salesList;
    private static double availableMoney;
    private static List<Receipe> receipeList;
    private static IngredientHandler ingredientHandler;
    private static IngredientIO ingredientIO;

    static int totalCostReceipe;
    static int costIngredient;
    static Scanner sc = new Scanner(System.in);
    Ingredient selectedIngredient = null;
    double ingredientQty = 0;
    Receipe selectedReceipe = null;
    Map<Ingredient, Double> insufficientIngredient = null;
    private static ReceipeIO receipeIO;
    private static AccountIO accountIO;
    private static AccountHandler accountHandler;
    private static ReceipeHandler receipeHandler;
    static int totalCostIngredient;
    static int n;
    static int saveCost;
    static int saveCostrec;
    static int receipeAllCost;
    static int ingredientAllCost;

    public static void main(String[] args) throws FileNotFoundException {

        ingredientIO = new IngredientIO();
        ingredientHandler = new IngredientHandler();
        ingredientIO = new IngredientIO();
        IngredientHandler is = new IngredientHandler();
        receipeIO = new ReceipeIO();
        ingredientIO = new IngredientIO();
        accountIO = new AccountIO();
        accountHandler = new AccountHandler();
        receipeHandler = new ReceipeHandler();
        salesList = new ArrayList<>();
        expenseList = new ArrayList<>();


        ingredientList = ingredientIO.readIngredientList("src/resource/ingredients.txt");

        receipeList = receipeIO.readReceipeList("src/resource/receipe.txt", ingredientList);

        availableMoney = accountIO.readAccounts("src/resource/accounts.txt");
        System.out.println("Available money is " + availableMoney);


        display();
    }


    public static int display() {
        try {
            System.out.println("1. View Available Ingredients \n2. Order specific Ingredients \n3. View total sales \n4. View total Expenses \n5. View Net Profit \n6. Place Order \n0. Exit");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            switch (n) {
                case 1://Available ingredient
                    viewIngredients();
                    break;
                case 2://Order specific ingredient
                    orderIngredients();

                    break;
                case 3://view total sales
                    System.out.println("Cost of receipe= " + saveCostrec);
                    returnToMenu();
                    break;
                case 4://view total expenses
                    if (availableMoney > saveCost) {
                        throw new InsufficientMoneyExp("Insufficient Balance");
                    }
                    System.out.println("Ingredient Expense = " + (availableMoney - saveCost));
                    returnToMenu();
                    break;
                case 5://view net profit
                    receipeAllCost += saveCostrec;
                    ingredientAllCost += saveCost;
                    System.out.println("NetProfit =" + (ingredientAllCost - receipeAllCost));
                    returnToMenu();
                    break;
                case 6://place order
                    orderReceipe();

                    break;
                case 0://exit
                    display();
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        return display();

    }


    public static void viewIngredients() {
        for (int i = 0; i < ingredientList.size(); i++) {
            System.out.println(ingredientList.get(i));
        }
    }


    public static int orderIngredients() {
        System.out.println("Please enter the ingredient");
        Scanner sc = new Scanner(System.in);
        String ingredientName = sc.nextLine();
        System.out.println("Enter qty");
        int ingredientQty = sc.nextInt();
        for (int i = 0; i < ingredientList.size(); i++) {
            if (ingredientList.get(i).getName().equals(ingredientName)) {
                totalCostIngredient = (int) (ingredientList.get(i).getRate() * ingredientQty);

                System.out.println(totalCostIngredient + "\nThank you ");
                saveCost += totalCostIngredient;
                break;
            }
//            else if(!ingredientList.get(i).getName().equals(ingredientName)){
//                throw new IngredientNotFoundExp(ingredientName+ " Not Found");
//            }

        }
        return input();
    }

    public static int input() {


        System.out.println("Order more to type 1 or 0 to exit");
        n = sc.nextInt();
        if (n == 1) {
            orderIngredients();
        } else {
            display();
        }
        return input();
    }

    public static int returnToMenu() {
        System.out.println("Enter 0 to Main Menu");
        if (n == 0) {
            display();
        }
        return returnToMenu();
    }

    public static void viewReceipe() {
        for (int i = 0; i < receipeList.size(); i++) {
            System.out.println(receipeList.get(i));
        }
    }

    public static int orderReceipe() {


        System.out.println("Please enter the Receipe");
        Scanner sc = new Scanner(System.in);
        String receipeName = sc.nextLine();
        System.out.println("Enter qty");
        int receipeQty = sc.nextInt();
        for (int i = 0; i < receipeList.size(); i++) {
            if (receipeList.get(i).getName().equals(receipeName)) {
                totalCostReceipe = (int) (receipeList.get(i).getAmount() * receipeQty);
                System.out.println(totalCostReceipe + "\nThank you ");
                saveCostrec += totalCostReceipe;
                break;
            }
//                else if(!receipeList.get(i).getName().equals(receipeName)){
//                    throw new ReceipeNotFoundExp(receipeName+ " Not Found");
//                }

        }
        return input();
    }

}

