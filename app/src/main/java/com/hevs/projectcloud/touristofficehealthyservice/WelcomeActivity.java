package com.hevs.projectcloud.touristofficehealthyservice;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * WelcomeActivity is the first activity when starting the application.
 */
public class WelcomeActivity extends Activity
{
    Spinner languageSpinner;
    Button  newButton;
    Button  archivedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Get layout objects instance
        languageSpinner = (Spinner) findViewById(R.id.languageSpinner);
        newButton       = (Button)  findViewById(R.id.archivedButton);
        archivedButton  = (Button)  findViewById(R.id.newButton);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
        R.array.language_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_welcome, menu);
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
        //LG/ Opens the "About-Window"
        if (id == R.id.action_about) {
            Intent i = new Intent("android.intent.action.ABOUT");
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * //LG/ Handles the click events from elements on the activity_welcome.xml
     * @param view the element which was clicked
     */
    public void onClick(View view) {
        Intent intent;

        switch (view.getId()) {
            case R.id.button_DE :
                this.setLocale("de");
                this.continueToMainActivity();
                break;
            case R.id.button_FR :
                this.setLocale("fr");
                this.continueToMainActivity();
                break;
            case R.id.button_EN :
                this.setLocale("en");
                this.continueToMainActivity();
                break;
            case R.id.newButton:
                intent = new Intent(this, QuestionnaireActivity.class);
                startActivity(intent);
            case R.id.archivedButton:
                intent = new Intent(this, QuestionnaireListActivity.class);
                startActivity(intent);
        }
    }

    private void continueToMainActivity() {
        Intent mainIntent = new Intent(WelcomeActivity.this, MainActivity.class);
        startActivity(mainIntent);
    }

    /**
     * //LG/ Change language and refreshes the window
     * @param localeCode the locale code of the language which was chosen
     */
    private void setLocale(String localeCode) {
        SharedPreferences sharedPref = getSharedPreferences("language", MODE_PRIVATE);

        Locale locale = new Locale(localeCode);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("language", localeCode);
        editor.commit();

        Intent refreshIntent = new Intent(this, WelcomeActivity.class);
        startActivity(refreshIntent);
    }
}
