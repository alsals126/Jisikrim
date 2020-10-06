package kr.hs.emirim.s2019s33.mirimjisik;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class mainviewActivity extends AppCompatActivity {
    RecyclerView mRecyclerView = null ;
    QuestionListAdapter mAdapter = null ;
    ArrayList<QuestionList> mList = new ArrayList<QuestionList>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        Button btnChatting=(Button)findViewById(R.id.btn_chatting);
        Button btnCategory=(Button)findViewById(R.id.btn_category);
        Button btnMy=(Button)findViewById(R.id.btn_my);

        btnCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainviewActivity.this, category.class);
                startActivity(intent);
            }
        });
        btnChatting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainviewActivity.this, chatting.class);
                startActivity(intent);
            }
        });
        btnMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainviewActivity.this, questionActivity.class);
                startActivity(intent);
            }
        });

        mRecyclerView = findViewById(R.id.mainRecyclerview) ;

        // 리사이클러뷰에 SimpleTextAdapter 객체 지정.
        mAdapter = new QuestionListAdapter(mList) ;   //mainListAdapter로 바꾸기
        mRecyclerView.setAdapter(mAdapter) ;

        // 리사이클러뷰에 LinearLayoutManager 지정. (vertical)
        RecyclerView recyclerView = findViewById(R.id.mainRecyclerview) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this)) ;

        // 아이템 추가.
        addItem(ContextCompat.getDrawable(this, R.drawable.deldel),
                "Box", "Account Box Black 36dp") ;
        // 두 번째 아이템 추가.
        addItem(ContextCompat.getDrawable(this, R.drawable.deldel),
                "Circle", "Account Circle Black 36dp") ;
        // 세 번째 아이템 추가.
        addItem(ContextCompat.getDrawable(this, R.drawable.deldel),
                "Ind", "Assignment Ind Black 36dp") ;
        addItem(ContextCompat.getDrawable(this, R.drawable.deldel),
                "Ind", "Assignment Ind Black 36dp") ;
        addItem(ContextCompat.getDrawable(this, R.drawable.deldel),
                "Ind", "Assignment Ind Black 36dp") ;

        mAdapter.notifyDataSetChanged() ;
    }
    public void addItem(Drawable icon, String title, String desc) {
        QuestionList item = new QuestionList();

        item.setDrawable(icon);
        item.setName1(title);
        item.setName2(desc);

        mList.add(item);
    }
}