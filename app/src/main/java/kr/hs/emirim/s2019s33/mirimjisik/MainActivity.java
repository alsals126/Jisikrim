package kr.hs.emirim.s2019s33.mirimjisik;
//로그인 화면
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/*import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;*/

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager=getSupportFragmentManager();
    private mainviewActivity mainLayout=new mainviewActivity(); //홈
    private questionActivity myLayout=new questionActivity(); //my
    private category Category=new category(); //카테고리
    private chatting Chatting=new chatting(); //채팅
    //private login Login=new login(); //로그인 시작화면

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomLayout);
        //첫 화면 지정
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.mainFrame,mainLayout).commitAllowingStateLoss();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                switch (menuItem.getItemId()){
                    case R.id.action_home:{
                        transaction.replace(R.id.mainFrame,mainLayout).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.action_search:{
                        transaction.replace(R.id.mainFrame,Category).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.action_chat:{
                        transaction.replace(R.id.mainFrame,Chatting).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.action_my:{
                        transaction.replace(R.id.mainFrame,myLayout).commitAllowingStateLoss();
                        break;
                    }
                }

                return true;
            }
        });

//        btnNew.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, membership.class);
//                startActivity(intent);
//            }
//        });
//
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, mainviewActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}
// 데이터베이스 연결 확인
/*
public class MainActivity extends AppCompatActivity {

    private Button sendbt;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendbt = (Button) findViewById(R.id.button);

        sendbt.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                // 버튼 누르면 수행 할 명령
                databaseReference.child("message").push().setValue("2");
            }
        });
    }
}*/