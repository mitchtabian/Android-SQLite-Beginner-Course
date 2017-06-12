package codingwithmitch.com.contactslist.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;
import java.util.List;

import codingwithmitch.com.contactslist.R;
import codingwithmitch.com.contactslist.models.Contact;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by User on 6/12/2017.
 */

public class ContactPropertyListAdapter extends ArrayAdapter<String> {

    private LayoutInflater mInflater;
    private List<String> mProperties = null;
    private int layoutResource;
    private Context mContext;
    private String mAppend;

    public ContactPropertyListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<String> properties) {
        super(context, resource, properties);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutResource = resource;
        this.mContext = context;
        this.mProperties = properties;
    }

    //---------------------------Stuff to change--------------------------------------------
    private static class ViewHolder{
        TextView property;
        ImageView rightIcon;
        ImageView leftIcon;
    }
    //--------------------------------------------------------------------------------------

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        /*
        ************ ViewHolder Build Pattern Start ************
         */
        final ViewHolder holder;

        if(convertView == null){
            convertView = mInflater.inflate(layoutResource, parent, false);
            holder = new ViewHolder();

            //---------------------------Stuff to change--------------------------------------------
            holder.property = (TextView) convertView.findViewById(R.id.tvMiddleCardView);
            holder.rightIcon = (ImageView) convertView.findViewById(R.id.iconRightCardView);
            holder.leftIcon = (ImageView) convertView.findViewById(R.id.iconLeftCardView);
            //--------------------------------------------------------------------------------------

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        //---------------------------Stuff to change--------------------------------------------
        final String property = getItem(position);
        holder.property.setText(property);

        //check if it's an email or a phone number
        //email
        if(property.contains("@")){
            holder.leftIcon.setImageResource(mContext.getResources().getIdentifier("@drawable/ic_email", null, mContext.getPackageName()));
        }
        else if((property.length() != 0)){
            holder.leftIcon.setImageResource(mContext.getResources().getIdentifier("@drawable/ic_phone", null, mContext.getPackageName()));
            holder.rightIcon.setImageResource(mContext.getResources().getIdentifier("@drawable/ic_message", null, mContext.getPackageName()));

        }


        //--------------------------------------------------------------------------------------

        return convertView;
    }
}
















