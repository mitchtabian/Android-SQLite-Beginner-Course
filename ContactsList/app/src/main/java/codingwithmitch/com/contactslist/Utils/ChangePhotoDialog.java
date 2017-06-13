package codingwithmitch.com.contactslist.Utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import codingwithmitch.com.contactslist.R;

/**
 * Created by User on 6/13/2017.
 */

public class ChangePhotoDialog extends DialogFragment{

    private static final String TAG = "ChangePhotoDialog";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_changephoto, container, false);

        return view;
    }
}
