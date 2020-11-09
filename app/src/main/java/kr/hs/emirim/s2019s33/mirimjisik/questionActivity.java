package kr.hs.emirim.s2019s33.mirimjisik;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import android.content.Intent;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
//import android.widget.Button;

import java.util.ArrayList;

public class questionActivity extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my_layout, container, false);
    }

//    RecyclerView mRecyclerView = null ;
//    QuestionListAdapter mAdapter = null ;
//    ArrayList<QuestionList> mList = new ArrayList<QuestionList>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.my_layout);
//
//        Button btnMain=(Button)findViewById(R.id.btn_main);
//        Button btnCategory=(Button)findViewById(R.id.btn_category);
//        Button btnChatting=(Button)findViewById(R.id.btn_chatting);
//
//        btnMain.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(questionActivity.this, mainviewActivity.class);
//                startActivity(intent);
//            }
//        });
//        btnCategory.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(questionActivity.this, category.class);
//                startActivity(intent);
//            }
//        });
//        btnChatting.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(questionActivity.this,chatting.class);
//                startActivity(intent);
//            }
//        });
//
//        mRecyclerView = findViewById(R.id.my_recycler_view) ;
//
//        // 리사이클러뷰에 SimpleTextAdapter 객체 지정.
//        mAdapter = new QuestionListAdapter(mList) ;
//        mRecyclerView.setAdapter(mAdapter) ;
//
//        // 리사이클러뷰에 LinearLayoutManager 지정. (vertical)
//        RecyclerView recyclerView = findViewById(R.id.my_recycler_view) ;
//        recyclerView.setLayoutManager(new LinearLayoutManager(this)) ;
//
//        // 아이템 추가.
//        addItem(ContextCompat.getDrawable(this, R.drawable.deldel),
//                "Box", "Account Box Black 36dp") ;
//        // 두 번째 아이템 추가.
//        addItem(ContextCompat.getDrawable(this, R.drawable.deldel),
//                "Circle", "Account Circle Black 36dp") ;
//        // 세 번째 아이템 추가.
//        addItem(ContextCompat.getDrawable(this, R.drawable.deldel),
//                "Ind", "Assignment Ind Black 36dp") ;
//
//        mAdapter.notifyDataSetChanged() ;
//    }
//    public void addItem(Drawable icon, String title, String desc) {
//        QuestionList item = new QuestionList();
//
//        item.setDrawable(icon);
//        item.setName1(title);
//        item.setName2(desc);
//
//        mList.add(item);
//    }
}