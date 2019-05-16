package com.hfad.rxjavaretrofitgithub.View.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.hfad.rxjavaretrofitgithub.R;

public class ContributorViewHolder extends RecyclerView.ViewHolder {

    TextView txt_name;
    TextView txt_contributions;


    public ContributorViewHolder(@NonNull View itemView) {
        super(itemView);

        txt_name = (TextView)itemView.findViewById(R.id.txt_name);
        txt_contributions = (TextView)itemView.findViewById(R.id.txt_contributions);
    }
}
