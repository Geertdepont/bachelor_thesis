package com.hfad.rxjavaretrofitgithub.View.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hfad.rxjavaretrofitgithub.Model.Contributor;
import com.hfad.rxjavaretrofitgithub.R;

import java.util.ArrayList;
import java.util.List;

public class ContributorAdapter extends RecyclerView.Adapter<ContributorViewHolder> {

    List<Contributor> contributorList = new ArrayList<>();


    public void setContributors(List<Contributor> contributors) {
        this.contributorList = contributors;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ContributorViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.contributor_layout, viewGroup, false);
        return new ContributorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContributorViewHolder postViewHolder, int i) {
        postViewHolder.txt_name.setText(String.valueOf(contributorList.get(i).getLogin()));
        postViewHolder.txt_contributions.setText(String.valueOf(contributorList.get(i).getContributions()));
    }

    @Override
    public int getItemCount() {
        return contributorList.size();
    }
}
