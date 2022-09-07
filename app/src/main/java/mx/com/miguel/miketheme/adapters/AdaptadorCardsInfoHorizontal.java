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
import mx.com.miguel.miketheme.modelo.ItemsCardsHorizontal;

public class AdaptadorCardsInfoHorizontal extends RecyclerView.Adapter<AdaptadorCardsInfoHorizontal.ViewHolderCardsInfoHorizontal>{
    private ArrayList<ItemsCardsHorizontal> items = new ArrayList<>();
    private Context context;

    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onClic(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public AdaptadorCardsInfoHorizontal(ArrayList<ItemsCardsHorizontal> items ) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolderCardsInfoHorizontal onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card_info_horizontal,parent,false);
        context = parent.getContext();
        return new ViewHolderCardsInfoHorizontal(view, mListener);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolderCardsInfoHorizontal holder, int position) {
        holder.tv_titulo_item.setText(items.get(position).getTitulo());
        holder.tv_number_body.setText(items.get(position).getNumeroBody());
        holder.tv_icono_body.setText(context.getString(Integer.parseInt(items.get(position).getIconoBody())) );
        holder.tv_icono_footer.setText(context.getString(Integer.parseInt(items.get(position).getIconoFooter())));
        if (items.get(position).getTipo()==1){
            holder.tv_icono_footer.setTextColor(context.getColor(R.color.green));
            holder.tv_desc_icono_footer.setTextColor(context.getColor(R.color.green));
        }else {
            holder.tv_icono_footer.setTextColor(context.getColor(R.color.red));
            holder.tv_desc_icono_footer.setTextColor(context.getColor(R.color.red));
        }
        holder.tv_desc_icono_footer.setText(items.get(position).getDescIconFooter());
        holder.tv_legend_footer.setText(items.get(position).getLegendFooter());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolderCardsInfoHorizontal extends RecyclerView.ViewHolder {
        private TextView tv_titulo_item,tv_number_body,tv_icono_body,tv_icono_footer,tv_desc_icono_footer,tv_legend_footer;
        private CardView cv_item_horizontal;

        public ViewHolderCardsInfoHorizontal(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            tv_titulo_item =  itemView.findViewById(R.id.tv_titulo_item);
            tv_number_body = itemView.findViewById(R.id.tv_number_body);
            tv_icono_body = itemView.findViewById(R.id.tv_icono_body);
            tv_icono_footer = itemView.findViewById(R.id.tv_icono_footer);
            tv_desc_icono_footer = itemView.findViewById(R.id.tv_desc_icono_footer);
            tv_legend_footer = itemView.findViewById(R.id.tv_legend_footer);

            cv_item_horizontal = itemView.findViewById(R.id.cv_item_horizontal);
            cv_item_horizontal.setOnClickListener(new View.OnClickListener() {
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

    public String icono(String icono){
        String valHexStr = icono.replace("&#x", "").replace(";", "");
        long valLong = Long.parseLong(valHexStr,16);
        return String.valueOf((char) valLong+"");

    }
}
