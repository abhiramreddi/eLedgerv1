package com.myapps.androledger.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.fragment.app.Fragment;

import com.myapps.androledger.DataBaseHelper;
import com.myapps.androledger.R;
import com.myapps.androledger.TransactionModel;

import java.util.Objects;

public class Ledger extends Fragment {

    public Ledger() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    AppCompatButton add;
    AppCompatEditText amount, description;
    AppCompatTextView category;
    AppCompatTextView food, shopping, phone, health, groceries, travel, fuel, education, electricity, bills, housing, other;
    int[] Category_items;
    String type;


    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ledger, container, false);

        amount = view.findViewById(R.id.etEnterAmount);
        description = view.findViewById(R.id.etDescription);
        category = view.findViewById(R.id.etCategory);

        AppCompatToggleButton appCompatToggleButton;
        appCompatToggleButton = view.findViewById(R.id.spinner1);
        type = appCompatToggleButton.getText().toString();


        Category_items = new int[]{R.id.tvBills, R.id.tvEducation, R.id.tvElectricity, R.id.tvFood, R.id.tvHealth, R.id.tvPhone, R.id.tvShopping, R.id.tvGroceries, R.id.tvTravel, R.id.tvFuel, R.id.tvHousing, R.id.tvOther};

        food = view.findViewById(R.id.tvFood);
        shopping = view.findViewById(R.id.tvShopping);
        phone = view.findViewById(R.id.tvPhone);
        health = view.findViewById(R.id.tvHealth);
        groceries = view.findViewById(R.id.tvGroceries);
        travel = view.findViewById(R.id.tvTravel);
        fuel = view.findViewById(R.id.tvFuel);
        education = view.findViewById(R.id.tvEducation);
        bills = view.findViewById(R.id.tvBills);
        electricity = view.findViewById(R.id.tvElectricity);
        housing = view.findViewById(R.id.tvHousing);
        other = view.findViewById(R.id.tvOther);

        food.setOnClickListener(view112 -> category.setText("Food"));
        shopping.setOnClickListener(view111 -> category.setText("Shopping"));
        phone.setOnClickListener(view110 -> category.setText("Phone"));
        health.setOnClickListener(view1 -> category.setText("Health"));
        groceries.setOnClickListener(view15 -> category.setText("Groceries"));
        travel.setOnClickListener(view12 -> category.setText("Travel"));
        fuel.setOnClickListener(view13 -> category.setText("Fuel"));
        education.setOnClickListener(view14 -> category.setText("Education"));
        electricity.setOnClickListener(view16 -> category.setText("Electricity"));
        bills.setOnClickListener(view17 -> category.setText("Bills"));
        housing.setOnClickListener(view19 -> category.setText("Housing"));
        other.setOnClickListener(view18 -> category.setText("Other"));

        amount = view.findViewById(R.id.etEnterAmount);
        description = view.findViewById(R.id.etDescription);
        add = view.findViewById(R.id.addButton);


        add.setOnClickListener(view113 -> {

            TransactionModel transactionModel;

            try {
                transactionModel = new TransactionModel(-1, Integer.parseInt(Objects.requireNonNull(amount.getText()).toString()), Objects.requireNonNull(description.getText()).toString(), category.getText().toString());
            } catch (Exception e) {
                transactionModel = new TransactionModel(-1, 0, "error", "Error");
            }

            DataBaseHelper dataBaseHelper = new DataBaseHelper(getActivity());
            boolean success = dataBaseHelper.addOne(transactionModel);
            if (success)
                Toast.makeText(getActivity(), "Data Added Successfully", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getActivity(), "Data Not Added", Toast.LENGTH_SHORT).show();
        });

        return view;
    }


}


