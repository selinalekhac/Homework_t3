package com.example.homeworkt3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.SearchView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mList;
    private String url = "https://api.thecatapi.com/v1/breeds?api_key=02aedf11-ba5a-4272-b0dc-7b7b3a9e599b";
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private ArrayList<Cats> catsList;
    private RecyclerView.Adapter adapter;

    //unsure why my recycler view isnt showing, not sure if API or how i set my Data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList = findViewById(R.id.mainrv_list);

        catsList = new ArrayList<>();
        adapter = new CatAdapter(getApplicationContext(), catsList);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mList.getContext(), linearLayoutManager.getOrientation());

        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(adapter);

        getData();

//        SearchView searchView = findViewById(R.id.searchview_id);
//        searchView.addTextChangedListener(new TextWatcher(){
//
//        });
    }
    private void getData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Cats...");
        progressDialog.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        Cats cats = new Cats();
                        cats.setBreed(jsonObject.getString("name"));
                        cats.setDescription(jsonObject.getString("description"));
                        cats.setDogfriendlinesslevel(jsonObject.getInt("dog_friendly"));
                        cats.setLifespan(jsonObject.getInt("life_span"));
                        cats.setWikipedia(jsonObject.getString("wikipedia_url"));
                        cats.setOrigin(jsonObject.getString("origin"));
                        cats.setTemperament(jsonObject.getString("temperament"));
                        cats.setWeight(jsonObject.getInt("weight"));

                        catsList.add(cats);

                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }

                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
}

