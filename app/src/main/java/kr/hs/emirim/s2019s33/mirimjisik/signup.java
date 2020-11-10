package kr.hs.emirim.s2019s33.mirimjisik;

import android.os.Bundle;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;
    private EditText edit_Email, edit_PW1, edit_PW2;
    private Button btn_EmailCheck, btn_Signup;
    private Boolean check=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();

        edit_Email = (EditText)findViewById(R.id.editTextEmail);
        edit_PW1 = (EditText)findViewById(R.id.editTextPassword1);
        edit_PW2 = (EditText)findViewById(R.id.editTextPassword2);
        btn_EmailCheck = (Button)findViewById(R.id.btn_EC);
        btn_Signup = (Button)findViewById(R.id.btn_Signup);

        btn_EmailCheck.setOnClickListener(this);
        btn_Signup.setOnClickListener(this);
    }

    private void createAccount(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(signup.this, "회원가입에 성공했습니다.",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), basic.class));
                        } else {
                            // If sign in fails, display a message to the user.
                            // 에러종류 구분하기
                            Toast.makeText(signup.this, "관리자에게 문의하세요",Toast.LENGTH_LONG).show();
                            /*Toast.makeText(signup.this, "에러유형\n - 이미 등록된 이메일\n -암호 최소 6자리 이상\n - 서버에러",
                                    Toast.LENGTH_SHORT).show();*/
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if(i == R.id.btn_EC){ //이메일 인증 버튼
            String email = edit_Email.getText().toString();
            String domain = email.substring(email.lastIndexOf("@")+1);

            if(domain.equals("e-mirim.hs.kr")){
                Toast.makeText(signup.this, "인증이 되었습니다.",Toast.LENGTH_LONG).show();
                check=true;
            }else{
                Toast.makeText(signup.this, "미림 계정을 사용해주세요.",Toast.LENGTH_LONG).show();
            }
        }
        if(i == R.id.btn_Signup){
            if(!edit_PW1.getText().toString().equals(edit_PW2.getText().toString())){
                Toast.makeText(signup.this, "입력한 비밀번호가 다릅니다.",Toast.LENGTH_SHORT).show();
            }else if(edit_Email.getText().toString().matches("")){
                Toast.makeText(this, "Email을 입력해 주세요.", Toast.LENGTH_SHORT).show();
            }else if(edit_PW1.getText().toString().matches("")){
                Toast.makeText(this, "비밀번호를 입력해 주세요.", Toast.LENGTH_SHORT).show();
            }else if(edit_PW1.getText().length() < 6){
                Toast.makeText(this, "비밀번호는 6자리 이상입니다.", Toast.LENGTH_SHORT).show();
            }else if(check == false){
                Toast.makeText(this, "이메일 인증을 해주세요.", Toast.LENGTH_SHORT).show();
            }else{
                createAccount(edit_Email.getText().toString().trim(), edit_PW1.getText().toString().trim());
            }
        }
    }
}
