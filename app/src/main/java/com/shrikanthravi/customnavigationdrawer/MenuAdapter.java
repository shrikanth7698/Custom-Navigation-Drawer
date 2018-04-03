package com.shrikanthravi.customnavigationdrawer;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {
    private List<MenuItem> menuList;
    Context context;
    private static int lastCheckedPos = 0;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTV;
        public CardView backgroundCV;
        public ImageView backgroundIV;
        public LockHorizontalScrollView lockHorizontalScrollView;

        public MyViewHolder(View view) {
            super(view);
            titleTV = (TextView) view.findViewById(R.id.titleTV);
            backgroundIV = (ImageView) view.findViewById(R.id.backgroundIV);
            backgroundCV = (CardView) view.findViewById(R.id.backgroundCV);
            //lockHorizontalScrollView = (LockHorizontalScrollView) view.findViewById(R.id.LHSV);

        }
    }

    public MenuAdapter(List<MenuItem> verticalList, Context context) {
        this.menuList = verticalList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_row_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        MenuItem menuItem = menuList.get(position);


        holder.titleTV.setTag(Integer.valueOf(position));
        holder.titleTV.setText(menuItem.getTitle());
        holder.backgroundIV.setImageDrawable(context.getDrawable(menuItem.getImageId()));



    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }
}

