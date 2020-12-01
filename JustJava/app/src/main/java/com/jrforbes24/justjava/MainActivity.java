package com.jrforbes24.justjava;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called to calculate the price of the order
     *
     * @param price           is the price passed in.
     * @param hasWhippedCream true or false.
     * @param hasChocolate    true or false
     * @param customerName    string with user name
     * @return priceMessage which is a string that will display the order summmary
     */
    private String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChocolate, String customerName) {
        String priceMessage = getString(R.string.order_summary_name, customerName);
        priceMessage += "\n" + getString(R.string.order_has_whipped_cream, hasWhippedCream);
        priceMessage += "\n" + getString(R.string.order_has_chocolate, hasChocolate);
        priceMessage += "\n" + getString(R.string.quantity_Order, quantity);
        priceMessage += "\n" + getString(R.string.total_Order) + price;
        priceMessage += "\n" + getString(R.string.thank_you);
        return priceMessage;
    }

    /**
     * This method is called to calculate the price of the order
     *
     * @param hasWhippedCream true or false
     * @param hasChocolate    true or false
     * @return price
     */
    public int calculatePrice(boolean hasWhippedCream, boolean hasChocolate) {
        int perCupPrice = 5;
        if (hasWhippedCream) {
            perCupPrice++;
        }
        if (hasChocolate) {
            perCupPrice += 2;
        }
        return quantity * perCupPrice;
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whipCheckBox = findViewById(R.id.whipped_check_box);
        CheckBox theChocolate = findViewById(R.id.the_chocolate);
        EditText theName = findViewById(R.id.the_name);
        boolean hasWhippedCream = whipCheckBox.isChecked();
        boolean hasChocolate = theChocolate.isChecked();
        String customer_Name = theName.getText().toString();
        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate, customer_Name);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Hot Chocolate order for " + customer_Name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }


    /**
     * This method is called when the decrement button is clicked.
     */
    public void decrement(View view) {
        if (quantity == 1) {
            Context context = getApplicationContext();
            CharSequence text = "You cannot order less than one cup of Hot Chocolate.";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show();
            return;
        }
        quantity -= 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the increment button is clicked.
     */
    public void increment(View view) {
        if (quantity == 100) {
            Context context = getApplicationContext();
            CharSequence text = "You cannot order more than 100 cups of Hot Chocolate.";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show();
            return;
        }
        quantity += 1;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numOfCoffees);
    }


}