package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

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


        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        //checking if Question 1 is correct

        // get selected radio button from radioGroup
        RadioGroup questionOneGroup = (RadioGroup) findViewById(R.id.question_one_group);
        int selectedId = questionOneGroup.getCheckedRadioButtonId();

        // find the radio button by returned id
        RadioButton questionOneButton = (RadioButton) findViewById(selectedId);
        Boolean questionOneCorrect = (questionOneButton.getText().equals("Hawaii"));
        if (questionOneCorrect) {
            questionOneResult = "Correct";
        }

        // checking if Question 2 is correct
        CheckBox DelawareCheckBox = (CheckBox) findViewById(R.id.delaware_checkbox);
        CheckBox PennsylvaniaCheckBox = (CheckBox) findViewById(R.id.pennsylvania_checkbox);
        boolean questionTwoCorrect = (DelawareCheckBox.isChecked()) & (PennsylvaniaCheckBox.isChecked());
        if (questionTwoCorrect) {
            questionTwoResult = "Correct";
        }


        //checking to see if Question 3 is correct
        EditText questionThreeField = (EditText) findViewById(R.id.question_three_field);
        String questionThreeAnswer = questionThreeField.getText().toString();
        if (questionThreeAnswer.equals("2")) {
            questionThreeResult = "Correct";
        }

        // checking if Question 4 is correct
        CheckBox JudicialCheckBox = (CheckBox) findViewById(R.id.judicial_checkbox);
        CheckBox ExecutiveCheckBox = (CheckBox) findViewById(R.id.executive_checkbox);
        boolean questionFourCorrect = (JudicialCheckBox.isChecked()) & (ExecutiveCheckBox.isChecked());
        if (questionFourCorrect) {
            questionFourResult = "Correct";
        }
        String resultMessage = createQuizSummary(name, questionOneResult, questionTwoResult, questionThreeResult, questionFourResult);
        displayMessage(resultMessage);

    }


    private String createQuizSummary(String name, String questionOneResult, String questionTwoResult, String questionThreeResult, String questionFourResult) {
        String resultMessage = "Name: " + name;
        resultMessage += "\nQuestion 1: " + questionOneResult;
        resultMessage += "\nQuestion 2: " + questionTwoResult;
        resultMessage += "\nQuestion 3: " + questionThreeResult;
        resultMessage += "\nQuestion 4: " + questionFourResult;
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
