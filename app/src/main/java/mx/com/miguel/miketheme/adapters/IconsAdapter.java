package mx.com.miguel.miketheme.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import mx.com.miguel.miketheme.R;

public class IconsAdapter extends RecyclerView.Adapter<IconsAdapter.ViewHolder> {
    private List<Integer> labels;
    private Context context;
    public IconsAdapter(List<Integer> labels ) {
        this.labels=labels;
      /*  labels = new ArrayList<>(count);
        for (int i = 0; i < count; ++i) {
          //  labels.add(String.valueOf(i));
        }*/
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_icon_card, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
       // final String label = labels.get(position);

        holder.textView.setText(context.getString(labels.get(position)));

        //handling item click event
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(holder.textView.getContext(), label, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return labels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_icon_card);
        }
    }
}