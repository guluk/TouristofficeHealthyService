package com.hevs.projectcloud.touristofficehealthyservice;

import android.app.ActionBar;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.content.Context;

import com.hevs.projectcloud.touristofficebackend.tohsaService.TohsaService;
import com.hevs.projectcloud.touristofficebackend.tohsaService.model.Questionnaire;
import com.hevs.projectcloud.touristofficebackend.tohsaService.model.QuestionnaireCollection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by samuel on 8/28/15.
 */
public class QuestionnaireListActivity extends ListActivity
{
    /**
     * * Log output.
     */
    private final Logger log = Logger
            .getLogger(QuestionnaireListActivity.class.getName());

    /**
     * The class automatically generated by the Google App Engine backend
     * project, used to access the API easily from the Android application.
     */
    private TohsaService tohsaServiceAPI;

    /**
     * The list of offers to display.
     */
    private ListView questionnaireList;

    private ArrayList<Questionnaire> questionnaires = new ArrayList<Questionnaire>();

    @Override
    public void onCreate(Bundle savedInstanceState) {

        //LG/ Handle to the GAE endpoints in the backend
        tohsaServiceAPI = CloudEndpointBuilderHelper.getEndpoints();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire_list);

        //LG/ Get the questionnaires from the API
        List<Questionnaire> questionnaires =  retrieveQuestionnaires().getItems();

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

    /**
     * Retrieves questionnaires from API
     */
    final QuestionnaireCollection retrieveQuestionnaires() {

        QuestionnaireCollection result;

        try {
            result = tohsaServiceAPI.questionnaires().listQuestionnaires().execute();
        } catch (IOException e) {
            String message = e.getMessage();
            if (message == null) {
                message = e.toString();
            }
            log.severe("Exception=" + message);
            result = null;
        }
        return result;
    }
}
