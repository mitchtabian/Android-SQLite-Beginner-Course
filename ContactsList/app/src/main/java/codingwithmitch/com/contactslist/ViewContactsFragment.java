package codingwithmitch.com.contactslist;

import android.content.Context;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import codingwithmitch.com.contactslist.Utils.CustomListAdapter;
import codingwithmitch.com.contactslist.models.Contact;

/**
 * Created by User on 6/12/2017.
 */

public class ViewContactsFragment extends Fragment {

    private static final String TAG = "ViewContactsFragment";

    private String testImageURL = "pbs.twimg.com/profile_images/616076655547682816/6gMRtQyY.jpg";

    private static final int STANDARD_APPBAR = 0;
    private static final int SEARCH_APPBAR = 1;
    private int mAppBarState;


    private AppBarLayout viewContactsBar, searchBar;
    private CustomListAdapter adapter;
    private ListView contactsList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_viewcontacts, container, false);
        viewContactsBar = (AppBarLayout) view.findViewById(R.id.viewContactsToolbar);
        searchBar = (AppBarLayout) view.findViewById(R.id.searchToolbar);
        contactsList = (ListView) view.findViewById(R.id.contactsList);
        Log.d(TAG, "onCreateView: started.");


        setAppBarState(STANDARD_APPBAR);

        setupContactsList();

        // navigate to add contacts fragment
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fabAddContact);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked fab.");
            }
        });

        ImageView ivSearchContact = (ImageView) view.findViewById(R.id.ivSearchIcon);
        ivSearchContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked search icon.");
                toggleToolBarState();
            }
        });

        ImageView ivBackArrow = (ImageView) view.findViewById(R.id.ivBackArrow);
        ivBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked back arrow.");
                toggleToolBarState();
            }
        });


        return view;
    }

    //
    private void setupContactsList(){
        final ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Mitch Tabian", "(604) 855-1111", "Mobile","mitch@tabian.ca", testImageURL));
        contacts.add(new Contact("Mitch Tabian", "(604) 855-1111", "Mobile","mitch@tabian.ca", testImageURL));
        contacts.add(new Contact("Mitch Tabian", "(604) 855-1111", "Mobile","mitch@tabian.ca", testImageURL));
        contacts.add(new Contact("Mitch Tabian", "(604) 855-1111", "Mobile","mitch@tabian.ca", testImageURL));
        contacts.add(new Contact("Mitch Tabian", "(604) 855-1111", "Mobile","mitch@tabian.ca", testImageURL));
        contacts.add(new Contact("Mitch Tabian", "(604) 855-1111", "Mobile","mitch@tabian.ca", testImageURL));
        contacts.add(new Contact("Mitch Tabian", "(604) 855-1111", "Mobile","mitch@tabian.ca", testImageURL));
        contacts.add(new Contact("Mitch Tabian", "(604) 855-1111", "Mobile","mitch@tabian.ca", testImageURL));
        contacts.add(new Contact("Mitch Tabian", "(604) 855-1111", "Mobile","mitch@tabian.ca", testImageURL));
        contacts.add(new Contact("Mitch Tabian", "(604) 855-1111", "Mobile","mitch@tabian.ca", testImageURL));
        contacts.add(new Contact("Mitch Tabian", "(604) 855-1111", "Mobile","mitch@tabian.ca", testImageURL));
        contacts.add(new Contact("Mitch Tabian", "(604) 855-1111", "Mobile","mitch@tabian.ca", testImageURL));
        contacts.add(new Contact("Mitch Tabian", "(604) 855-1111", "Mobile","mitch@tabian.ca", testImageURL));
        contacts.add(new Contact("Mitch Tabian", "(604) 855-1111", "Mobile","mitch@tabian.ca", testImageURL));

        adapter = new CustomListAdapter(getActivity(), R.layout.layout_contactslistitem, contacts, "https://");
        contactsList.setAdapter(adapter);

        contactsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onClick: navigating to " + getString(R.string.contact_fragment));
                ContactFragment fragment = new ContactFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                // reaplce whatever is in the fragment_container view with this fragment,
                // amd add the transaction to the back stack so the user can navigate back
                transaction.replace(R.id.fragment_container, fragment);
                transaction.addToBackStack(getString(R.string.contact_fragment));
                transaction.commit();
            }
        });
    }

    /**
     * Initiates the appbar state toggle
     */
    private void toggleToolBarState() {
        Log.d(TAG, "toggleToolBarState: toggling AppBarState.");
        if(mAppBarState == STANDARD_APPBAR){
            setAppBarState(SEARCH_APPBAR);
        }else{
            setAppBarState(STANDARD_APPBAR);
        }
    }

    /**
     * Sets the appbar state for either the search 'mode' or 'standard' mode
     * @param state
     */
    private void setAppBarState(int state) {
        Log.d(TAG, "setAppBarState: changing app bar state to: " + state);

        mAppBarState = state;

        if(mAppBarState == STANDARD_APPBAR){
            searchBar.setVisibility(View.GONE);
            viewContactsBar.setVisibility(View.VISIBLE);

            //hide the keyboard
            View view = getView();
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            try{
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }catch (NullPointerException e){
                Log.d(TAG, "setAppBarState: NullPointerException: " + e.getMessage());
            }
        }

        else if(mAppBarState == SEARCH_APPBAR){
            viewContactsBar.setVisibility(View.GONE);
            searchBar.setVisibility(View.VISIBLE);

            //open the keyboard
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        setAppBarState(STANDARD_APPBAR);
    }
}


















