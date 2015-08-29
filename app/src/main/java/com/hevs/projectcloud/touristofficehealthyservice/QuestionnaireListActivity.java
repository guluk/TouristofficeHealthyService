package com.hevs.projectcloud.touristofficehealthyservice;

import android.app.ActionBar;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hevs.projectcloud.touristofficebackend.questionnaires.model.Questionnaire;

import java.util.ArrayList;

/**
 * Created by samuel on 8/28/15.
 */
public class QuestionnaireListActivity extends ListActivity
{
    private ArrayList<Questionnaire> questionnaires = new ArrayList<Questionnaire>();

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire_list);

        ArrayAdapter<Questionnaire> adapter = new ArrayAdapter<Questionnaire>(
            this,
            android.R.layout.simple_list_item_1,
            questionnaires
        );

        setListAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_questionnaire_list, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
