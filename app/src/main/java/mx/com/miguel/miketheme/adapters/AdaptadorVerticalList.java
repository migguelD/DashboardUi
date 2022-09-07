package mx.com.miguel.miketheme.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import mx.com.miguel.miketheme.R;
import mx.com.miguel.miketheme.modelo.ItemsVerticalCardList;

public class AdaptadorVerticalList extends RecyclerView.Adapter<AdaptadorVerticalList.ViewHolderVerticalList>{
    private ArrayList<ItemsVerticalCardList> items = new ArrayList<>();
    private Context context;

    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onClic(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public AdaptadorVerticalList(ArrayList<ItemsVerticalCardList> items ) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolderVerticalList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_vertical_list,parent,false);
        context = parent.getContext();
        return new ViewHolderVerticalList(view, mListener);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolderVerticalList holder, int position) {
        System.out.println("++++++++ "+ items.get(position).getTitulo());
        holder.tv_icono_item_vertical_list.setText(context.getString(items.get(position).getIdIcono()));
        holder.tv_titulo_item_vertical_list.setText(items.get(position).getTitulo());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolderVerticalList extends RecyclerView.ViewHolder {
        private TextView tv_icono_item_vertical_list,tv_titulo_item_vertical_list;
        private CardView cv_item_vertical_list;

        public ViewHolderVerticalList(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            tv_icono_item_vertical_list =  itemView.findViewById(R.id.tv_icono_item_vertical_list);
            tv_titulo_item_vertical_list = itemView.findViewById(R.id.tv_titulo_item_vertical_list);

            cv_item_vertical_list = itemView.findViewById(R.id.cv_item_vertical_list);
            cv_item_vertical_list.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position =  getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onClic(position);
                        }
                    }
                }
            });
        }
    }
}
