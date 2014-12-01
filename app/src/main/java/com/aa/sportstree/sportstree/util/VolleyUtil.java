package com.aa.sportstree.sportstree.util;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.aa.sportstree.sportstree.NewsFeedItemFragment;
import com.aa.sportstree.sportstree.constants.ApplicationConstants;
import com.aa.sportstree.sportstree.pojos.NewsItem;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Abhinav on 11/14/2014.
 */
public class VolleyUtil {

    public static RequestQueue requestQueue;

    // create our volley request
    public static void initializeVolley(Context context) {
        if(requestQueue==null) {
            requestQueue = Volley.newRequestQueue(context);
        }
    }

    /**
     * This method replaces the query issue of the space with a + sign so that the query can be
     * handled by our browsers and json.
     * @param newsItem the current news feed item and article
     * @param query the article to be accessed
     * @param mAdapter the news feed fragment
     */
    public static void getContentFromFaroo(final NewsItem newsItem, String query, final NewsFeedItemFragment mAdapter) {

        String compatibleQuery = (query.replace(" ","+")).replace(".","");
        String url = ApplicationConstants.URL.replace(ApplicationConstants.QUES,compatibleQuery);
        JsonObjectRequest jsonObjectRequest =
                new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {


                    @Override
                    public void onResponse(JSONObject response) {
                        getNewsItemFromJSONResponse(newsItem, response,mAdapter);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("");
                    }
                });
        requestQueue.add(jsonObjectRequest);

    }

    /**
     * This method grabs the news item from json, and uses an mAdapter to handle the conversions.
     * @param newsItem the current news item to display
     * @param response the json object that will be converted into a gson object
     * @param mAdapter the news feed fragment
     * @return null, because we don't return anything
     */
    public static NewsItem getNewsItemFromJSONResponse(NewsItem newsItem, JSONObject response, NewsFeedItemFragment mAdapter){
        try {
            String result =response.getString("results");
            JSONObject jsonObject =((JSONObject)(((JSONArray) response.get("results")).get(0)));
            String title = jsonObject.getString("title");
            String newsURL = jsonObject.getString("url");
            String imageURL = jsonObject.getString("iurl");
            newsItem.setContent(title);
            newsItem.setUrl(newsURL);
            ((ArrayAdapter)mAdapter.mAdapter).notifyDataSetChanged();

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


}
