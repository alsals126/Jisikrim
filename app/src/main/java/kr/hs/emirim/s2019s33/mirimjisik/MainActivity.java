package kr.hs.emirim.s2019s33.mirimjisik;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
//
//        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                int result;
//                Spinner spinner = (Spinner) findViewById(R.id.subjects);
//                ArrayAdapter<CharSequence> adapter;
//
//                if(checkedId == R.id.Sophomore)
//                    result = R.array.SecondSubjects;
//                else if(checkedId == R.id.Junior)
//                    result = R.array.ThirdnSubjects;
//                else
//                    result = R.array.FreshmanSubjects;
//
//                adapter= ArrayAdapter.createFromResource(
//                        getApplicationContext(), result, android.R.layout.simple_spinner_item
//                );
//                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                spinner.setAdapter(adapter);
//            }
//        });

        Button btnNew=(Button)findViewById(R.id.btn_new);
        Button btnLogin=(Button)findViewById(R.id.btn_login);

        btnNew.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,membership.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, mainviewActivity.class);
                startActivity(intent);
            }
        });

    }
}