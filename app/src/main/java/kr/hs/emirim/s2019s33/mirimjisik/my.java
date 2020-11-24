package kr.hs.emirim.s2019s33.mirimjisik;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;

public class my extends Fragment {
    RecyclerView mRecyclerView = null ;
    QuestionListAdapter mAdapter = null ;
    ArrayList<QuestionList> mList = new ArrayList();
    ArrayList<PostList> pList = new ArrayList();

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
        mAdapter = new QuestionListAdapter(mList, pList) ;
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
                            pList.clear();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                if(FirebaseAuth.getInstance().getCurrentUser().getUid().equals(document.getData().get("publisher").toString())) {
                                    addItem(document.getData().get("imagepath").toString(),
                                            "[궁금증]", document.getData().get("title").toString());
                                    addPost(document.getData().get("title").toString(),
                                            document.getData().get("imagepath").toString(),
                                            document.getData().get("contents").toString(),
                                            document.getData().get("grade").toString(),
                                            document.getData().get("publisher").toString(),
                                            document.getData().get("subject").toString());
                                    mAdapter.notifyDataSetChanged();
                                }
                            }
                        }else{
                            Log.d(TAG, "Error(bring storedata-title): ", task.getException());
                        }
                    }
                });
        return v;
    }
    public void addItem(String icon, String sol, String title) {
        QuestionList item = new QuestionList(icon, sol, title);

        item.setDrawable(icon);
        item.setSol(sol);
        item.setTitle(title);

        mList.add(item);
    }
    public void addPost(String title, String image, String contents, String grade, String publisher, String subject) {
        PostList item = new PostList(title, image, contents, grade, publisher, subject);

        item.setTitle(title);
        item.setImage(image);
        item.setContents(contents);
        item.setGrade(grade);
        item.setPublisher(publisher);
        item.setSubject(subject);

        pList.add(item);
    }
}