package com.elite.f22;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView stats, favourites, search, profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        loadProfile();

        stats = (ImageView) findViewById(R.id.iv_stats);
        favourites = (ImageView) findViewById(R.id.iv_fav);
        search = (ImageView) findViewById(R.id.iv_search);
        profile = (ImageView) findViewById(R.id.iv_profile);

        stats.setOnClickListener(this);
        favourites.setOnClickListener(this);
        search.setOnClickListener(this);
        profile.setOnClickListener(this);
    }

    private void loadProfile() {
        setFragmentLayout(new ProfileFragment());
    }

    private void setFragmentLayout(Fragment fragmentName) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction();
        if (fragmentName.isAdded()) {
            fragmentTransaction.remove(fragmentName);
        }
        fragmentTransaction.replace(R.id.fragment_container, fragmentName);
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.iv_profile){
            Toast.makeText(MainActivity.this,"Profile Reloaded",Toast.LENGTH_SHORT).show();
            loadProfile();
            setNavUI(view);
        }else if(id == R.id.iv_stats){
            Toast.makeText(MainActivity.this,"Stats Clicked",Toast.LENGTH_SHORT).show();
            setNavUI(view);
        }else if(id == R.id.iv_search){
            Toast.makeText(MainActivity.this,"Search Clicked",Toast.LENGTH_SHORT).show();
            setNavUI(view);
        }else if(id == R.id.iv_fav){
            Toast.makeText(MainActivity.this,"favourites Clicked",Toast.LENGTH_SHORT).show();
            setNavUI(view);
        }
    }

    private void setNavUI(View view){
        stats.setBackgroundColor(getResources().getColor(R.color.bottom_nav_un_selected));
        profile.setBackgroundColor(getResources().getColor(R.color.bottom_nav_un_selected));
        search.setBackgroundColor(getResources().getColor(R.color.bottom_nav_un_selected));
        favourites.setBackgroundColor(getResources().getColor(R.color.bottom_nav_un_selected));

        stats.setColorFilter(getResources().getColor(R.color.bottom_nav_btn_unselected));
        profile.setColorFilter(getResources().getColor(R.color.bottom_nav_btn_unselected));
        search.setColorFilter(getResources().getColor(R.color.bottom_nav_btn_unselected));
        favourites.setColorFilter(getResources().getColor(R.color.bottom_nav_btn_unselected));

        ((ImageView) view).setBackgroundColor(getResources().getColor(R.color.bottom_nav_selected));
        ((ImageView) view).setColorFilter(getResources().getColor(R.color.white));

    }
}
