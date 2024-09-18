package com.northcoders.zeldabosses.viewmodel;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.zeldabosses.R;
import com.northcoders.zeldabosses.databinding.BossRecyclerBinding;
import com.northcoders.zeldabosses.model.Boss;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BossAdapter extends RecyclerView.Adapter<BossAdapter.BossViewHolder> {

    private List<Boss> bossList;
    private static Context context;

    public static class BossViewHolder extends RecyclerView.ViewHolder{
        private BossRecyclerBinding bossRecyclerBinding;

        public BossViewHolder(BossRecyclerBinding bossRecyclerBinding){
            super(bossRecyclerBinding.getRoot());
            this.bossRecyclerBinding = bossRecyclerBinding;
        }
    }

    public BossAdapter(List<Boss> bossList, Context context){
        this.bossList = bossList;
        Log.d("BossAdapter", "BossAdapter constructor found " + bossList.size() + " bosses");
        this.context = context;
    }

    @NonNull
    @Override
    public BossViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BossRecyclerBinding bossRecyclerBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.boss_recycler, parent, false);

        return new BossViewHolder(bossRecyclerBinding);
    }

    public static int getDrawableIdFromFileName(String nameOfDrawable){
        return context.getResources().getIdentifier(
                nameOfDrawable, "drawable", context.getPackageName()
        );
    }

    @BindingAdapter("android:src")
    public static void setImageDrawable(ImageView view, String imageUrl){
        Picasso.get()
                .load(getDrawableIdFromFileName(imageUrl))
                .into(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BossViewHolder holder, int position) {
        Boss boss = bossList.get(position);

        holder.bossRecyclerBinding.setBoss(boss);
    }

    @Override
    public int getItemCount() {
        return this.bossList.size();
    }


}
