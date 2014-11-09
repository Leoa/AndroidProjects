package com.leobee.Class6homework;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.CompoundButton;

import com.leobee.finalprojectv2.R;


public class MainActivity2 extends Activity {
    private Button btn;
    private ToggleButton togBtn;
    private String  toggleValue;
    private static final String TAG= "MainActivity2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        // get intent data for toggle box manipulation
        String value = this.getIntent().getExtras().getString("switchButton");
        Log.d(TAG, "-------------Value of intent is "+value);

        btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Log.d(TAG, "onClick was called");
               Intent intent = new Intent(v.getContext(), MainActivity.class);
               if(getToggleValueFunc()!= null) {
                   // send value to main activity to keep toggle's state
                   intent.putExtra("switchvalue", getToggleValueFunc());
                   startActivity(intent);
               }else{
                   int duration = Toast.LENGTH_SHORT;
                   Toast toast;
                   Context context = getApplicationContext();


                   toast = Toast.makeText(context, "Flip the switch!!", duration);
                   toast.show();
               }
           }
       });
        togBtn = (ToggleButton)findViewById(R.id.toggleButton);
        // checks the saved state of the toggle
        if(value.equals("ON")  ){
            Log.d(TAG, "____________switch on_______________________" + value);
            togBtn.setChecked(true);
        }
        if(value.equals("OFF")  ){
            togBtn.setChecked(false);
            Log.d(TAG,"____________switch off_______________________"+value);
        }
        togBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                int duration = Toast.LENGTH_SHORT;
                Toast toast;
                Context context = getApplicationContext();

                String toggleValue;
                if (isChecked) {
                    toast = Toast.makeText(context, "ON", duration);
                    toast.show();
                    toggleValue = "ON";
                    setToggleValueFunc(toggleValue);

                } else {
                    toast = Toast.makeText(context, "OFF", duration);
                    toast.show();
                    toggleValue = "OFF";
                    setToggleValueFunc(toggleValue);
                }
            }
        });
    }

    // get and set values for toggle box
    public void setToggleValueFunc(String toggleValue){
       this.toggleValue = toggleValue;
    }

    public String getToggleValueFunc(){
        return toggleValue;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


/*       how to save the data from this activity when the user hits the back button.
* Please explain application context
*
* How come implements does not work?
*
* */
