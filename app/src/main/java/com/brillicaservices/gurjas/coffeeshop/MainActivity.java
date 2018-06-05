package com.brillicaservices.gurjas.coffeeshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*
    * Declaring global variables*/
    EditText coffeeQuantity, customerName;
    RadioButton quantity250, quantity500;
    Button coffeeOrderBtn;
    TextView totalCoffeeOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        * casting all the views*/
        coffeeQuantity = findViewById(R.id.coffee_quantity);
        customerName = findViewById(R.id.customer_name);
        quantity250 = findViewById(R.id.quantity_250);
        quantity500 = findViewById(R.id.quantity_500);
        coffeeOrderBtn = findViewById(R.id.submit_order);
        totalCoffeeOrders = findViewById(R.id.coffee_orders);

        /*
        * setting button onClickListener*/
        coffeeOrderBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = customerName.getText().toString();
                int quantity = Integer.parseInt(coffeeQuantity.getText().toString());
                int totalPrice = 0;
                if (quantity250.isChecked())
                {
                    totalPrice = quantity*10;
                } else if (quantity500.isChecked()){
                    totalPrice = quantity*15;
                } else {
                    Toast.makeText(getApplicationContext(), "You have not selected any quantity. " +
                            "Please select any quantity.", Toast.LENGTH_LONG).show();
                }

                if (totalPrice != 0) {
                    totalCoffeeOrders.setText(totalCoffeeOrders.getText() + "Hello " + name + " your total price " +
                            "for " + quantity + " coffee's is: " + totalPrice);
                }
            }
        });
    }
}
