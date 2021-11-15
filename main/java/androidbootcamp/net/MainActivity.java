package androidbootcamp.net;
/*
 *   Student Number : 10463321
 *   Name : Karabo Maboka
 *   Purpose : The home mortgage interest app computes  the total
 *   interest paid for the life of a home mortgage loan.
*/
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //Declare Variables
    int intYears;
    int intLoan;
    float decInterest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText years = findViewById(R.id.txtYears);
        final EditText loan = findViewById(R.id.txtLoan);
        final EditText interest = findViewById(R.id.txtInterest);
        Button  button = findViewById(R.id.btnPayment); //Button
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this); //Shared Prefrences object
        button.setOnClickListener(view -> {
            intYears = Integer.parseInt(years.getText().toString());
            intLoan = Integer.parseInt(loan.getText().toString());
            decInterest = Float.parseFloat(interest.getText().toString());
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("key1", intYears);
            editor.putInt("key2", intLoan);
            editor.putFloat("key3", decInterest);
            editor.commit(); //Data written to shared preferences object
        });
    }
}
