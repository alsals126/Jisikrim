package kr.hs.emirim.s2019s33.mirimjisik;

import android.os.Bundle;
import android.content.Intent;
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
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;
    private EditText edit_Email, edit_PW;
    private Button btn_Signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();

        edit_Email = (EditText)findViewById(R.id.editTextEmail);
        edit_PW = (EditText)findViewById(R.id.editTextPassword1);
        btn_Signup = (Button)findViewById(R.id.buttonSignup);

        btn_Signup.setOnClickListener(this);
    }

    private void createAccount(String email, String password){
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Email을 입력해 주세요.", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Password를 입력해 주세요.", Toast.LENGTH_SHORT).show();
        }
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
                            Toast.makeText(signup.this, "암호 최소 6자리 이상입니다.",Toast.LENGTH_LONG).show();
                            /*Toast.makeText(signup.this, "에러유형\n - 이미 등록된 이메일\n -암호 최소 6자리 이상\n - 서버에러",
                                    Toast.LENGTH_SHORT).show();*/
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if(i == R.id.buttonSignup){
            createAccount(edit_Email.getText().toString().trim(), edit_PW.getText().toString().trim());
        }
    }
}
