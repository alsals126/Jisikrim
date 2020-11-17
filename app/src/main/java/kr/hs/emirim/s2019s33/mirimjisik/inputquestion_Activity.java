package kr.hs.emirim.s2019s33.mirimjisik;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Text;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class inputquestion_Activity extends AppCompatActivity {

    private static final String TAG = "inputquestion_Activity";
    private FirebaseUser user;
    private ImageView imageView;
    private Spinner spinner;
//    private EditText textTitle, textContent;
    private RadioGroup rg;
    Button inputB;
//    int grade;
//    String subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inputquestion_layout);

//        // 초기화
//        textTitle = (EditText)findViewById(R.id.editText);
        rg = findViewById(R.id.radioGroup);
        spinner = findViewById(R.id.subjects);

        imageView = (ImageView) findViewById(R.id.imageView);
//        textContent = (EditText) findViewById(R.id.edit_content);
        inputB = (Button) findViewById(R.id.inputButton);

        //라디오버튼
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int result;

                ArrayAdapter<CharSequence> adapter;

                if(checkedId == R.id.Sophomore){
                    result = R.array.SecondSubjects;
                }
                else if(checkedId == R.id.Junior){
                    result = R.array.ThirdnSubjects;
                }
                else{
                    result = R.array.FreshmanSubjects;
                }
                adapter= ArrayAdapter.createFromResource(
                        getApplicationContext(), result, android.R.layout.simple_spinner_item
                );
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }
        });

        //이미지 불러오기
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);
            }
        });

        inputB.setOnClickListener(onClickListener);

        /*Board b = new Board(textTitle.getText().toString(), grade, subject, textContent.getText().toString());*/
        /*b.toMap();*/
        // db에 넣기
    /*    final FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> user = new HashMap<>();
        user.put("title", textTitle.getText().toString());
        user.put("last","sibal");
        user.put("born", 1815);*/

    /*    db.collection("users").add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "add" + documentReference.get());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "eROOD", e);
                    }
                });*/

        /*textTitle = (EditText) findViewById(R.id.textView4);*/
        /*textContent = (TextView) findViewById(R.id.textView6);*/

       /* inputB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final FirebaseFirestore db = FirebaseFirestore.getInstance();
                Map<String, Object> user = new HashMap<>();
                user.put("first", ((EditText) findViewById(R.id.editText)).getText().toString());
                user.put("last","sibal");
                user.put("born", 1815);
                db.collection("users").add(user)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d(TAG, "DocumentSnapshot written with ID: " + documentReference.getId());
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error adding document", e);
                            }
                        });
                *//*db.collection("users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot document : task.getResult()){
                                Log.d(TAG, document.getId() + "=>" + document.getData());
                            }
                        }else{
                            Log.w(TAG, "ERRO", task.getException());
                        }
                    }
                });*//*
               *//* Intent intent = new Intent(getApplicationContext(), basic.class);
                startActivity(intent);*//*
                startActivity(new Intent(getApplicationContext(), basic.class));
                *//*Intent intent=new Intent(inputquestion_Activity.this, my.class);
                startActivity(intent);*//*
            }
        });*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                try{
                    InputStream in = getContentResolver().openInputStream(data.getData());
                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();
                    imageView.setImageBitmap(img);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.inputButton:
                    ReadyUpload();
                    break;
            }
        }
    };
    private void ReadyUpload() {
        String textTitle = ((EditText) findViewById(R.id.editText)).getText().toString();
        RadioButton rd = (RadioButton)findViewById(rg.getCheckedRadioButtonId());
        String grade = rd.getText().toString();
        String subject = spinner.getSelectedItem().toString();
        String textContent = ((EditText) findViewById(R.id.edit_content)).getText().toString();


        if (textTitle.length() > 0 && textContent.length() > 0) {
            user = FirebaseAuth.getInstance().getCurrentUser();
            WriteInfo writeInfo = new WriteInfo(textTitle, grade, subject, textContent, user.getUid());
            uploader(writeInfo);
        } else {
            Toast.makeText(this, "회원정보를 입력해주세요", Toast.LENGTH_SHORT).show();
        }
    }
    private void uploader(WriteInfo writeInfo){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("posts").add(writeInfo)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot written with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }
}
class WriteInfo {
    private String title;
    private String grade;
    private String subject;
    private String contents;
    private String publisher;

    public WriteInfo(String title, String grade, String subject, String contents, String publisher){
        this.title = title;
        this.grade = grade;
        this.subject = subject;
        this.contents = contents;
        this.publisher = publisher;
    }

    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getGrade(){
        return this.grade;
    }
    public void setGrade(String grade){
        this.grade = grade;
    }
    public String getSubject(){
        return this.subject;
    }
    public void setSubject(String subject){
        this.grade = subject;
    }
    public String getContents(){
        return this.contents;
    }
    public void setContents(String contents){
        this.contents = contents;
    }
    public String getPublisher(){
        return this.publisher;
    }
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }
}