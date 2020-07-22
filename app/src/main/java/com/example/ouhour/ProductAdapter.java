package com.example.ouhour;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{

    private Product[] products;

    public ProductAdapter(Product[] products){
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.view_holder_product, parent, false);
        ProductViewHolder viewHolder = new ProductViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductViewHolder holder, int position) {
        Product product = products[position];
        holder.txtName.setText(product.getName());
        holder.txtPrice.setText(product.getPrice());
        holder.txtTotalView.setText(product.getTotalView());
        holder.imgImage.setImageURI(Uri.parse(product.getImageUrl()));


    }

    @Override
    public int getItemCount() {
        return products.length;
    }


    // ViewHolder
    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        public TextView txtName;
        public TextView txtPrice;
        public TextView txtTotalView;
        public ImageView imgImage;


        @SuppressLint("WrongViewCast")
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txt_name);
            txtPrice = itemView.findViewById(R.id.txt_price);
            txtTotalView = itemView.findViewById(R.id.txt_total_view);
            imgImage = itemView.findViewById(R.id.img_image_url);
        }
    }
}
