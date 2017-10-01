package com.example.myfirstapp;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ori on 9/17/2017.
 */
public class RecycleSearchProductsAdapater extends RecyclerView.Adapter<RecycleSearchProductsAdapater.ViewHolder> {
    ArrayList<Product> product_item;
    private Context mContext;
    public RecycleSearchProductsAdapater(Context context,ArrayList<Product> product_item)
    {
        this.product_item = product_item;
        this.mContext = context;
    }
    public void setResoult(ArrayList<Product> product_item)
    {
        this.product_item = product_item;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.resoult,parent,false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(product_item.get(position));
    }

    @Override
    public int getItemCount() {
        return product_item  == null ? 0 :product_item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView ProdName;
        TextView Price;
        TextView Description;
        ImageView ImageUri;

        public ViewHolder(View itemView) {
            super(itemView);
            ProdName = (TextView) itemView.findViewById(R.id.tv_resoult);
            Price = (TextView) itemView.findViewById(R.id.tv_price);
            Description = (TextView) itemView.findViewById(R.id.tv_description);
            ImageUri = (ImageView)  itemView.findViewById(R.id.iv_image);


        }
        public void bind(Product resoult_data)
        {
            ProdName.setText(resoult_data.Product_name);
            Price.setText(resoult_data.Price);
            Description.setText(resoult_data.Description);
//            Picasso.Builder builder = new Picasso.Builder(mContext);
//            builder.listener(new Picasso.Listener()
//            {
//                @Override
//                public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception)
//                {
//                    exception.printStackTrace();
//                }
//            });
//            builder.build().load(resoult_data.Image_URL).into(ImageUri);
            Picasso.with(mContext).load(resoult_data.Image_URL).resize(100, 100).centerCrop().into(ImageUri);

        }
    }
}


