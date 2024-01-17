package com.example.market_place_frontend.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.market_place_frontend.R;
import com.example.market_place_frontend.model.ProductModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private final Context context;
    private final List<ProductModel> productModels;

    public ProductAdapter(Context context, List<ProductModel> productModels) {
        this.context = context;
        this.productModels = productModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductModel productModel = productModels.get(position);

        // Bind your article data to the card item layout
        Picasso.get().load(productModel.getImageUrl()).into(holder.articleImage);
        holder.articlePrice.setText(String.valueOf(productModel.getProductPrice()));
        holder.articleName.setText(String.valueOf(productModel.getProductName()));

        holder.productCheckBox.setOnCheckedChangeListener(null); // Clear previous listeners
        holder.productCheckBox.setChecked(productModel.isChecked());

        // Handle product checkbox changes
        holder.productCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            productModel.setChecked(isChecked);
            // Add any other logic you need when a product checkbox is changed
        });
    }


    @Override
    public int getItemCount() {
        return productModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox productCheckBox;
        ImageView articleImage;
        TextView articlePrice;
        TextView articleName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            articleImage = itemView.findViewById(R.id.productImage);
            articlePrice = itemView.findViewById(R.id.productPrice);
            articleName = itemView.findViewById(R.id.productName);
            productCheckBox = itemView.findViewById(R.id.productCheckbox);
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    public void checkAllProducts(boolean isChecked) {
        for (ProductModel product : productModels) {
            product.setChecked(isChecked);
        }
        notifyDataSetChanged();
    }


}