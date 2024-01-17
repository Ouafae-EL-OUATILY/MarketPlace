package com.example.market_place_frontend.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.market_place_frontend.R;
import com.example.market_place_frontend.adapters.StoreAdapter;
import com.example.market_place_frontend.model.ProductModel;
import com.example.market_place_frontend.model.StoreModel;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    private RecyclerView productRecyclerView;
    private RecyclerView storeRecyclerView;
    private TextView numberOfProductsEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        List<ProductModel> productModels = new ArrayList<>();

        productModels.add(new ProductModel("Professional Camera", "MAD 2999", "https://images.pexels.com/photos/90946/pexels-photo-90946.jpeg?cs=srgb&dl=pexels-math-90946.jpg&fm=jpg"));
        productModels.add(new ProductModel("Makeup for pretty Girls", "MAD 199", "https://images.pexels.com/photos/2533266/pexels-photo-2533266.jpeg?auto=compress&cs=tinysrgb&w=600"));
        productModels.add(new ProductModel("Card memoire 128 GB Lexar Professional", "MAD 299", "https://images.pexels.com/photos/1738641/pexels-photo-1738641.jpeg?auto=compress&cs=tinysrgb&w=600"));

        storeRecyclerView = findViewById(R.id.recyclerViewStores);
        List<StoreModel> storeModels = new ArrayList<>();

        storeModels.add(new StoreModel("Ouafae's Store", productModels));
        storeModels.add(new StoreModel("Hamza's Store", productModels));

        StoreAdapter storeAdapter = new StoreAdapter(this, storeModels);
        storeRecyclerView.setAdapter(storeAdapter);

        numberOfProductsEt = findViewById(R.id.cart_tv);

        int numberOfProducts = storeAdapter.getTotalNumberOfProducts();
        numberOfProductsEt.setText(getResources().getString(R.string.cart_label, numberOfProducts));


        int numberColumns = 1;
        storeRecyclerView.setLayoutManager(new GridLayoutManager(this, numberColumns));

    }



    // Method to generate dummy data
    private List<StoreModel> generateDummyData() {
        List<StoreModel> storeModels = new ArrayList<>();
        List<ProductModel> productModels = new ArrayList<>();

        productModels.add(new ProductModel("iphone 13", "MAD 6500", "https://images.pexels.com/photos/90946/pexels-photo-90946.jpeg?cs=srgb&dl=pexels-math-90946.jpg&fm=jpg"));
        productModels.add(new ProductModel("iphone 11", "MAD 3800", "https://images.pexels.com/photos/90946/pexels-photo-90946.jpeg?cs=srgb&dl=pexels-math-90946.jpg&fm=jpg"));

        storeModels.add(new StoreModel("Fashion Fusion Clothes 1", productModels));
        storeModels.add(new StoreModel("Fashion Fusion Clothes 2", productModels));

        return storeModels;
    }
}