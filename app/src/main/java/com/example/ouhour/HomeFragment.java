package com.example.ouhour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private Product[] products;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView);
//        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

//        loadProducts();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        return view;
    }

//    private void loadProducts(){
//
//        // Initialize request
//        String url = "http://ite-rupp.ap-southeast-1.elasticbeanstalk.com/products.php";
//
//        RequestQueue requestQueue = Volley.newRequestQueue(getView().getContext());
//
//        Request request = new JsonArrayRequest(Request.Method.GET ,url, null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//
//                // Deserialize json using gson library
//                Gson gson = new Gson();
//                products = gson.fromJson(response.toString(), Product[].class);
//
//                ProductAdapter adapter = new ProductAdapter(products);
//                recyclerView.setAdapter(adapter);
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getContext(), "Load data error.", Toast.LENGTH_LONG).show();
//            }
//        });
//
//        // Add request to Queue
//        requestQueue.add(request);
//    }
}
