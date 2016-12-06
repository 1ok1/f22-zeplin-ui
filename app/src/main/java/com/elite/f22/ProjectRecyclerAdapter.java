package com.elite.f22;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Lokesh on 06/12/16.
 */

public class ProjectRecyclerAdapter extends RecyclerView.Adapter<ProjectRecyclerAdapter.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.indiv_project, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position % 2 == 0) {
            holder.projectImage.setImageResource(R.mipmap.beautiful_girl);
            holder.projectIndicator.setImageResource(R.drawable.green_circle);
        } else {
            holder.projectImage.setImageResource(R.mipmap.top_bg);
            holder.projectIndicator.setImageResource(R.drawable.transparent_oval);
        }
        holder.projectTitle.setText("Project " + position);

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView projectImage, projectIndicator;
        TextView projectTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            projectImage = (ImageView) itemView.findViewById(R.id.iv_project);
            projectIndicator = (ImageView) itemView.findViewById(R.id.iv_indicator);
            projectTitle = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
