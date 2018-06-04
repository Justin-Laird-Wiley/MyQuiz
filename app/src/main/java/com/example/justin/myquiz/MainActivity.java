package com.example.justin.myquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
//import android.widget.CheckBox;
import android.widget.CheckBox;
import android.widget.EditText;
//import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //  String variable to hold player name; used in Toast when score displayed.
    //  Defaults to "Player" if no name is entered.
    String playerName = "Player";

    //  EditText views for the fill-in-the-blank answers
    EditText answerThree;
    EditText answerFour;
    EditText answerSeven;
    EditText answerEight;
    EditText answerNine;

    CheckBox attendedHarvard;
    CheckBox asstSecyNavy;
    CheckBox governorNewYork;

    //  Boolean values for each question:  false for incorrect; true for correct.
    //  All variables initialized to false.
    boolean question1 = false;
    boolean question2 = false;
    boolean question3 = false;
    boolean question4 = false;
    boolean question5 = false;
    boolean question6 = false;
    boolean question7 = false;
    boolean question8 = false;
    boolean question9 = false;
    boolean question10 = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answerThree = findViewById(R.id.answer3);
        answerFour = findViewById(R.id.answer4);
        answerSeven = findViewById(R.id.answer7);
        answerEight = findViewById(R.id.answer8);
        answerNine = findViewById(R.id.answer9);

        attendedHarvard = findViewById(R.id.attended_harvard);
        asstSecyNavy = findViewById(R.id.asst_secy_navy);
        governorNewYork = findViewById(R.id.governor_new_york);
    }

    /**
     * This method reads the name entered in the EditText view, and reads it into playerName.
     * Called by displayScore
     */
    private void getPlayerName() {

//        EditText quizNameTextView = (EditText) findViewById(R.id.player_name_edit_text);
//        playerName = quizNameTextView.getText().toString();
    }

    /**
     * This method performs an "if-else" statement on each question to see if the correct
     * radio button was clicked.  The "if" part will set a boolean value to true for a
     * correct answer, and the "else" part will set the boolean to false if either of the
     * incorrect answers is checked.  Called whenever a radio button is clicked.
     *
     * @param view of RadioButton that is checked
     */
    public void checkCorrect(View view) {

        // RadioButton syntax and methods found at the Android Developer website:
        // https://developer.android.com/guide/topics/ui/controls/radiobutton

        // check question 1
        if (view.getId() == R.id.span_am_war)
            question1 = true;
        else if ((view.getId() == R.id.w_w_i) || (view.getId() == R.id.mex_am_war))
            question1 = false;

        // check question 2
        if (view.getId() == R.id.wm_mckinley)
            question2 = true;
        else if ((view.getId() == R.id.james_garfield) || (view.getId() == R.id.abe_lincoln))
            question2 = false;

        // check question 5
        if (view.getId() == R.id.asst_secty_navy)
            question5 = true;
        else if ((view.getId() == R.id.insp_gen_army) || (view.getId() == R.id.pres_army_war_college))
            question5 = false;

        // check question 7
        if (view.getId() == R.id.niece)
            question7 = true;
        else if ((view.getId() == R.id.second_cousin) || (view.getId() == R.id.stepdaughter))
            question7 = false;

        // check question 8
        if (view.getId() == R.id.year_of_1921)
            question8 = true;
        else if ((view.getId() == R.id.year_of_1914) || (view.getId() == R.id.year_of_1934))
            question8 = false;

        // check question 10
        if (view.getId() == R.id.city_tehran)
            question10 = true;
        else if ((view.getId() == R.id.city_baghdad) || (view.getId() == R.id.city_jerusalem))
            question10 = false;
    }

    private void checkEditTextAnswers() {



        CheckBox attendedHarvard = (CheckBox) findViewById(R.id.attended_harvard);
        boolean hasChocolate = attendedHarvard.isChecked();



        // getResources method found on StackOverflow:
        // https://stackoverflow.com/questions/7493287/android-how-do-i-get-string-from-resources-using-its-name



        //
        // https://stackoverflow.com/questions/6819604/comparison-of-two-strings-doesnt-work-in-android

        // check question3
        question3 = answerThree.getText().toString().equalsIgnoreCase(getResources().getString(R.string.the_progressive_party));

        // check question4
        question4 = answerFour.getText().toString().equalsIgnoreCase(getResources().getString(R.string.sagamore_hill));

        // check question7
        question7 = answerSeven.getText().toString().equalsIgnoreCase(getResources().getString(R.string.warm_springs));

        // check question8
        question8 = answerEight.getText().toString().equalsIgnoreCase(getResources().getString(R.string.supreme_court));

        // check question9
        question9 = answerNine.getText().toString().equalsIgnoreCase(getResources().getString(R.string.social_security));
    }

    /**
     * Method to calculate the number of correct answers.  Called by "displayScore" when the
     * "Total Score" button is pressed at the end of the quiz.   Tests if the boolean for each
     * question - "questionX" - is true, and if true adds 1 to "totalScore".
     *
     * @return int total score -- the number of correct answers
     */
    private int calculateScore() {
        int totalScore = 0;

        if (question1)
            totalScore += 1;
        if (question2)
            totalScore += 1;
        if (question3)
            totalScore += 1;
        if (question4)
            totalScore += 1;
        if (question5)
            totalScore += 1;
        if (question6)
            totalScore += 1;
        if (question7)
            totalScore += 1;
        if (question8)
            totalScore += 1;
        if (question9)
            totalScore += 1;
        if (question10)
            totalScore += 1;
        return totalScore;
    }

    /**
     * Method to display the number of correct answers in the quiz.  Called when the "Total Score"
     * button is pressed.  Method calls "calculateScore" and uses the returned "score" in a toast
     * message.
     *
     * @param view of Button "Total Score"
     */
    public void displayScore(View view) {
        int finalScore;

        checkEditTextAnswers();
//        getPlayerName();
        //  Call method to calculate number of correct answers
        finalScore = calculateScore();

        // Toast to display final score
        Toast.makeText(MainActivity.this, playerName + ", your score is:  " + finalScore,
                Toast.LENGTH_LONG).show();
    }
}
