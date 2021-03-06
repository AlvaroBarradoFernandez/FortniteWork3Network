package com.utad.fortnite_work3_network;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.utad.fortnite_work3_network.Fortnite.RankFortnite;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ForniteViewHolder> {


    private List<RankFortnite> dataObject;

    public MyAdapter(List<RankFortnite> dataObject) {
        this.dataObject = dataObject;
    }

    @Override
    public ForniteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_recycleview, viewGroup, false);
        return new ForniteViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ForniteViewHolder forniteViewHolder, int i) {
        final RankFortnite item = dataObject.get(i);
        forniteViewHolder.txtForniteTitle.setText(item.getLabel());
        forniteViewHolder.txtForniteValue.setText(item.getDisplayValue());
        forniteViewHolder.txtForniteRank.setText(item.getRank());

    }

    @Override
    public int getItemCount() {
        return dataObject.size();
    }

    public class ForniteViewHolder extends RecyclerView.ViewHolder {

        private TextView txtForniteTitle, txtForniteValue, txtForniteRank;

        public ForniteViewHolder(View itemView) {
            super(itemView);
            txtForniteTitle = itemView.findViewById(R.id.title);
            txtForniteValue = itemView.findViewById(R.id.value);
            txtForniteRank = itemView.findViewById(R.id.rank);
        }
    }
}