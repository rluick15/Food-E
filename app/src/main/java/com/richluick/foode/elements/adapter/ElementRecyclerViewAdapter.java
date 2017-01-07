package com.richluick.foode.elements.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.richluick.foode.elements.ElementView;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by rluick on 1/7/2017.
 *
 * RecyclerView adapter to handle all elementview driven pages
 */
public class ElementRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ElementView> elementViewList = Collections.EMPTY_LIST;

    @Inject
    public ElementRecyclerViewAdapter() {}

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new ElementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        elementViewList.get(position).bindElementView(holder.itemView);
    }

    @Override
    public int getItemCount() {
        return elementViewList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return elementViewList.get(position).getLayoutResId();
    }

    public void setElementViewList(List<ElementView> elementViewList) {
        this.elementViewList = elementViewList;
        notifyDataSetChanged();
    }
}
