package com.hevs.projectcloud.touristofficehealthyservice;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.EditText;

/**
 * Created by samuel on 8/28/15.
 */
public class QuestionnaireActivity extends Activity
{
    EditText credentialText;
    EditText phoneText;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        credentialText = (EditText) findViewById(R.id.credentialText);
        phoneText      = (EditText) findViewById(R.id.phoneText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_questionnaire, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
