package com.sharad.assignmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
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

    private RecyclerView recyclerView;
    static ArrayList<MynewData> myMainList = new ArrayList<>();
    private InformationListAdapter listAdapter;
    Button button;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        button = findViewById(R.id.button);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fetchData();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setAdapter(null);
                listAdapter.notifyDataSetChanged();
            }
        });



    }

    void fetchData(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://restcountries.eu/rest/v2/region/asia";
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest
                (Request.Method.GET,
                        url,
                        null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {

                        int tatalIndex = response.length();


                        try {

                            for(int i = 0; i<tatalIndex; i++){
                                JSONObject jsonObject = response.getJSONObject(i);
                                String cName = jsonObject.getString("name");
                                String cRegion = jsonObject.getString("region");
                                String cSubRegion = jsonObject.getString( "subregion");
                                String cCapital = jsonObject.getString("capital");
                                String cPopulation = jsonObject.getString("population");
                                String cFlag = jsonObject.getString("flag");
                                JSONArray langArray = jsonObject.getJSONArray("languages");
                                int langArraySize = langArray.length();
                                JSONArray borderArray = jsonObject.getJSONArray("languages");
                                int borderLen = borderArray.length();
                                String langS = String.valueOf(langArraySize);
                                String borderS = String.valueOf(langS);
                                myMainList.add(new MynewData(cName,cRegion,cSubRegion,cCapital,cPopulation,borderS,langS,cFlag));

                            }

                            listAdapter = new InformationListAdapter(myMainList,MainActivity.this);
                            recyclerView.setAdapter(listAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(MainActivity.this, "Unable to Fetch Data", Toast.LENGTH_SHORT).show();
                    }
                });

        queue.add(jsonObjectRequest);
    }

}