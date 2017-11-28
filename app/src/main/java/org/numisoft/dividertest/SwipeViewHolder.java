package org.numisoft.dividertest;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kurilenok on 9/7/17.
 */

public class SwipeViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tvName)
    TextView tv;

    @BindView(R.id.swipe)
    SwipeRevealLayout swipeRevealLayout;

    @BindView(R.id.left_part)
    ViewGroup leftPart;

    @BindView(R.id.right_part)
    ViewGroup right_part;

    private RvAdapter.ItemClickListener listener;

    public SwipeViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Item item, RvAdapter.ItemClickListener listener) {
        this.listener = listener;
        tv.setText(item.getName());
    }

    @OnClick(R.id.tvName)
    void onNameClick() {
        listener.onItemClick(getAdapterPosition());
    }

    public SwipeRevealLayout getSwipeRevealLayout() {
        return swipeRevealLayout;
    }

}
