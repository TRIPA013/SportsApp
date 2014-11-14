package com.aa.sportstree.sportstree.util;

import android.content.Context;

import com.aa.sportstree.sportstree.constants.ApplicationConstants;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

/**
 * Created by Abhinav on 11/14/2014.
 */
public class VolleyUtil {

    public static RequestQueue requestQueue;

    public static void initializeVolley(Context context) {
        if(requestQueue==null) {
            requestQueue = Volley.newRequestQueue(context);
        }
    }

    public static void getContentFromFaroo(String query) {

        String url = ApplicationConstants.URL.replace(ApplicationConstants.QUES,query.replace(" ","+"));
        JsonObjectRequest jsonObjectRequest =
                new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {


                    @Override
                    public void onResponse(JSONObject response) {
                        System.out.println("");
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("");
                    }
                });
        requestQueue.add(jsonObjectRequest);

    }


}
