package com.hevs.projectcloud.touristofficehealthyservice;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class QuestionnaireDetailsActivity extends Activity {

    /**
     * The identifier of the actual displayed question or feedback question on the screen
     */
    private long question_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire_details);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_questionnaire_details, menu);
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

    /**
     * //LG/ Handles the click events from elements on the activity_questionnaire_details.xml
     * @param view the element which was clicked
     */
    public void onClick(View view) {
        Intent intent;

        switch (view.getId()) {
            case R.id.button_next_question :
                loadNextQuestion(this.question_id);
                break;
        }
    }

    /**
     *
     * @param question_id the id of the actually displayed question
     */
    private void loadNextQuestion(long question_id) {

        //TODO: Get next question of the questionnaire

        // Refresh the screen
        Intent refreshIntent = new Intent(this, QuestionnaireDetailsActivity.class);
        startActivity(refreshIntent);
    }
}