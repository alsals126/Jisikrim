package kr.hs.emirim.s2019s33.mirimjisik;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import android.content.Intent;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
//import android.widget.Button;


public class my extends Fragment {
    RecyclerView mRecyclerView = null ;
    QuestionListAdapter mAdapter = null ;
    ArrayList<QuestionList> mList = new ArrayList<QuestionList>();

    private static final String TAG = "my";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_my, container, false);

        mRecyclerView = v.findViewById(R.id.my_recycler_view) ;

        // 리사이클러뷰에 SimpleTextAdapter 객체 지정.
        mAdapter = new QuestionListAdapter(mList) ;
        mRecyclerView.setAdapter(mAdapter) ;

        // 리사이클러뷰에 LinearLayoutManager 지정. (vertical)
        RecyclerView recyclerView = v.findViewById(R.id.my_recycler_view) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext())) ;

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("posts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()) {
                            mList.clear();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                if(FirebaseAuth.getInstance().getCurrentUser().getUid().toString().equals(document.getData().get("publisher").toString())) {
                                    addItem(document.getData().get("imagepath").toString(),
                                            "[궁금증]", document.getData().get("title").toString());
                                    mAdapter.notifyDataSetChanged();
                                }
                            }
                        }else{
                            Log.d(TAG, "Error(bring storedata-title): ", task.getException());
                        }
                    }
                });
        System.out.println("아유융");

      /*  // 아이템 추가.
        addItem(ContextCompat.getDrawable(this.getContext(), R.drawable.deldel),
                "Box", "Account Box Black 36dp") ;
        // 두 번째 아이템 추가.
        addItem(ContextCompat.getDrawable(this.getContext(), R.drawable.deldel),
                "Circle", "Account Circle Black 36dp") ;
        // 세 번째 아이템 추가.
        addItem(ContextCompat.getDrawable(this.getContext(), R.drawable.rogo),
                "Ind", "Assignment Ind Black 36dp") ;
        addItem(ContextCompat.getDrawable(this.getContext(), R.drawable.rogo),
                "last", "난 몰랑!") ;*/

        /*mAdapter.notifyDataSetChanged() ;*/

        return v;
    }
    public void addItem(String icon, String sol, String title) {
        QuestionList item = new QuestionList(icon, sol, title);

        item.setDrawable(icon);
        item.setSol(sol);
        item.setTitle(title);

        mList.add(item);
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