package com.aa.sportstree.sportstree;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;


import com.aa.sportstree.sportstree.constants.ApplicationConstants;
import com.aa.sportstree.sportstree.data.DataInitializer;
import com.aa.sportstree.sportstree.pojos.SelectionType;
import com.aa.sportstree.sportstree.pojos.Sport;
import com.aa.sportstree.sportstree.pojos.Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A fragment representing a list of preference items.
 * <p/>
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridView.
 * <p/>
 * Activities containing this fragment MUST implement the {@link }
 * interface.
 */
public class SelectionFragment extends Fragment implements AbsListView.OnItemClickListener {

    private SelectionType selectionType;

    private OnFragmentInteractionListener mListener;

    /**
     * The fragment's ListView/GridView.
     */
    private AbsListView mListView;

    /**
     * The Adapter which will be used to populate the ListView/GridView with
     * Views.
     */
    private ListAdapter mAdapter;

    public static SelectionFragment newInstance(String param1, String param2) {
        SelectionFragment fragment = new SelectionFragment();
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SelectionFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Check if fragment type is Sports and populating array adapter accordingly.
        if(getArguments().getInt(ApplicationConstants.FRAGMENT_TYPE)==SelectionType.Sports.getValue()){
            //populate list of sports.
            mAdapter = new ArrayAdapter<Sport>(getActivity(),
                    android.R.layout.simple_list_item_1, android.R.id.text1,DataInitializer.sports);

//            if(DataInitializer.selectedSports!=null){
//                for(Sport sport: DataInitializer.selectedSports){
//                    int position =((ArrayAdapter<Sport>)mAdapter).getPosition(sport);
//                    itemIsSelected.put(position,true);
//                }
//            }

        }
        else {
            //Populate the list of teams.
            mAdapter = new ArrayAdapter<Team>(getActivity(),
                    android.R.layout.simple_list_item_1, android.R.id.text1, DataInitializer.teams);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teams, container, false);

        // Set the adapter
        mListView = (AbsListView) view.findViewById(android.R.id.list);
        ((AdapterView<ListAdapter>) mListView).setAdapter(mAdapter);

        // Set OnItemClickListener so we can be notified on item clicks
        mListView.setOnItemClickListener(this);

        TextView btn=(TextView)view.findViewById(R.id.continueButton);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(getArguments().getInt(ApplicationConstants.FRAGMENT_TYPE)==SelectionType.Sports.getValue()){
                    ArrayList<Sport> selectedSports = new ArrayList<Sport>();
                    //Add selected sports to sports list.
                    for(Map.Entry<Integer,Boolean> entry: itemIsSelected.entrySet()) {
                        if(entry.getValue()) {
                            Sport sport =(Sport) mAdapter.getItem(entry.getKey());
                            selectedSports.add(sport);
                        }
                    }
                    DataInitializer.setSelectedSports(selectedSports);
                    ((PreferenceActivity)getActivity()).onContinueClicked(SelectionType.Sports);
                }
                else {

                    List<Team> selectedTeams = new ArrayList<Team>();
                    //Add selected teams to team list.
                    for(Map.Entry<Integer,Boolean> entry: itemIsSelected.entrySet()) {
                        if(entry.getValue()) {
                            Team team =(Team) mAdapter.getItem(entry.getKey());
                            selectedTeams.add(team);
                        }
                    }
                    DataInitializer.setSelectedTeams(getActivity().getBaseContext(),selectedTeams);
                    ((PreferenceActivity)getActivity()).onContinueClicked(SelectionType.Teams);

                }
                     }
        });

        return view;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //clear previous selections on fragment.
        itemIsSelected.clear();
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        itemIsSelected.clear();
        mListener = null;
    }

    public static boolean click = false;

    Map<Integer, Boolean> itemIsSelected = new HashMap<Integer, Boolean>();

    /**
     * A method that keeps track whenever an item is selected and also updates the UI accordingly.
     * @param parent Parent adapter view.
     * @param view Current view.
     * @param position Position of clicked item.
     * @param id id of clicked item.
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (null != mListener) {
            if (itemIsSelected.containsKey(position)) {
                if (!itemIsSelected.get(position)) {
                    Drawable drawable = view.getResources().getDrawable(R.drawable.abc_ab_solid_light_holo);
                    view.setBackground(drawable);
                    itemIsSelected.put(position, true);
                } else {
                    view.setBackground(null);
                    itemIsSelected.put(position, false);
                }
            } else {
                itemIsSelected.put(position, true);
                Drawable drawable = view.getResources().getDrawable(R.drawable.abc_ab_solid_light_holo);
                view.setBackground(drawable);
            }
        }
    }

    /**
     * The default content for this Fragment has a TextView that is shown when
     * the list is empty. If you would like to change the text, call this method
     * to supply the text it should use.
     */
    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyText instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(String id);
    }



}
