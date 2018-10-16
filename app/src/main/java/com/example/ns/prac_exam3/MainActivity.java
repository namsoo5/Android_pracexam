package com.example.ns.prac_exam3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean check;
    boolean input2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btok =  findViewById(R.id.btok);
        final EditText et1 = findViewById(R.id.et1);
        final EditText et2 = findViewById(R.id.et2);
        RadioGroup rginput = findViewById(R.id.rginput);
        final CheckBox cb = findViewById(R.id.cbsave);
        final TableRow trhide = findViewById(R.id.trhide);



        btok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input2) {
                    if (check)
                        Toast.makeText(getApplicationContext(), "input1: " + et1.getText() + " input2: " + et2.getText() + "(Save)", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getApplicationContext(), "input1: " + et1.getText() + " input2: " + et2.getText(), Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "input1: " + et1.getText() + " input2: ", Toast.LENGTH_SHORT).show();
                }

            }
        });

        rginput.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rbinput1:
                        et1.setText("");
                        trhide.setVisibility(View.GONE);
                        input2=false;
                        cb.setChecked(false);
                        break;
                    case R.id.rbinput2:
                        et1.setText("");
                        et2.setText("");
                        trhide.setVisibility(View.VISIBLE);
                        input2=true;
                        break;
                }
            }
        });

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    check=true;
                else
                    check=false;
            }
        });

        et1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE)
                {
                    if(input2) {
                        if (check)
                            Toast.makeText(getApplicationContext(), "input1: " + et1.getText() + " input2: " + et2.getText() + "(Save)", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getApplicationContext(), "input1: " + et1.getText() + " input2: " + et2.getText(), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "input1: " + et1.getText() + " input2: ", Toast.LENGTH_SHORT).show();
                    }
                }

                return false;
            }
        });

        et2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    if(input2) {
                        if (check)
                            Toast.makeText(getApplicationContext(), "input1: " + et1.getText() + " input2: " + et2.getText() + "(Save)", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getApplicationContext(), "input1: " + et1.getText() + " input2: " + et2.getText(), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "input1: " + et1.getText() + " input2: ", Toast.LENGTH_SHORT).show();
                    }
                }
                return false;
            }
        });

        final FrameLayout fl = (FrameLayout) View.inflate(getApplicationContext(), R.layout.inflate_frame, null);
        LinearLayout ll = findViewById(R.id.ll);

        ll.addView(fl);

       RadioGroup rgview = findViewById(R.id.rgview);
        final TextView tv = fl.findViewById(R.id.tvinflate);
        final ImageView iv = fl.findViewById(R.id.ivinflate);

       rgview.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {
               switch(checkedId){
                   case R.id.rbtext:
                       tv.setVisibility(View.VISIBLE);
                       iv.setVisibility(View.INVISIBLE);
                       break;
                   case R.id.rbimage:
                       tv.setVisibility(View.INVISIBLE);
                       iv.setVisibility(View.VISIBLE);

               }
           }
       });



    }
}
