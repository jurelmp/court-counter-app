package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int POINTS_FOR_FREE_THROW = 1;
    public static final int POINTS_FOR_TWO_POINT = 2;
    public static final int POINTS_FOR_THREE_POINT = 3;
    private Button teamAButtonThreePoints, teamAButtonTwoPoints, teamAButtonFreeThrow;
    private Button teamBButtonThreePoints, teamBButtonTwoPoints, teamBButtonFreeThrow;
    private Button buttonReset;
    private TextView scoreViewA, scoreViewB;

    private int scoreTeamA, scoreTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setButtonListeners();
    }

    /**
     * Displays the given score for Team A
     */
    public void displayForTeamA(int score) {
        scoreViewA.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B
     */
    public void displayForTeamB(int score) {
        scoreViewB.setText(String.valueOf(score));
    }

    /**
     * Create reference to Views
     */
    public void init() {
        teamAButtonThreePoints = (Button) findViewById(R.id.a_button_three_points);
        teamAButtonTwoPoints = (Button) findViewById(R.id.a_button_two_points);
        teamAButtonFreeThrow = (Button) findViewById(R.id.a_button_free_throw);
        teamBButtonThreePoints = (Button) findViewById(R.id.b_button_three_points);
        teamBButtonTwoPoints = (Button) findViewById(R.id.b_button_two_points);
        teamBButtonFreeThrow = (Button) findViewById(R.id.b_button_free_throw);
        buttonReset = (Button) findViewById(R.id.button_reset);
        scoreViewA = (TextView) findViewById(R.id.team_a_score);
        scoreViewB = (TextView) findViewById(R.id.team_b_score);
        scoreTeamA = 0;
        scoreTeamB = 0;
    }

    /**
     * Set event listeners to Views for Team A
     */
    private void setButtonListeners() {
        TeamAButtonScoreListener teamAButtonScoreListener = new TeamAButtonScoreListener();
        TeamBButtonScoreListener teamBButtonScoreListener = new TeamBButtonScoreListener();
        teamAButtonFreeThrow.setOnClickListener(teamAButtonScoreListener);
        teamAButtonTwoPoints.setOnClickListener(teamAButtonScoreListener);
        teamAButtonThreePoints.setOnClickListener(teamAButtonScoreListener);
        teamBButtonFreeThrow.setOnClickListener(teamBButtonScoreListener);
        teamBButtonTwoPoints.setOnClickListener(teamBButtonScoreListener);
        teamBButtonThreePoints.setOnClickListener(teamBButtonScoreListener);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreTeamA = 0;
                scoreTeamB = 0;
                displayForTeamA(scoreTeamA);
                displayForTeamB(scoreTeamB);
            }
        });
    }

    /**
     * Class Button Listeners for TeamB
     */
    private class TeamBButtonScoreListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.b_button_free_throw:
                    scoreTeamB += POINTS_FOR_FREE_THROW;
                    break;
                case R.id.b_button_two_points:
                    scoreTeamB += POINTS_FOR_TWO_POINT;
                    break;
                case R.id.b_button_three_points:
                    scoreTeamB += POINTS_FOR_THREE_POINT;
                    break;
                default:
                    break;
            }
            displayForTeamB(scoreTeamB);
        }
    }

    /**
     * Class Button Listeners for TeamA
     */
    private class TeamAButtonScoreListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.a_button_free_throw:
                    scoreTeamA += POINTS_FOR_FREE_THROW;
                    break;
                case R.id.a_button_two_points:
                    scoreTeamA += POINTS_FOR_TWO_POINT;
                    break;
                case R.id.a_button_three_points:
                    scoreTeamA += POINTS_FOR_THREE_POINT;
                    break;
                default:
                    break;
            }
            displayForTeamA(scoreTeamA);
        }
    }
}
