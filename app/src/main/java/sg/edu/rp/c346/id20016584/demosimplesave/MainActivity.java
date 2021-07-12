package sg.edu.rp.c346.id20016584.demosimplesave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    protected void onResume() {
        super.onResume();
        //Step1: obtain the SharedPreferences instance
        SharedPreferences prefs= getPreferences(MODE_PRIVATE);
        //Step2: Retrieve the saved data from the SharedPreferences with a default value if no matching data
        String msg= prefs.getString("greetings", "No greetings name");
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        //Step1: Obtain the SharedPreferences instance
        SharedPreferences prefs= getPreferences(MODE_PRIVATE);
        //Step2: Create a SharedPreferences Editor by calling edit()
        SharedPreferences.Editor prefEdit=prefs.edit();
        //Step3: Set a key-value pair in the editor
        prefEdit.putString("greetings", "Hello!");
        //Step4: Call commit() to save the changes made to the SharedPreferences
        prefEdit.commit();
    }
}
