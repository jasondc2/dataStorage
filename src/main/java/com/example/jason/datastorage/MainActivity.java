package com.example.jason.datastorage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText counter;
    int num;
    private static final int PREFERENCE_MODE_PRIVATE = 0;
    private static final String MY_UNIQUE_PREFERENCE_FILE = "MyUniquePreferenceFile";
    private SharedPreferences preferenceSettingsUnique;
    private SharedPreferences.Editor preferenceEditorUnique;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferenceSettingsUnique = getSharedPreferences(MY_UNIQUE_PREFERENCE_FILE, PREFERENCE_MODE_PRIVATE);

        counter = (EditText)findViewById(R.id.counterVal);

        num = preferenceSettingsUnique.getInt("number", 0);
        counter.setText(""+num);

        Button advance = (Button) findViewById(R.id.advance);
        Button save = (Button) findViewById(R.id.save);

        advance.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {


                num = num + 1;
                counter.setText(""+num);


            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                preferenceSettingsUnique = getSharedPreferences(MY_UNIQUE_PREFERENCE_FILE, PREFERENCE_MODE_PRIVATE);
                preferenceEditorUnique = preferenceSettingsUnique.edit();

                preferenceEditorUnique.putInt("number", num);
                preferenceEditorUnique.commit();
            }
        });

    }
}
