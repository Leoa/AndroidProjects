package com.leobee.Class6homework;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.leobee.finalprojectv2.R;

/*
* Author: Leondria Barbee
* Description:  Application keeps the state of the toggle button
* Date: 11.9.2014
* */


public class MainActivity extends Activity {
    private Button button;
    private static final String TAG = "MyActivity";
    private String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check to see if the toggle box has been set
        if( getIntent().getExtras() == null)
        {
            value= "Off";

        } else{
            value = this.getIntent().getExtras().getString("switchvalue");
        }
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                Toast toast;
                Log.d(TAG, "onClick was called");
                Intent intent = new Intent(v.getContext(), MainActivity2.class);
                intent.putExtra("switchButton",value);
               // toast = Toast.makeText(context, value, duration);
              //  toast.show();
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
