//package com.example.javaprojectlogin;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
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
//                Intent intent=new Intent(MainActivity.this,chatting.class);
//                startActivity(intent);
//            }
//        });
//
//    }
//}