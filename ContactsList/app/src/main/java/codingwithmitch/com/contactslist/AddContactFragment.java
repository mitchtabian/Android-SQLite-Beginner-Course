package codingwithmitch.com.contactslist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by User on 6/13/2017.
 */

public class AddContactFragment extends Fragment {

    private static final String TAG = "AddContactFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_addcontact, container, false);

        Log.d(TAG, "onCreateView: started.");

        return view;
    }
}
