package androidbootcamp.net;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class Payment extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        TextView MonthlyPayment = findViewById(R.id.txtMonthlyPayment); //Text View of objects
        ImageView image = findViewById(R.id.imgYears); // Image view
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int intYears = sharedPref.getInt("key1", 0); //Retrieve Integer value
        int intLoan  = sharedPref.getInt("key2",0); //Retrieve Integer Value
        float decInterest = sharedPref.getFloat("key3",0); //Retrieve Float
        float decMonthlyPayment = 0;

        decInterest =  (decMonthlyPayment * intYears) -intLoan;

        decMonthlyPayment= (intLoan * (1 + (decInterest * intYears))) / (12 * intYears);
        DecimalFormat currency = new DecimalFormat("R###,###.##");
        if (intYears ==10){
            image.setImageResource(R.drawable.money);
        } else if (intYears == 20){
            image.setImageResource(R.drawable.folder_home);
        } else if (intYears == 30){
            image.setImageResource(R.drawable.folder_home);
        } else {
            MonthlyPayment.setText("Enter 10, 20, or 30 Years");
        }
    }
}