package com.buji.anurag.mycourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ViewCourse extends AppCompatActivity {
    RecyclerView recyclerView;
    List<course>My_List;
    RecyclerView.Adapter adapter;

    String apiurl="http://dummyapilist.herokuapp.com/getcourses";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_course);
        recyclerView=(RecyclerView)findViewById(R.id.r1);
        recyclerView.setHasFixedSize(true);
        int numOfcolumns=1;
        My_List=new ArrayList<>();
        recyclerView.setLayoutManager(new GridLayoutManager(this,numOfcolumns));

        callApi();
    }

    private void callApi() {
        StringRequest stringRequest=new StringRequest(Request.Method.GET, apiurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                        try {
                            JSONArray jsonArray=new JSONArray(response);
                            for (int i=0;i<jsonArray.length();i++)
                            {
                                JSONObject jsonObject=jsonArray.getJSONObject(i);
                                String title=jsonObject.getString("courseTitle");
                                String discription=jsonObject.getString("courseDescription");
                                String venue=jsonObject.getString("courseVenue");
                                String Duration=jsonObject.getString("courseDuration");
                                String date=jsonObject.getString("courseDate");
                                course model=new course(Duration,venue,date,discription,title);
                                My_List.add(model);

                            }
                            adapter=new CustomAdapter(My_List,getApplicationContext());
                            recyclerView.setAdapter(adapter);



                        } catch (JSONException e) {
                            Toast.makeText(getApplicationContext(),String.valueOf(e),Toast.LENGTH_LONG).show();
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }
}
