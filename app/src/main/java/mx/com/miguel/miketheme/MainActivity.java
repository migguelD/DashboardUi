package mx.com.miguel.miketheme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import mx.com.miguel.miketheme.fragments.AnimacionesFragment;
import mx.com.miguel.miketheme.fragments.DashboardFragment;
import mx.com.miguel.miketheme.fragments.UiFragment;

public class MainActivity extends AppCompatActivity {
    private ChipNavigationBar bottomNav;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottom_nav);
        if (savedInstanceState == null){
            bottomNav.setItemSelected(R.id.dashboard,true);
            fragmentManager = getSupportFragmentManager();
            DashboardFragment homeFragment = new DashboardFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_container,homeFragment)
                    .commit();
        }
        bottomNav.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i){
                    case R.id.dashboard:
                        fragment = new DashboardFragment();
                        break;
                    case R.id.animaciones:
                        fragment = new AnimacionesFragment();
                        break;
                    case R.id.ui:
                        fragment = new UiFragment();
                        break;
                }
                if (fragment !=null){
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.frame_container,fragment)
                            .commit();
                }else {
                    System.out.println("Error al crear el fragmento");
                }
            }
        });
    }
}