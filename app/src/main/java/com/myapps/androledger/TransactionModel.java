package com.myapps.androledger;

import androidx.annotation.NonNull;

public class TransactionModel {
    private Integer id;
    private Integer amount;
    private String description;
    private String Category;


    public TransactionModel() {

    }

    @NonNull
    @Override
    public String toString() {
        return " Amount   \t\t\t\t " + amount + '\n' +
                " Spent On \t\t\t\t" + description + '\n' +
                " Category \t\t\t\t" + Category;
    }

    public Integer getAmount() {
        return amount;
    }


    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        this.Category = category;
    }

    public TransactionModel(Integer id, Integer amount, String description, String category) {
        this.amount = amount;
        this.description = description;
        this.Category = category;

    }
}