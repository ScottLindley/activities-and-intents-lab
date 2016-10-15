package co.ga.madlibs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mAdjective1;
    private EditText mAdjective2;
    private EditText mNoun1;
    private EditText mNoun2;
    private EditText mAnimals;
    private EditText mGame;
    private Button mSubmitButton;
    private EditText[] mTextInputs = new EditText[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdjective1 = (EditText)findViewById(R.id.adjective1);
        mAdjective2 = (EditText)findViewById(R.id.adjective2);
        mNoun1 = (EditText)findViewById(R.id.noun1);
        mNoun2 = (EditText)findViewById(R.id.noun2);
        mAnimals = (EditText)findViewById(R.id.animals);
        mGame = (EditText)findViewById(R.id.game);
        mSubmitButton = (Button)findViewById(R.id.submit_button);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextInputs[0] = mAdjective1;
                mTextInputs[1] = mAdjective2;
                mTextInputs[2] = mNoun1;
                mTextInputs[3] = mNoun2;
                mTextInputs[4] = mAnimals;
                mTextInputs[5] = mGame;

                for(EditText editText : mTextInputs){
                    if(editText.getText().toString().equals("")){
                        editText.setError("Please fill out!");
                        return;
                    }
                }
                /*
                If the user input for 'Animal (plural)' doesn't end in an 's', remind the user
                the input for this line must be pluralized.
                 */
                String animalsInput = mTextInputs[4].getText().toString();
                if(!(animalsInput.charAt(animalsInput.length()-1)=='s')){
                    mTextInputs[4].setError("Must be pluralized!");
                    return;
                }
                String[] inputStrings = new String[6];
                for(int i=0; i<mTextInputs.length; i++) {
                    inputStrings[i] = mTextInputs[i].getText().toString().toLowerCase();
                }
                    Intent toResult = new Intent(MainActivity.this, ResultActivity.class);
                    toResult.putExtra("INPUTS", inputStrings);
                startActivity(toResult);
            }
        });
    }
}
