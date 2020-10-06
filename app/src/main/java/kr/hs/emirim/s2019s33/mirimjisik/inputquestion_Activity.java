package kr.hs.emirim.s2019s33.mirimjisik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class inputquestion_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inputquestion_layout);

//        String[] FreshmanSubjects = {"C","정보처리와 관리","JAVA","DB"};
//        String[] SecondSubjects = {"자료구조","C++","JAVA","JSP","PHP","Python"};
//        String[] ThirdSubjects = {"데이터베이스프로그래밍","서버구축 및 운영","뉴미디어콘텐츠프로그래밍",
//                                "jsp응용","node.js","정보보안","운영체제"};
//        Spinner spinner = (Spinner) findViewById(R.id.subjects);
//        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, R.layout.inputquestion_layout, FreshmanSubjects);
//
//        // 라디오그룹으로 무엇이 선택되었는지
//        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
//        RadioButton rd = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
//        String str = rd.toString();
//
//        switch (str){
//            case "Freshman":
//                adapter = new ArrayAdapter<CharSequence>(this, R.layout.inputquestion_layout, FreshmanSubjects);
////                adapter = ArrayAdapter.createFromResource(this, R.array.FreshmanSubjects, R.layout.inputquestion_layout);
//            case "Sophomore":
//                adapter = new ArrayAdapter<CharSequence>(this, R.layout.inputquestion_layout, SecondSubjects);
////                adapter = ArrayAdapter.createFromResource(this, R.array.SecondSubjects, R.layout.inputquestion_layout);
//            case "Junior":
//                adapter = new ArrayAdapter<CharSequence>(this, R.layout.inputquestion_layout, ThirdSubjects);
////                adapter = ArrayAdapter.createFromResource(this, R.array.ThirdnSubjects, R.layout.inputquestion_layout);
//        }
//
//        spinner.setAdapter(adapter);
        Spinner spinner = (Spinner) findViewById(R.id.subjects);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.FreshmanSubjects, R.layout.inputquestion_layout
        );
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    //https://m.blog.naver.com/PostView.nhn?blogId=netrance&logNo=110132582458&proxyReferer=https:%2F%2Fwww.google.com%2F


    }
}