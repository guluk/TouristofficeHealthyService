package com.hevs.projectcloud.touristofficehealthyservice;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
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

        ActionBar actionBar = getActionBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_questionnaire, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * //LG/ Handles the click events from elements on the activity_questionnaire_details.xml
     * @param view the element which was clicked
     */
    public void onClick(View view) {
        Intent intent;

        switch (view.getId()) {
            case R.id.startButton :
                Intent mainIntent = new Intent(QuestionnaireActivity.this, QuestionnaireDetailsActivity.class);
                startActivity(mainIntent);
                break;
        }
    }
}
