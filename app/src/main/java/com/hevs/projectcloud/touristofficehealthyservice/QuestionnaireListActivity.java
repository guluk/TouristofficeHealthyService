package com.hevs.projectcloud.touristofficehealthyservice;

import android.app.ActionBar;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

/**
 * Created by samuel on 8/28/15.
 */
public class QuestionnaireListActivity extends ListActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire_list);

        //SD/ Set return in action bar
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_questionnaire_list, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
