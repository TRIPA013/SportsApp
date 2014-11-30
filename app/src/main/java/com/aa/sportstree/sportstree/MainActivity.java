package com.aa.sportstree.sportstree;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.aa.sportstree.sportstree.data.DataInitializer;
import com.aa.sportstree.sportstree.util.VolleyUtil;


public class MainActivity extends Activity implements SelectionFragment.OnFragmentInteractionListener {

    private final String TAG = ((Object) this).getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "+++ In onCreate() +++");
        VolleyUtil.initializeVolley(this);
        try {
            DataInitializer.initializeAllSports(getBaseContext());
        }
        catch(Exception e){

        }
        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);
        //initFragment(new SelectionFragment());
    }

    protected void initFragment(Fragment fragment) {
        fragment.setArguments(new Bundle());
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(android.R.id.content, fragment);
        fragmentTransaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(String id) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "++ In onResume() ++");
        // Rest of onResume()...
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "++ In onPause() ++");
        // Rest of onResume()...
    }

    @Override
    public void finish() {
        super.finish();
        Log.e(TAG, "++ In onFinish() ++");
        // Rest of onResume()...
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Log.e(TAG, "++ In onRestart() ++");
        // Rest of onResume()...
    }


}
