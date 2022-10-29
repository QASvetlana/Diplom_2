package models;

import java.util.ArrayList;

public class Order {
    public String ingredientNumber;
    public int number;
    public String name;
    public ArrayList<String> ingredients;
    public String createdAt;
    public String updatedAt;

    public Order(String ingredientNumber, int number, String name, ArrayList<String> ingredients, String createdAt, String updatedAt) {
        this.ingredientNumber = ingredientNumber;
        this.number = number;
        this.name = name;
        this.ingredients = ingredients;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Order() {}

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getIngredientNumber() {
        return ingredientNumber;
    }

    public void set_id(String ingredientNumber) {
        this.ingredientNumber = ingredientNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}