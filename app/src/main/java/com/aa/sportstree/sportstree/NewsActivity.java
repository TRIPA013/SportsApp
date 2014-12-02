package com.aa.sportstree.sportstree;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Toast;

/**
 * An activity that handles news item fetching and display.
 */
public class NewsActivity extends Activity implements NewsFeedItemFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        setTitle("News Feed");
        //check if internet network is available or not.
        if(isNetworkAvailable()) {
            if (savedInstanceState == null) {
                getFragmentManager().beginTransaction()
                        .add(R.id.container, new NewsFeedItemFragment())
                        .commit();
            }
        }else{
            //Displaying appropriate message in case of no internet connectivity.
            Toast.makeText(getApplicationContext(), "No internet connectivity. Refresh. ",
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * A method that checks if there is internet connection available.
     * @return true if internet connection is available, else false.
     */
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /**
     * Preventing the default back action on the news activity page.
     */
    @Override
    public void onBackPressed() {
        // do nothing, so the onBackPressed button does not work.
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.news, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            //Start preference activity
            Intent intent = new Intent(this, PreferenceActivity.class);
            startActivity(intent);
            return true;
        }else if(id== R.id.refresh){
            //Restart the current activity to allow for refreshed news to be displayed.
            Intent intent = new Intent(this, NewsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(String id) {

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_news, container, false);
            return rootView;
        }
    }
}
