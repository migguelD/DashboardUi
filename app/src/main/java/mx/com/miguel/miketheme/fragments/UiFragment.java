package mx.com.miguel.miketheme.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mx.com.miguel.miketheme.R;
import mx.com.miguel.miketheme.adapters.AdaptadorAccordions;
import mx.com.miguel.miketheme.adapters.AdaptadorCardsInfoHorizontal;
import mx.com.miguel.miketheme.adapters.AdaptadorVerticalList;
import mx.com.miguel.miketheme.modelo.ItemsCardsHorizontal;
import mx.com.miguel.miketheme.modelo.ItemsVerticalCardList;

public class UiFragment extends Fragment {
    private View root;
    Activity activity;
    //private ArrayList<String> preguntas;
    //private Map<String, ArrayList<String>> mapRespuestas;
    //private AdaptadorAccordions adaptadorAccordions;
    //private ExpandableListView expandableListView;
    private RecyclerView rv_list_ui;
    public UiFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_ui, container, false);
        activity = super.getActivity();
        //expandableListView = (ExpandableListView) root.findViewById(R.id.expabable_ui_list);
        //preguntas = new ArrayList<>();
        //mapRespuestas = new HashMap<>();
        ///cargarDatos();

        rv_list_ui = root.findViewById(R.id.rv_list_ui);
         final ArrayList<ItemsVerticalCardList> verticalList = new ArrayList<>();
        verticalList.add(new ItemsVerticalCardList(R.string.uil_exclamation_triangle,"Alerts"));
        verticalList.add(new ItemsVerticalCardList(R.string.uil_square,"Badges"));
        verticalList.add(new ItemsVerticalCardList(R.string.uil_postcard,"Cards"));
        verticalList.add(new ItemsVerticalCardList(R.string.uil_slider_h_range,"Carousel"));
        verticalList.add(new ItemsVerticalCardList(R.string.uil_toggle_off,"Buttons"));
        verticalList.add(new ItemsVerticalCardList(R.string.uil_comment,"Toast"));
        verticalList.add(new ItemsVerticalCardList(R.string.uil_icons,"Icons"));


        LinearLayoutManager layoutManager = new LinearLayoutManager(root.getContext(), LinearLayoutManager.VERTICAL, false);
        rv_list_ui.setLayoutManager(layoutManager);
        AdaptadorVerticalList adaptadorVerticalList = new AdaptadorVerticalList(verticalList);
        rv_list_ui.setAdapter(adaptadorVerticalList);
        adaptadorVerticalList.setOnItemClickListener(new AdaptadorVerticalList.OnItemClickListener() {
            @Override
            public void onClic(int position) {
               // Toast.makeText(getContext(),verticalList.get(position).getTitulo(),Toast.LENGTH_SHORT).show();
            /*    NavController navController = Navigation.findNavController(activity, R.id.frame_container);
                navController.navigate(R.id.nav_all_dir);*/

                Fragment fragment = new IconsFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_container,fragment)
                        .commit();
            }
        });

        return root;
    }

/*    private void cargarDatos(){
        preguntas.add("Alerts");
        ArrayList<String> respuesta0 = new ArrayList<>();
        respuesta0.add("");
        respuesta0.add("BICACIÓN” , una vez ingresado los datos de la dirección de clic en “CONFIRMAR”");


        preguntas.add("¿No puedo agregar una dirección por cobertura?");
        ArrayList<String> respuesta1 = new ArrayList<>();
        respuesta1.add("Por el momento solo operamos en la Ciudad de México y en el Estado de México, si está segura de que el domicilio que quiere ingresar  está dentro de los margenes correspondientes, puede comunicarse al (55) 51-48-84-27 para proceder con su registro.");

        preguntas.add("¿Que pasa si no quiero agregar una tarjeta de crédito/débito?");
        ArrayList<String> respuesta2 = new ArrayList<>();
        respuesta2.add("Puede hacer pedidos con pagos en efectivos, cuando es este modo, usted le tendrá que pagar al pipero la cantidad que le indique.");



        mapRespuestas.put(preguntas.get(0),respuesta0);
        mapRespuestas.put(preguntas.get(1),respuesta1);
        mapRespuestas.put(preguntas.get(2),respuesta2);


        adaptadorAccordions = new AdaptadorAccordions(preguntas,mapRespuestas,getContext());
        expandableListView.setAdapter(adaptadorAccordions);


    }*/
}