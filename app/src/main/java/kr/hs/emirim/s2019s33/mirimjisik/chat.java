package kr.hs.emirim.s2019s33.mirimjisik;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class chat extends Fragment {
    RecyclerView mRecyclerView = null ;
    chatadapter mAdapter = null ;
    ArrayList<chatitem> mList = new ArrayList<chatitem>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_chat, container, false);

        mRecyclerView = v.findViewById(R.id.my_recycler_view2) ;

        // 리사이클러뷰에 SimpleTextAdapter 객체 지정.
        mAdapter = new chatadapter(mList) ;
        mRecyclerView.setAdapter(mAdapter) ;

        // 리사이클러뷰에 LinearLayoutManager 지정. (vertical)
        RecyclerView recyclerView = v.findViewById(R.id.my_recycler_view2) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext())) ;

        // 아이템 추가.
        addItem("Box", "Account Box Black 36dp") ;
        addItem("Box", "Account Box Black 36dp") ;
        addItem("Box", "Account Box Black 36dp") ;
        addItem("Box", "Account Box Black 36dp") ;
        addItem("Box", "Account Box Black 36dp") ;
        addItem("Box", "Account Box Black 36dp") ;
        addItem("Box", "Account Box Black 36dp") ;
        addItem("Box", "Account Box Black 36dp") ;
        addItem("Box", "Account Box Black 36dp") ;
        addItem("Box", "Account Box Black 36dp") ;
        addItem("Box", "Account Box Black 36dp") ;
        addItem("Box", "Account Box Black 36dp") ;
        addItem("Box", "Account Box Black 36dp") ;
        addItem("Box", "Account Box Black 36dp") ;
        addItem("Box", "Account Box Black 36dp") ;
        addItem("Box", "Account Box Black 36dp") ;


        /*// 두 번째 아이템 추가.
        addItem(ContextCompat.getDrawable(this.getContext(), R.drawable.deldel),
                "Circle", "Account Circle Black 36dp") ;
        // 세 번째 아이템 추가.
        addItem(ContextCompat.getDrawable(this.getContext(), R.drawable.rogo),
                "Ind", "Assignment Ind Black 36dp") ;
        addItem(ContextCompat.getDrawable(this.getContext(), R.drawable.rogo),
                "last", "난 몰랑!") ;*/

        mAdapter.notifyDataSetChanged() ;

        return v;
    }
    public void addItem(String title, String desc) {
        chatitem item = new chatitem(title, desc);

        item.setName(title);
        System.out.print(item.getName());
        item.setText(desc);

        mList.add(item);
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.chatting);
//
//        Button btnMain=(Button)findViewById(R.id.btn_main);
//        Button btnCategory=(Button)findViewById(R.id.btn_category);
//        Button btnMy=(Button)findViewById(R.id.btn_my);
//
//        btnMain.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(chatting.this, mainviewActivity.class);
//                startActivity(intent);
//            }
//        });
//        btnCategory.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(chatting.this, category.class);
//                startActivity(intent);
//            }
//        });
//        btnMy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(chatting.this, questionActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
}
