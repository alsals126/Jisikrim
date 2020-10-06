package kr.hs.emirim.s2019s33.mirimjisik;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);

        Button btnMain=(Button)findViewById(R.id.btn_main);
        Button btnChatting=(Button)findViewById(R.id.btn_chatting);
        Button btnMy=(Button)findViewById(R.id.btn_my);

        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(category.this, mainviewActivity.class);
                startActivity(intent);
            }
        });
        btnChatting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(category.this,chatting.class);
                startActivity(intent);
            }
        });
        btnMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(category.this, questionActivity.class);
                startActivity(intent);
            }
        });
    }
}
