package com.abed.assignment.ui.history;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.abed.assignment.R;
import com.abed.assignment.databinding.ItemHistoryActivityBinding;

import java.util.List;

import javax.inject.Inject;


public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.CustomViewHolder> {

    private List<String> mItems;

    @Inject
    public HistoryAdapter() {
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemHistoryActivityBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_history_activity, parent, false);
        return new CustomViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        if (mItems == null || mItems.size() == 0) {
            return;
        }
        holder.setItem(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        if (mItems == null) {
            return 0;
        }

        return mItems.size();
    }

    public void updateList(List<String> items) {
        this.mItems = items;
        notifyDataSetChanged();
    }


    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        ItemHistoryActivityBinding mBinding;

        public CustomViewHolder(ItemHistoryActivityBinding itemHistoryActivityBinding) {
            super(itemHistoryActivityBinding.getRoot());
            this.mBinding = itemHistoryActivityBinding;

        }

        public void setItem(final String item) {
            mBinding.txtContent.setText(item);
        }
    }


}
