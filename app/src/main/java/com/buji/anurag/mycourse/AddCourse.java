package com.buji.anurag.mycourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class AddCourse extends AppCompatActivity {
    EditText et1,et2,et3,et4,et5,et6;
    Button bt3;
    String dura,venu,dat,dis,tit;
    course c1;
    String Webapi="http://dummyapilist.herokuapp.com/addcourse";
    ProgressBar p;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
        et1=(EditText)findViewById(R.id.e1);
        et2=(EditText)findViewById(R.id.e2);
        et3=(EditText)findViewById(R.id.e3);
        et4=(EditText)findViewById(R.id.e4);
        et5=(EditText)findViewById(R.id.e5);
        et6=(EditText)findViewById(R.id.e6);
        bt3=(Button)findViewById(R.id.b3);
        p=(ProgressBar)findViewById(R.id.pb);

        c1=new course();
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.setVisibility(View.VISIBLE);
                dura=et2.getText().toString();
                venu=et3.getText().toString();
                dat=et4.getText().toString();
                dis=et5.getText().toString();
                tit=et6.getText().toString();

                c1.setDuration(dura);
                c1.setVenue(venu);
                c1.setDate(dat);
                c1.setDiscription(dis);
                c1.setTitle(tit);
                String du=c1.getDuration();
                String ve=c1.getVenue();
                String da=c1.getDate();
                String di=c1.getDiscription();
                String ti=c1.getTitle();

                callApi();
            }
        });
    }

    private void callApi() {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, Webapi,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                        p.setVisibility(View.INVISIBLE);
                        et2.setText("");
                        et3.setText("");
                        et4.setText("");
                        et5.setText("");
                        et6.setText("");


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),String.valueOf(error),Toast.LENGTH_LONG).show();
                        p.setVisibility(View.INVISIBLE);


                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> param=new HashMap<>();
                param.put("courseDuration",dura);
                param.put("courseVenue",venu);
                param.put("courseDate",dat);
                param.put("courseDiscription",dis);
                param.put("courseTitle",tit);

                return param;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }
}
