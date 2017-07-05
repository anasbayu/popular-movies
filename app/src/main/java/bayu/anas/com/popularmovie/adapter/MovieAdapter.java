package bayu.anas.com.popularmovie.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import bayu.anas.com.popularmovie.R;
import bayu.anas.com.popularmovie.model.Movie;
import bayu.anas.com.popularmovie.modules.detail.DetailActivity;

/**
 * Created by AnasBayu on 04/07/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.mViewHolder>{

    private List<Movie> data;
    private Context mConteext;
    private String imgBasePath;

    public static class mViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView txtTitle, txtShortDesc, txtCreatedBy;
        ImageView imgPoster;

        mViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            imgPoster = (ImageView) itemView.findViewById(R.id.img_poster);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
        }
    }

    // Konstruktor.
    public MovieAdapter(Context konteks){
        this.mConteext = konteks;
        imgBasePath = mConteext.getResources().getString(R.string.img_base_path);
        this.data = Collections.emptyList();
    }

    public void setData(List<Movie> data){
        this.data = Collections.emptyList();
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public MovieAdapter.mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;

        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv, parent, false);
        mViewHolder vh = new mViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(MovieAdapter.mViewHolder holder, final int position) {
        Picasso.with(mConteext).load(imgBasePath + data.get(position).getPosterPath()).into(holder.imgPoster);

        holder.txtTitle.setText(data.get(position).getTitle());

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iDetail = new Intent(mConteext, DetailActivity.class);
                iDetail.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                iDetail.putExtra("data", data.get(position));

                mConteext.startActivity(iDetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
