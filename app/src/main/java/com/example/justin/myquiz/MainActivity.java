package com.example.justin.myquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
//import android.widget.CheckBox;
import android.widget.EditText;
//import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //  String variable to hold player name; used in Toast when score displayed.
    //  Defaults to "Player" if no name is entered.
    String playerName = "Player";

    // Booleans for answers
    boolean answerOneCorrect = false;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
     * This method checks the rubric-compliance CheckBox.  If isChecked() is true, compliance_message
     * is displayed; if false, the text is set to blank ("").
     * @param view of CheckBox
     */
    public void displayComplianceMessage(View view) {

        //  Find the CheckBox and TextView and create objects for them
//        CheckBox isBoxChecked = (CheckBox) findViewById(R.id.compliance_check_box);
//        TextView complianceDisplayText = (TextView) findViewById(R.id.compliance_message);
//
//        if (isBoxChecked.isChecked()){
//            complianceDisplayText.setText(R.string.compliance_message);
//        } else
//            complianceDisplayText.setText("");
    }

    public void getAnswer(View veiw) {
        int score = 0;
        EditText theAnswer = findViewById(R.id.answer1);
        String answerString = theAnswer.getText().toString();
        if (answerString.equalsIgnoreCase("couch")) {
            answerOneCorrect = true;
            score += 1;
        }

        // Toast to display final score
        Toast.makeText(MainActivity.this, playerName + ", your score is:  " + score,
                Toast.LENGTH_LONG).show();
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

//        // check question 1
//        if (view.getId() == R.id.lynn)
//            question1 = true;
//        else if ((view.getId() == R.id.lawrence) || (view.getId() == R.id.lowell))
//            question1 = false;
//
//        // check question 2
//        if (view.getId() == R.id.amherst)
//            question2 = true;
//        else if ((view.getId() == R.id.northampton) || (view.getId() == R.id.south_hadley))
//            question2 = false;
//
//        // check question 3
//        if (view.getId() == R.id.year_1926)
//            question3 = true;
//        else if ((view.getId() == R.id.year_1933) || (view.getId() == R.id.year_1940))
//            question3 = false;
//
//        // check question 4
//        if (view.getId() == R.id.boston_university)
//            question4 = true;
//        else if ((view.getId() == R.id.harvard) || (view.getId() == R.id.boston_college))
//            question4 = false;
//
//        // check question 5
//        if (view.getId() == R.id.springfield)
//            question5 = true;
//        else if ((view.getId() == R.id.wocrcester) || (view.getId() == R.id.pittsfield))
//            question5 = false;
//
//        // check question 6
//        if (view.getId() == R.id.religious_liberty)
//            question6 = true;
//        else if ((view.getId() == R.id.unpaid_taxes) || (view.getId() == R.id.plagarism))
//            question6 = false;
//
//        // check question 7
//        if (view.getId() == R.id.old_state_house)
//            question7 = true;
//        else if ((view.getId() == R.id.old_north_church) || (view.getId() == R.id.faneuil_hall))
//            question7 = false;
//
//        // check question 8
//        if (view.getId() == R.id.war_of_1812)
//            question8 = true;
//        else if ((view.getId() == R.id.revolutionary_war) || (view.getId() == R.id.mexican_american_war))
//            question8 = false;
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

//        getPlayerName();
        //  Call method to calculate number of correct answers
        finalScore = calculateScore();

        // Toast to display final score
        Toast.makeText(MainActivity.this, playerName + ", your score is:  " + finalScore,
                Toast.LENGTH_LONG).show();
    }
}
