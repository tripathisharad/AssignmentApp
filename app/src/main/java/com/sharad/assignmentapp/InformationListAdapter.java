package com.sharad.assignmentapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

public class InformationListAdapter extends RecyclerView.Adapter<InformationListAdapter.MyViewHolder> {

    private ArrayList<MynewData> myCurrentList;
    private Context context;


    public InformationListAdapter(ArrayList<MynewData> myCurrentList, Context context) {
        this.myCurrentList = myCurrentList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_view,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
           holder.cName.setText(myCurrentList.get(position).getCountryName());
           holder.cRegion.setText(myCurrentList.get(position).getCountryRegion());
           holder.cSubRegion.setText(myCurrentList.get(position).getCountrySubRegion());
           holder.cCapital.setText(myCurrentList.get(position).getCountryCapital());
           holder.cPopulation.setText(myCurrentList.get(position).getCountryPopulation());
           holder.cLanguage.setText(myCurrentList.get(position).getCountryLanguage());
           holder.cBorder.setText(myCurrentList.get(position).getCountryBorders());


        String url = myCurrentList.get(position).getCountryFlag();
        Uri uri = Uri.parse(url);
        if(url != null){
            Glide.with(context).asDrawable().load(uri).error(R.drawable.ic_baseline_error_24).into(holder.cFlag);
        }


    }

    @Override
    public int getItemCount() {
        return myCurrentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView cName;
        ImageView cFlag;
        TextView cRegion;
        TextView cSubRegion;
        TextView cCapital;
        TextView cPopulation;
        TextView cLanguage;
        TextView cBorder;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
             cName = itemView.findViewById(R.id.textView2);
             cFlag = itemView.findViewById(R.id.imageView);
             cRegion = itemView.findViewById(R.id.textView4);
             cSubRegion = itemView.findViewById(R.id.textView6);
             cCapital = itemView.findViewById(R.id.textView8);
             cPopulation= itemView.findViewById(R.id.textView10);
             cLanguage = itemView.findViewById(R.id.textView12);
             cBorder = itemView.findViewById(R.id.textView14);
        }

    }

}
