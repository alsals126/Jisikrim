package kr.hs.emirim.s2019s33.mirimjisik;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inputquestion_layout);

        Spinner spinner = (Spinner) findViewById(R.id.subjects);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.FreshmanSubjects, android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
//
//        Button btnNew=(Button)findViewById(R.id.btn_new);
//        Button btnLogin=(Button)findViewById(R.id.btn_login);
//
//        btnNew.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(MainActivity.this,membership.class);
//                startActivity(intent);
//            }
//        });
//
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Intent intent=new Intent(MainActivity.this,chatting.class);
//                Intent intent = new Intent(MainActivity.this, mainviewActivity.class);
//                startActivity(intent);
//            }
//        });

    }
}