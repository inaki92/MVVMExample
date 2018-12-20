package com.example.inaki.androidviewmodel.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.inaki.androidviewmodel.Data.Hero;
import com.example.inaki.androidviewmodel.R;

import java.util.List;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.HeroViewHolder> {

    Context mCtx;
    List<Hero> heroList;

    public HeroesAdapter(Context mCtx,List<Hero> heroList){
        this.mCtx = mCtx;
        this.heroList = heroList;
    }

    @NonNull
    @Override
    public HeroesAdapter.HeroViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recycler_view_model,viewGroup,false);
        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroesAdapter.HeroViewHolder holder, int i) {
        Hero hero = heroList.get(i);

        Glide.with(mCtx).load(hero.getImageurl()).into(holder.heroImage);
        holder.heroName.setText(hero.getName());
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    class HeroViewHolder extends RecyclerView.ViewHolder {
        ImageView heroImage;
        TextView heroName;

        public HeroViewHolder(@NonNull View itemView) {
            super(itemView);

            heroImage = itemView.findViewById(R.id.imageView);
            heroName = itemView.findViewById(R.id.tv_name);
        }
    }
}
