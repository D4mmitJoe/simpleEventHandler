package com.example.joem.examples;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

//instantiates implements interface when event happens, method below
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("demo", "Hello world"); //logcat debug
        Log.w("demo", "Hello world !!"); //logcat warning

        String stringName = getResources().getString(R.string.are_you_sure); //accessing string resource
        Log.d("demo", stringName); //calling string with logcat debug

        String[] stringArrayName = getResources().getStringArray(R.array.colors_array); //accessing string array
        for (String forStringName:stringArrayName) { //for-each looping through color string array
            Log.d("demo", forStringName);
        }

        //accessing button programmatically finding element by ID using annonymous class event handler
        Button buttonName = (Button) findViewById(R.id.buttonOk);
        Log.d("demo", "Button text is " + buttonName.getText().toString()); //prints text inside button to logcat debug
        buttonName.setOnClickListener(new View.OnClickListener() { //set OnClickListener and implement interface
            @Override
            public void onClick(View view) {
                Log.d("demo", "OK button clicked"); //prints to logcat debug when ok button is clicked
            }
        });

        //OnClickListener supplied by 'this' main activity implementation, calling the method below
        //If wired to the same handler, the same handler will be called, so 'if' statement created below to differentiate
        findViewById(R.id.buttonCancel).setOnClickListener(this);
        findViewById(R.id.buttonOtherCancel).setOnClickListener(this);

        RadioGroup radioGroupName = (RadioGroup) findViewById(R.id.radioGroup); //retrieves radio group by casting it
        radioGroupName.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override //method called when radio button is clicked/changed
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) { //retrieves id of checked radio button
                RadioButton radioButtonName = (RadioButton) findViewById(checkedId); //find id based on id coming in (checked)
                Log.d("demo", "Checked the " + radioButtonName.getText().toString()); //prints text of radio button to logcat debug
            }
        });

        //onClickListener that retrieves radio button id when getChecked button is clicked
        findViewById(R.id.buttonGetCheckedColor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup radioGroupName = (RadioGroup) findViewById(R.id.radioGroup);//accessing radioGroup resource by casting it
                //creates getCheckedId variable name to eliminate repetitive typing
                int variableName = radioGroupName.getCheckedRadioButtonId();
                if (variableName == R.id.radioButtonGreen){
                    Log.d("demo", "Checked is Green");
                }else if (variableName == R.id.radioButtonOrange){
                    Log.d("demo", "Checked is Orange");
                }else if (variableName == R.id.radioButtonPurple){
                    Log.d("demo", "Checked is Purple");
                }else if (variableName == -1){ //-1 means nothing is checked
                    Log.d("demo", "None is checked");
                }
            }
        });

        SeekBar seekBarName = (SeekBar) findViewById(R.id.seekBar); //accessing seekbar resource
        final TextView textViewName = (TextView) findViewById(R.id.textViewProgress); //accesses textView resource
        //set to 'final' to increase scope, else it would end when method below ends
        seekBarName.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { //implements seekBar interface
            //moving the seekBar requires a handler that is implemented below
            @Override
            public void onProgressChanged(SeekBar seekBar, int integerName_Progress, boolean b) {
                Log.d("demo", integerName_Progress + ""); //"" syntax changes/concatenates (integerName_Progress) to string
                //prints progress to logcat debug
                textViewName.setText(integerName_Progress + "");//sets text of textViewName of textViewProgress to int progress
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        }); //event handler
    }

    @Override //event handler IMPLEMENT method, from line 9
    public void onClick(View view) {
        if (view.getId() == R.id.buttonCancel){ //'if-else' statement created to differentiate 'views' via 'id'
            Log.d("demo", "Cancel button clicked");
        }else if (view.getId() == R.id.buttonOtherCancel){
            Log.d("demo", "Other cancel button clicked");
        }
    }

    public void otherButtonClicked(View view){ //event handler method from xml
        Log.d("demo", "Other button clicked");
    }
}
