package com.example.market_place_frontend.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.market_place_frontend.R;
import com.example.market_place_frontend.model.StoreModel;

import java.util.List;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {

    private final Context context;
    private final List<StoreModel> storeModels;

    public StoreAdapter(Context context, List<StoreModel>storeModels) {
        this.context = context;
        this.storeModels = storeModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_store, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StoreModel storeModel = storeModels.get(position);

        holder.storeName.setText(String.valueOf(storeModel.getStoreName()));
//        holder.storeCheckBox.setOnCheckedChangeListener(null); // Clear previous listeners
//        holder.storeCheckBox.setChecked(storeModel.isChecked());

        ProductAdapter productAdapter = new ProductAdapter(context, storeModel.getProducts());
        holder.recyclerViewProducts.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerViewProducts.setAdapter(productAdapter);

        // Handle store checkbox changes
//        holder.storeCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
//            storeModel.setChecked(isChecked);
//            productAdapter.checkAllProducts(isChecked);
//        });

    }


    @Override
    public int getItemCount() {
        return storeModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView storeName;
        RecyclerView recyclerViewProducts;
//        CheckBox storeCheckBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            storeName = itemView.findViewById(R.id.storeName);
            recyclerViewProducts = itemView.findViewById(R.id.recyclerViewProducts);
//            storeCheckBox = itemView.findViewById(R.id.storeCheckBox);
        }
    }
    public int getTotalNumberOfProducts() {
        int totalProducts = 0;
        for (StoreModel storeModel : storeModels) {
            totalProducts += storeModel.getProducts().size();
        }
        return totalProducts;
    }

}