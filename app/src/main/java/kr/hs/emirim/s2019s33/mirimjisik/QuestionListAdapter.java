package kr.hs.emirim.s2019s33.mirimjisik;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class QuestionListAdapter extends RecyclerView.Adapter<QuestionListAdapter.ViewHolder>{
    private ArrayList<QuestionList> mData = null ;

    // 생성자에서 데이터 리스트 객체를 전달받음.
    QuestionListAdapter(ArrayList<QuestionList> list) {
        mData = list ;
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @NonNull
    @Override
    public QuestionListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.recyclerview_item, parent, false) ;
        QuestionListAdapter.ViewHolder vh = new QuestionListAdapter.ViewHolder(view) ;

        return vh ;
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(QuestionListAdapter.ViewHolder holder, int position) {

        QuestionList item = mData.get(position) ;

        Glide.with(holder.itemView)
                .load(item.getDrawable())
                .into(holder.icon);
/*        holder.icon.setImageDrawable(item.getDrawable()) ;*/
        holder.sol.setText(item.getSol()) ;
        holder.title.setText(item.getTitle()) ;
        System.out.print("보여조");
    }

    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return mData.size() ;
    }

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon ;
        TextView sol ;
        TextView title ;

        ViewHolder(View itemView) {
            super(itemView) ;

            // 뷰 객체에 대한 참조. (hold strong reference)
            icon = itemView.findViewById(R.id.imageView) ;
            sol = itemView.findViewById(R.id.name1) ;
            title = itemView.findViewById(R.id.name2) ;
        }
    }
}
