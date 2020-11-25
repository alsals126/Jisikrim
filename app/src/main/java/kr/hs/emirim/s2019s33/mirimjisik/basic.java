package kr.hs.emirim.s2019s33.mirimjisik;
//기본 틀
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class basic extends AppCompatActivity {

    private FragmentManager fragmentManager=getSupportFragmentManager();
    private home homeLayout=new home(); //홈
    private my myLayout=new my(); //my
    private search search =new search(); //카테고리
    private startChat chat =new startChat(); //채팅

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_layout);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomLayout);
        //첫 화면 지정
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.mainFrame,homeLayout).commitAllowingStateLoss();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                switch (menuItem.getItemId()){
                    case R.id.action_home:{
                        transaction.replace(R.id.mainFrame,homeLayout).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.action_search:{
                        transaction.replace(R.id.mainFrame, search).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.action_chat:{
                        transaction.replace(R.id.mainFrame, chat).commitAllowingStateLoss();
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
    }
}