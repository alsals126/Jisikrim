package kr.hs.emirim.s2019s33.mirimjisik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class inputquestion_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inputquestion_layout);

        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int result;
                Spinner spinner = (Spinner) findViewById(R.id.subjects);
                ArrayAdapter<CharSequence> adapter;

                if(checkedId == R.id.Sophomore)
                    result = R.array.SecondSubjects;
                else if(checkedId == R.id.Junior)
                    result = R.array.ThirdnSubjects;
                else
                    result = R.array.FreshmanSubjects;

                adapter= ArrayAdapter.createFromResource(
                        getApplicationContext(), result, android.R.layout.simple_spinner_item
                );
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }
        });

    }
}