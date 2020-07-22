package com.example.ouhour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Product[] products = loadProducts();

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        ProductAdapter adapter = new ProductAdapter(products);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void loadMails(){

        // Show progress bar and hide recycler view
//        showLoading(true);

        // Initialize request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        // Initialize request
        String url = "http://10.0.2.2/rupp/index.php";
        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                // Hide progress bar and show recycler view
                showLoading(false);

                // Dataset
                /*
                // Deserialize json without using library
                Mail[] mails = new Mail[response.length()];
                for(int i=0; i<response.length(); i++){
                    try {
                        JSONObject mailJson = response.getJSONObject(i);
                        String sender = mailJson.getString("sender");
                        String subject = mailJson.getString("subject");
                        String body = mailJson.getString("body");
                        String imageUrl = mailJson.getString("imageUrl");
                        Mail mail = new Mail();
                        mail.setSender(sender);
                        mail.setSubject(subject);
                        mail.setBody(body);
                        mail.setImageUrl(imageUrl);
                        mails[i] = mail;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }*/

                // Deserialize json using gson library
                Gson gson = new Gson();
                Mail[] mails = gson.fromJson(response.toString(), Mail[].class);

                MailsAdapter adapter = new MailsAdapter(mails);
                recyclerView.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Hide progress bar and show recycler view
                showLoading(false);

                Toast.makeText(MailsActivity.this, "Load data error.", Toast.LENGTH_LONG).show();
                Log.d("iteapp", "Load data error: " + error.getMessage());
            }
        });

        // Add request to Queue
        requestQueue.add(request);

    }

//    private void showLoading(boolean state){
//        if(state) {
//            progressBar.setVisibility(View.VISIBLE);
//            recyclerView.setVisibility(View.INVISIBLE);
//        } else {
//            progressBar.setVisibility(View.INVISIBLE);
//            recyclerView.setVisibility(View.VISIBLE);
//        }
//    }



}
