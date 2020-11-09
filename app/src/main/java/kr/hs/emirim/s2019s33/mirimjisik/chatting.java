package kr.hs.emirim.s2019s33.mirimjisik;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class chatting extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.chatting, container, false);
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
