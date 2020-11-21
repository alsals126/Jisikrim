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

class charadapter extends RecyclerView.Adapter<charadapter.ViewHolder>{
    private ArrayList<chatitem> mData = null ;

    // 생성자에서 데이터 리스트 객체를 전달받음.
    charadapter(ArrayList<chatitem> list) {
        mData = list ;
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @NonNull
    @Override
    public charadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.row_chat, parent, false) ;
        charadapter.ViewHolder vh = new charadapter.ViewHolder(view) ;

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        chatitem item = mData.get(position) ;

        holder.title.setText(item.getName()) ;
        holder.desc.setText(item.getText()) ;

        System.out.println("안녕" + item.getName());
    }

    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return mData.size() ;
    }

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title ;
        TextView desc ;

        ViewHolder(View itemView) {
            super(itemView) ;

            // 뷰 객체에 대한 참조. (hold strong reference)
            title = itemView.findViewById(R.id.TextView_nickname) ;
            desc = itemView.findViewById(R.id.TextView_msg) ;
        }
    }
}
