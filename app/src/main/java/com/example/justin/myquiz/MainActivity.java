package com.example.justin.myquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //  Declare RadioButton views for multiple choice answers
    RadioButton answerOne;
    RadioButton answerTwo;
    RadioButton answerFive;
    RadioButton answerTen;

    //  Declare EditText views for the fill-in-the-blank answers
    EditText answerThree;
    EditText answerFour;
    EditText answerSeven;
    EditText answerEight;
    EditText answerNine;

    //  Declare CheckBox views for Question 6
    CheckBox attendedHarvard;
    CheckBox asstSecyNavy;
    CheckBox governorNewYork;

    //  Boolean values for each question:  false for incorrect; true for correct
    //  All variables initialized to false
    boolean questionOneCorrect = false;
    boolean questionTwoCorrect = false;
    boolean questionThreeCorrect = false;
    boolean questionFourCorrect = false;
    boolean questionFiveCorrect = false;
    boolean questionSixCorrect = false;
    boolean questionSevenCorrect = false;
    boolean questionEightCorrect = false;
    boolean questionNineCorrect = false;
    boolean questionTenCorrect = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Find RadioButton views for Questions 1, 2, 5, 10
        answerOne = findViewById(R.id.span_am_war);
        answerTwo = findViewById(R.id.wm_mckinley);
        answerFive = findViewById(R.id.niece);
        answerTen = findViewById(R.id.city_tehran);

        //  Find EditText views for Questions 3, 4, 7, 8, 9
        answerThree = findViewById(R.id.answer3);
        answerFour = findViewById(R.id.answer4);
        answerSeven = findViewById(R.id.answer7);
        answerEight = findViewById(R.id.answer8);
        answerNine = findViewById(R.id.answer9);

        //  Find CheckBox views for Question 6
        attendedHarvard = findViewById(R.id.attended_harvard);
        asstSecyNavy = findViewById(R.id.asst_secy_navy);
        governorNewYork = findViewById(R.id.governor_new_york);
    }

    /**
     * Method to check each RadioButton that specifies a correct answer; sets boolean questionXXXCorrect
     * accordingly
     */
    private void checkRadioButtonAnswers() {
        //  RadioButton isChecked method found on StackOverflow:
        //  https://stackoverflow.com/questions/11050074/how-to-check-if-radiobutton-is-checked

        //  check each RadioButton view to see if they're checked
        questionOneCorrect = answerOne.isChecked();
        questionTwoCorrect = answerTwo.isChecked();
        questionFiveCorrect = answerFive.isChecked();
        questionTenCorrect = answerTen.isChecked();
    }

    /**
     * Method to check each EditText view for the correct answer; use equalsIgnoreCase method to see if input text
     * matches answer string retrieved from res/strings; set boolean of questionXXXCorrect accordingly
     */
    private void checkEditTextAnswers() {
        //  getResources method found on StackOverflow:
        //  https://stackoverflow.com/questions/7493287/android-how-do-i-get-string-from-resources-using-its-name
        //
        //  equalsIgnoreCase method found on StackOverflow:
        //  https://stackoverflow.com/questions/6819604/comparison-of-two-strings-doesnt-work-in-android

        //  check all EditText views for correct answers
        questionThreeCorrect = answerThree.getText().toString().equalsIgnoreCase(getResources().getString(R.string.the_progressive_party));
        questionFourCorrect = answerFour.getText().toString().equalsIgnoreCase(getResources().getString(R.string.sagamore_hill));
        questionSevenCorrect = answerSeven.getText().toString().equalsIgnoreCase(getResources().getString(R.string.warm_springs));
        questionEightCorrect = answerEight.getText().toString().equalsIgnoreCase(getResources().getString(R.string.supreme_court));
        questionNineCorrect = answerNine.getText().toString().equalsIgnoreCase(getResources().getString(R.string.social_security));
    }

    /**
     * Method to check if the CheckBox views in Question 6 are checked; in this instance, all check boxes must be checked
     * in order for the answer to be correct; sets questionSixCorrect accordingly
     */
    private void checkCheckBoxAnswers() {
        //  check all CheckBox views to see if they're selected
        questionSixCorrect = (attendedHarvard.isChecked()) && (asstSecyNavy.isChecked()) && (governorNewYork.isChecked());
    }

    /**
     * Method to calculate the number of correct answers.  Called by "displayScore" when the "Total Score" button
     * is pressed at the end of the quiz; tests if the boolean for each question - "questionXXXCorrect" - is true,
     * and if true adds 1 to "totalScore".
     *
     * Global boolean values were used (instead of calling the various view methods here) to keep the code clean and
     * comprehensible;
     *
     * @return int total score -- the number of correct answers
     */
    private int calculateScore() {
        int totalScore = 0;

        if (questionOneCorrect)
            totalScore += 1;
        if (questionTwoCorrect)
            totalScore += 1;
        if (questionThreeCorrect)
            totalScore += 1;
        if (questionFourCorrect)
            totalScore += 1;
        if (questionFiveCorrect)
            totalScore += 1;
        if (questionSixCorrect)
            totalScore += 1;
        if (questionSevenCorrect)
            totalScore += 1;
        if (questionEightCorrect)
            totalScore += 1;
        if (questionNineCorrect)
            totalScore += 1;
        if (questionTenCorrect)
            totalScore += 1;
        return totalScore;
    }

    /**
     * Method to display the number of correct answers in the quiz.  Called when the "Total Score"
     * button is pressed.  Method calls "calculateScore" and generates one of three messages based
     * on the number of correct answers:  "Show off!  You got all 10 right!" for 10 correct answers;
     * "Embarrassing!  You only got 'X' right." for 1 to 9 correct answers; and "Zero right!
     * Are you dead?"  for 0 correct answers.
     *
     * @param view of Button "Total Score"
     */
    public void displayScore(View view) {

        String message;

        //  Call methods to check for the correct answers to the three types of questions
        checkRadioButtonAnswers();
        checkEditTextAnswers();
        checkCheckBoxAnswers();

        //  Formatting for inserting a string variable into resource string found at tutsplus.com:
        //  https://code.tutsplus.com/tutorials/android-sdk-quick-tip-formatting-resource-strings--mobile-1775
        if (calculateScore() == 10) {
            //  message:  Show off!  You got all 10 right!
            message = getResources().getString(R.string.all_correct);
            message = String.format(message, calculateScore());
        }
        else if (calculateScore() != 0) {
            //  message:  Embarrassing!  You only got "X" right.
            message = getResources().getString(R.string.needs_work);
            message = String.format(message, calculateScore());
        } else {
            //  message:  Zero right!  Are you dead?
            message = getResources().getString(R.string.none_right);
        }

        //  Toast to display final score message
        Toast.makeText(MainActivity.this, message,
                Toast.LENGTH_LONG).show();
    }
}
