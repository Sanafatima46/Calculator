package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.calculator.ViewModles.CalcModle;
import com.example.calculator.databinding.ActivityMainBinding;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityMainBinding activityMainBinding;
    private String result;
    private CalcModle calcModle;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        calcModle = new ViewModelProvider(this).get(CalcModle.class);
        activityMainBinding.eval.setOnClickListener(this);
        settingButtons();
       calcModle.setText("0.0");
        //Observing the result
        calcModle.getData().observe(this,(data)->{
            activityMainBinding.setResult(data);
        });
    }

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String text = button.getText().toString();

        if (text.equals("C")){
            if (textView.getText().toString().length()>1 && !textView.getText().toString().equals("0.0") ){
                String substring = textView.getText().toString().substring(0, textView.getText().toString().length() - 1);
                calcModle.setText(substring);
            }else {
                    calcModle.setText("0.0");
            }

               return;
        }

        if (text.equals("AC")){
            calcModle.setText("0.0");
            return;
        }
        if (text.equals("=")){
            calcModle.eval(textView.getText().toString());
            return;
        }
        if (textView.getText().toString().equals("0.0") ||textView.getText().toString().isEmpty()){
            calcModle.setText(text.toString());
            return;
        }
        calcModle.setText(textView.getText().toString()+text);



    }

    void settingButtons(){
        // all buttons num
        activityMainBinding.one.setOnClickListener(this);
        activityMainBinding.two.setOnClickListener(this);
        activityMainBinding.three.setOnClickListener(this);
        activityMainBinding.four.setOnClickListener(this);
        activityMainBinding.five.setOnClickListener(this);
        activityMainBinding.six.setOnClickListener(this);
        activityMainBinding.seven.setOnClickListener(this);
        activityMainBinding.eight.setOnClickListener(this);
        activityMainBinding.nine.setOnClickListener(this);
        activityMainBinding.zero.setOnClickListener(this);
        //operators
        activityMainBinding.eval.setOnClickListener(this);
        activityMainBinding.plus.setOnClickListener(this);
        activityMainBinding.mul.setOnClickListener(this);
        activityMainBinding.minus.setOnClickListener(this);
        activityMainBinding.div.setOnClickListener(this);
        //special
        activityMainBinding.bracketOpen.setOnClickListener(this);
        activityMainBinding.bracketClose.setOnClickListener(this);
        activityMainBinding.ac.setOnClickListener(this);
        activityMainBinding.clear.setOnClickListener(this);
        activityMainBinding.point.setOnClickListener(this);
        textView = activityMainBinding.output;
    }
}