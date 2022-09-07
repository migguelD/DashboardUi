package mx.com.miguel.miketheme.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import mx.com.miguel.miketheme.R;
import mx.com.miguel.miketheme.adapters.AdaptadorCardsInfoHorizontal;
import mx.com.miguel.miketheme.modelo.ItemsCardsHorizontal;


public class DashboardFragment extends Fragment {

  private View root;
  private RecyclerView recyclerViewMenu;

    public DashboardFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        recyclerViewMenu = (RecyclerView) root.findViewById(R.id.recyclerHorizontalDashboard);

        ArrayList<ItemsCardsHorizontal> itemsCardsHorizontal = new ArrayList<>();
        itemsCardsHorizontal.add(new ItemsCardsHorizontal("Total Order","37.78",R.string.uil_shopping_bag+"",R.string.dripicons_arrow_up+"","21.2","Since last month",1));
        itemsCardsHorizontal.add(new ItemsCardsHorizontal("Marker Share","10",R.string.uil_rocket+"",R.string.dripicons_arrow_down+"","21.2","Since last week",2));
        itemsCardsHorizontal.add(new ItemsCardsHorizontal("Active Users","6798",R.string.uil_users_alt+"",R.string.dripicons_arrow_up+"","232","Since last month",1));

        LinearLayoutManager layoutManager = new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewMenu.setLayoutManager(layoutManager);
        AdaptadorCardsInfoHorizontal adaptadorCardsMenu = new AdaptadorCardsInfoHorizontal(itemsCardsHorizontal);
        recyclerViewMenu.setAdapter(adaptadorCardsMenu);
        return root;
    }
}