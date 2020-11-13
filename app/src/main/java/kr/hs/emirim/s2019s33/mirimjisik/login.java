package kr.hs.emirim.s2019s33.mirimjisik;
//홈 화면
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;

public class login extends AppCompatActivity {
    Button btnNew,btnLogin;
    EditText editE, editP;
    private FirebaseAuth firebaseAuth;
    //ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        firebaseAuth=FirebaseAuth.getInstance();
        btnNew=findViewById(R.id.btn_new); //회원가입
        btnLogin=findViewById(R.id.btn_login); //로그인
        editE=findViewById(R.id.edit_email);//이메일 입력
        editP=findViewById(R.id.text_password);//비밀번호 입력

        //btnLogin.setOnClickListener(onClickListener);

        //회원가입 버튼 작동
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, signup.class);
                startActivity(intent);
            }
        });

        //로그인 버튼 작동
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=editE.getText().toString().trim(); //이메일
                String pwd=editP.getText().toString().trim(); //비밀번호

                if(editE.getText().toString().matches("")){
                    Toast.makeText(login.this, "Email을 입력해 주세요.", Toast.LENGTH_SHORT).show();
                }else if(editP.getText().toString().matches("")){
                    Toast.makeText(login.this, "비밀번호를 입력해 주세요.", Toast.LENGTH_SHORT).show();
                }else {
                    firebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(getApplicationContext(), basic.class);
                                startActivity(intent);
                            } else {
                                if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                    Toast.makeText(login.this, "비밀번호가 다릅니다.",Toast.LENGTH_LONG).show();
                                }else if(task.getException() instanceof FirebaseAuthInvalidUserException){
                                    Toast.makeText(login.this, "사용자가 없습니다. 회원가입을 해주세요.", Toast.LENGTH_LONG).show();
                                }else {
                                    Toast.makeText(login.this, "관리자에게 문의하세요.", Toast.LENGTH_LONG).show();
//                                            Toast.makeText(login.this, "Authentication failed:" + task.getException(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });
                }
            }
        });


//        Button btnNew = (Button) findViewById(R.id.btn_new);
//        Button btnLogin = (Button) findViewById(R.id.btn_login);
//
//        //회원가입 버튼->회원가입 화면
//        btnNew.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(login.this, signup.class);
//                startActivity(intent);
//            }
//        });
//
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(login.this, basic.class);
//                startActivity(intent);
//            }
//        });
    }


}
