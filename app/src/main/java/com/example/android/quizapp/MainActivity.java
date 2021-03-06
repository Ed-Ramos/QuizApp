package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitQuizResults(View view) {
        String questionTwoResult = "Incorrect";
        String questionFourResult = "Incorrect";
        String questionThreeResult = "Incorrect";
        String questionOneResult = "Incorrect";
        int Score = 0;
        String scoreMessage = "";

        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        //checking if Question 1 is correct

        // get selected radio button from RadioGroup
        RadioGroup questionOneGroup = (RadioGroup) findViewById(R.id.question_one_group);
        int selectedId = questionOneGroup.getCheckedRadioButtonId();

        // find the radio button by returned id. If no button is selected, do nothing
        if (selectedId != -1) {
            RadioButton questionOneButton = (RadioButton) findViewById(selectedId);
            Boolean questionOneCorrect = (questionOneButton.getText().equals("Hawaii"));
            if (questionOneCorrect) {
                questionOneResult = "Correct";
                Score += 1;
            }
        }

        // checking if Question 2 is correct
        CheckBox DelawareCheckBox = (CheckBox) findViewById(R.id.delaware_checkbox);
        CheckBox PennsylvaniaCheckBox = (CheckBox) findViewById(R.id.pennsylvania_checkbox);
        CheckBox NewJeseyCheckBox = (CheckBox) findViewById(R.id.new_jersey_checkbox);
        CheckBox GeorgiaCheckBox = (CheckBox) findViewById(R.id.georgia_checkbox);

        boolean questionTwoCorrect = (DelawareCheckBox.isChecked()) && (PennsylvaniaCheckBox.isChecked())
                && !(NewJeseyCheckBox.isChecked()) && !(GeorgiaCheckBox.isChecked());
        if (questionTwoCorrect) {
            questionTwoResult = "Correct";
            Score += 1;
        }

        //checking to see if Question 3 is correct
        EditText questionThreeField = (EditText) findViewById(R.id.question_three_field);
        String questionThreeAnswer = questionThreeField.getText().toString();
        if (questionThreeAnswer.trim().equals("2")) {
            questionThreeResult = "Correct";
            Score += 1;
        }

        // checking if Question 4 is correct
        CheckBox JudicialCheckBox = (CheckBox) findViewById(R.id.judicial_checkbox);
        CheckBox ExecutiveCheckBox = (CheckBox) findViewById(R.id.executive_checkbox);
        CheckBox RepresentativeCheckBox = (CheckBox) findViewById(R.id.representative_checkbox);
        CheckBox PresidentCheckBox = (CheckBox) findViewById(R.id.president_checkbox);

        boolean questionFourCorrect = (JudicialCheckBox.isChecked()) & (ExecutiveCheckBox.isChecked())
                && !(RepresentativeCheckBox.isChecked()) && !(PresidentCheckBox.isChecked());
        if (questionFourCorrect) {
            questionFourResult = "Correct";
            Score += 1;
        }

        if (Score == 4) {
            scoreMessage = "Great Job!";

        } else {
            scoreMessage = "try again for perfect score";
        }
        String resultMessage = createQuizSummary(name, questionOneResult, questionTwoResult, questionThreeResult, questionFourResult, scoreMessage);
        displayMessage(resultMessage);
        Toast.makeText(this, "Your score is: " + Integer.toString(Score), Toast.LENGTH_LONG).show();

    }

    private String createQuizSummary(String name, String questionOneResult, String questionTwoResult, String questionThreeResult, String questionFourResult, String scoreMessage) {
        String resultMessage = "Name: " + name;
        resultMessage += "\nQuestion 1: " + questionOneResult;
        resultMessage += "\nQuestion 2: " + questionTwoResult;
        resultMessage += "\nQuestion 3: " + questionThreeResult;
        resultMessage += "\nQuestion 4: " + questionFourResult;
        resultMessage += "\n" + scoreMessage;
        return resultMessage;

    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.quiz_results_text_view);
        orderSummaryTextView.setText(message);
    }


}
