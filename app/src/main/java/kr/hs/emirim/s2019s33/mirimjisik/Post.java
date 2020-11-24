package kr.hs.emirim.s2019s33.mirimjisik;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class Post extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        ImageView image = (ImageView)findViewById(R.id.imagePost);
        TextView title = (TextView)findViewById(R.id.titlePost);
        TextView info = (TextView)findViewById(R.id.infoPost);
        TextView content = (TextView)findViewById(R.id.contentPost);
        Button chat = (Button)findViewById(R.id.chatBtn);

        Intent intent = getIntent();

        Glide.with(this)
                .load(intent.getExtras().getString("image"))
                .into(image);
        title.setText(intent.getExtras().getString("title"));
        info.setText(intent.getExtras().getString("grade") + " / " + intent.getExtras().getString("subject"));
        content.setText(intent.getExtras().getString("contents"));
    }
}