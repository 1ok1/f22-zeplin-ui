package com.elite.f22;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Lokesh on 06/12/16.
 */

public class ProfileFragment extends Fragment implements View.OnClickListener {
    ImageView project, bookmark, visible, currentStats;
    EditText profileDesc;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_profile, container, false);

        project = (ImageView) view.findViewById(R.id.iv_project);
        visible = (ImageView) view.findViewById(R.id.iv_visible);
        bookmark = (ImageView) view.findViewById(R.id.iv_bookmark);
        currentStats = (ImageView) view.findViewById(R.id.iv_current_stats);
        profileDesc = (EditText) view.findViewById(R.id.et_profile_desc);

        profileDesc.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (profileDesc.getRight() - profileDesc.getCompoundDrawables()[2].getBounds().width())) {
                        // your action here
                        profileDesc.setFocusable(true);
                        profileDesc.setFocusableInTouchMode(true);
                        profileDesc.requestFocus();
                        return true;
                    }
                }
                return false;
            }
        });
        project.setOnClickListener(this);
        visible.setOnClickListener(this);
        bookmark.setOnClickListener(this);
        currentStats.setOnClickListener(this);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_project);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new ProjectRecyclerAdapter());
        return view;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        setTabUI(view);
        if (id == R.id.iv_project) {

        } else if (id == R.id.iv_current_stats) {

        } else if (id == R.id.iv_bookmark) {

        } else if (id == R.id.iv_visible) {

        }
    }

    private void setTabUI(View view) {
        project.setBackgroundDrawable(getResources().getDrawable(R.drawable.tab_unselected));
        visible.setBackgroundDrawable(getResources().getDrawable(R.drawable.tab_unselected));
        bookmark.setBackgroundDrawable(getResources().getDrawable(R.drawable.tab_unselected));
        currentStats.setBackgroundDrawable(getResources().getDrawable(R.drawable.tab_unselected));

        project.setColorFilter(getResources().getColor(R.color.bottom_nav_btn_unselected));
        visible.setColorFilter(getResources().getColor(R.color.bottom_nav_btn_unselected));
        bookmark.setColorFilter(getResources().getColor(R.color.bottom_nav_btn_unselected));
        currentStats.setColorFilter(getResources().getColor(R.color.bottom_nav_btn_unselected));

        ((ImageView) view).setBackgroundColor(getResources().getColor(R.color.tab_selected));
        ((ImageView) view).setColorFilter(getResources().getColor(R.color.white));
        Toast.makeText(getActivity(), view.getTag().toString(), Toast.LENGTH_SHORT).show();
    }
}
