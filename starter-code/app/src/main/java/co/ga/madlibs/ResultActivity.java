package co.ga.madlibs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by james on 12/7/15.
 */
public class ResultActivity extends AppCompatActivity {
    private Button mBackButton;
    private TextView mStory;
    private String mSentence1;
    private String mSentence2;
    private String mSentence3;
    private String mSentence4;
    private final String mVowels = "aeiou";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent receivedIntent = getIntent();
        String[] inputs = receivedIntent.getStringArrayExtra("INPUTS");

        mBackButton = (Button) findViewById(R.id.back_button);

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mStory = (TextView)findViewById(R.id.result_textview);





        mSentence1 = "I went to the zoo today and saw a bunch of <b>"+inputs[0]+" "+inputs[4]+"</b>.";
        /*Check to see if the inputs[1,2,3] begin with a vowel
          If they do, then make the previous word 'an' instead of 'a'.
         */
        if(mVowels.contains(Character.toString(inputs[2].charAt(0)))){
            mSentence2 = " The zookeepers had given them an <b>"+inputs[2]+"</b> to play with and " +
                    "they were trying to play <b>"+inputs[5]+"</b> with it.";
        }else{
            mSentence2 = " The zookeepers had given them a <b>"+inputs[2]+"</b> to play with and " +
                    "they were trying to play <b>"+inputs[5]+"</b> with it.";
        }
        if(mVowels.contains(Character.toString(inputs[3].charAt(0)))){
            mSentence3 = " Afterwards, dad bought me an <b>"+inputs[3]+"</b> for being a good boy.";
        }else{
            mSentence3 = " Afterwards, dad bought me a <b>"+inputs[3]+"</b> for being a good boy.";
        }
        if(mVowels.contains(Character.toString(inputs[1].charAt(0)))){
            mSentence4 = " What an <b>"+inputs[1]+"</b> day!";
        }else {
            mSentence4 = " What a <b>" + inputs[1] + "</b> day!";
        }

        //Now string the sentences together and set it to the TextView
        mStory.setText(Html.fromHtml(mSentence1 + mSentence2 + mSentence3 + mSentence4));

    }
}
