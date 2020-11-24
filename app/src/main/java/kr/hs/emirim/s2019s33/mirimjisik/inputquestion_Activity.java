package kr.hs.emirim.s2019s33.mirimjisik;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.InputStream;

public class inputquestion_Activity extends AppCompatActivity {

    private static final String TAG = "inputquestion_Activity";
    private FirebaseUser user;
    private ImageView imageView;
    private Spinner spinner;
    private RadioGroup rg;
    Button inputB;
 /*   private FirebaseDatabase database;
    private DatabaseReference databaseReference;*/
    private Uri filePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inputquestion_layout);

        rg = findViewById(R.id.radioGroup);
        spinner = findViewById(R.id.subjects);
        imageView = (ImageView) findViewById(R.id.imageView);
        inputB = (Button) findViewById(R.id.inputButton);

      /*  database = FirebaseDatabase.getInstance(); //파이어베이스 데이터베이스 연동
        databaseReference = database.getReference("User");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // 파이어베이스 데이터베이스의 데이터를 받아오는 곳

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/

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
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                filePath = data.getData();
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
        String grade = null;
        String subject = null;
        String textContent = ((EditText) findViewById(R.id.edit_content)).getText().toString();

        if(rd != null) {
            grade = rd.getText().toString();
            subject = spinner.getSelectedItem().toString();
            if (textTitle.length() > 0 && textContent.length() > 0 && grade != null && subject != null && filePath != null) {
                user = FirebaseAuth.getInstance().getCurrentUser();
                WriteInfo writeInfo = new WriteInfo(textTitle, grade, subject, textContent, user.getUid());
                uploaderImage(writeInfo);
            } else {
                Toast.makeText(this, "모든 항목을 입력해주세요", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "모든 항목을 입력해주세요", Toast.LENGTH_SHORT).show();
        }
    }
    private void uploaderImage(final WriteInfo writeInfo){
        final FirebaseStorage storage = FirebaseStorage.getInstance();
        final StorageReference storageRef = storage.getReferenceFromUrl("gs://jisiklim.appspot.com/PostImage").child(filePath.getLastPathSegment());
        storageRef.putFile(filePath)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                writeInfo.setImagepath(uri.toString());
                                uploaderText(writeInfo);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception exception) {
                                //이미지 로드 실패시
                                Toast.makeText(getApplicationContext(), "실패", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "업로드 실패", Toast.LENGTH_SHORT).show();
                    }
                });

    }
    private void uploaderText(WriteInfo writeInfo){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("posts").add(writeInfo)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(), "업로드 완료", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), basic.class);
                        startActivity(intent);
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
    private String title, grade, subject, contents, publisher;
    private String getImagepath;

    public WriteInfo(String title, String grade, String subject, String contents, String publisher){
        this.title = title;
        this.grade = grade;
        this.subject = subject;
        this.contents = contents;
        this.publisher = publisher;
    }

    public String getTitle(){ return this.title; }
    public void setTitle(String title){ this.title = title; }

    public String getGrade(){ return this.grade; }
    public void setGrade(String grade){ this.grade = grade; }

    public String getSubject(){ return this.subject; }
    public void setSubject(String subject){ this.subject = subject; }

    public String getContents(){ return this.contents; }
    public void setContents(String contents){ this.contents = contents; }

    public String getPublisher(){ return this.publisher; }
    public void setPublisher(String publisher){ this.publisher = publisher; }

    public String getImagepath(){ return this.getImagepath; }
    public void setImagepath(String getImagepath){ this.getImagepath = getImagepath; }
}