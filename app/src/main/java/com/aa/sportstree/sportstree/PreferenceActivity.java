package com.aa.sportstree.sportstree;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

import com.aa.sportstree.sportstree.constants.ApplicationConstants;
import com.aa.sportstree.sportstree.pojos.SelectionType;


public class PreferenceActivity extends Activity implements SelectionFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
        setTitle("Preferences");
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, getFragmentInstance(SelectionType.Sports))
                    .commit();
        }
    }

    private Fragment getFragmentInstance(SelectionType selectionType) {
        SelectionFragment selectionFragment = new SelectionFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ApplicationConstants.FRAGMENT_TYPE, selectionType.getValue());
        selectionFragment.setArguments(bundle);
        return selectionFragment;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.preference, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_preference, container, false);
            return rootView;
        }
    }

    public void onContinueClicked(SelectionType selectionType){
        switch(selectionType){
            case Teams:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case Sports:
                Fragment newFragment = getFragmentInstance(SelectionType.Teams);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
        }

    }
}
