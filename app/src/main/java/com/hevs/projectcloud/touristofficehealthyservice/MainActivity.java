package com.hevs.projectcloud.touristofficehealthyservice;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    Button  newButton;
    Button  archivedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get layout objects instance
        newButton       = (Button)  findViewById(R.id.archivedButton);
        archivedButton  = (Button)  findViewById(R.id.newButton);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * onClick event response
     * @param view the element which was clicked
     */
    public void onClick(View view) {
        Intent intent;

        switch (view.getId()) {
            case R.id.newButton:
                intent = new Intent(this, QuestionnaireActivity.class);
                startActivity(intent);
                break;
            case R.id.archivedButton:
                intent = new Intent(this, QuestionnaireListActivity.class);
                startActivity(intent);
                break;
        }
    }
}
