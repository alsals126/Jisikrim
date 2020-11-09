package kr.hs.emirim.s2019s33.mirimjisik;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import java.io.InputStream;

public class inputquestion_Activity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inputquestion_layout);

        Button inputB = (Button) findViewById(R.id.inputButton);
        inputB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(inputquestion_Activity.this, my.class);
                startActivity(intent);
            }
        });

        //라디오버튼튼
       RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int result;
                Spinner spinner = (Spinner) findViewById(R.id.subjects);
                ArrayAdapter<CharSequence> adapter;

                if(checkedId == R.id.Sophomore)
                    result = R.array.SecondSubjects;
                else if(checkedId == R.id.Junior)
                    result = R.array.ThirdnSubjects;
                else
                    result = R.array.FreshmanSubjects;

                adapter= ArrayAdapter.createFromResource(
                        getApplicationContext(), result, android.R.layout.simple_spinner_item
                );
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }
        });

        //이미지 불러오기
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);
            }
        });
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

}