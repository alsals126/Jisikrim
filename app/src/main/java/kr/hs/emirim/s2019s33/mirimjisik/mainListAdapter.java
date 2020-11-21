package kr.hs.emirim.s2019s33.mirimjisik;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class mainListAdapter extends RecyclerView.Adapter<mainListAdapter.ViewHolder> {
    private ArrayList<QuestionList> mData = null ;

    // 생성자에서 데이터 리스트 객체를 전달받음.
    mainListAdapter(ArrayList<QuestionList> list) {
        mData = list ;
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @NonNull
    @Override
    public mainListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.main_item_layout, parent, false) ;
        mainListAdapter.ViewHolder vh = new mainListAdapter.ViewHolder(view) ;

        return vh ;
    }

    @Override
    public void onBindViewHolder(mainListAdapter.ViewHolder holder, int position) {
        QuestionList item = mData.get(position) ;

        holder.icon.setImageDrawable(item.getDrawable()) ;
        holder.title.setText(item.getSol()) ;
        holder.desc.setText(item.getTitle()) ;
    }

    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return mData.size() ;
    }

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon ;
        TextView title ;
        TextView desc ;

        ViewHolder(View itemView) {
            super(itemView) ;

            // 뷰 객체에 대한 참조. (hold strong reference)
            icon = itemView.findViewById(R.id.imageView) ;
            title = itemView.findViewById(R.id.name1) ;
            desc = itemView.findViewById(R.id.name2) ;
        }
    }
}
