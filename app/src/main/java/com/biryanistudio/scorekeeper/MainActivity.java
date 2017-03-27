package com.biryanistudio.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int teamAScore;
    private int teamBScore;
    private TextView teamAScoreTextView;
    private TextView teamBScoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamAScoreTextView = (TextView) findViewById(R.id.team_a_score);
        teamBScoreTextView = (TextView) findViewById(R.id.team_b_score);
        setTeamAScore(teamAScore);
        setTeamBScore(teamBScore);

        findViewById(R.id.team_a_goal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTeamAScore(teamAScore += 10);
            }
        });

        findViewById(R.id.team_b_goal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setTeamBScore(teamBScore += 10);
            }
        });

        findViewById(R.id.team_a_foul).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTeamBScore(teamBScore += 5);
            }
        });

        findViewById(R.id.team_b_foul).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTeamAScore(teamAScore += 5);
            }
        });

        findViewById(R.id.reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTeamAScore(teamAScore = 0);
                setTeamBScore(teamBScore = 0);
            }
        });
    }

    private void setTeamAScore(int score) {
        teamAScoreTextView.setText(String.format(Locale.getDefault(), "%d", score));
    }

    private void setTeamBScore(int score) {
        teamBScoreTextView.setText(String.format(Locale.getDefault(), "%d", score));
    }
}
