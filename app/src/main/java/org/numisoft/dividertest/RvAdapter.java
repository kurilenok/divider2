package org.numisoft.dividertest;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.chauthai.swipereveallayout.ViewBinderHelper;

import java.util.List;


/**
 * Created by kurilenok on 9/7/17.
 */

public class RvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Item> items;
    private ItemClickListener listener;
    private ViewBinderHelper viewBinderHelper;

    public RvAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
        this.listener = listener;
        viewBinderHelper = new ViewBinderHelper();
        viewBinderHelper.setOpenOnlyOne(true);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.swipe_item, parent, false);

        ViewGroup left = view.findViewById(R.id.left_part);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(left.getLayoutParams());
        params.width = Resources.getSystem().getDisplayMetrics().widthPixels
                - (int) context.getResources().getDimension(R.dimen.wh);

        left.setLayoutParams(params);

        return new SwipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof SwipeViewHolder) {
            ((SwipeViewHolder) holder).bind(items.get(position), listener);
            viewBinderHelper.bind(((SwipeViewHolder) holder).getSwipeRevealLayout(), Integer.toString(position));
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public interface ItemClickListener {
        void onItemClick(int position);

        void onTextClick(Item item);
    }

}
