package com.example.marvin.familylink._UI.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marvin.familylink.R;

import java.util.List;

/**
 * Created by marvin on 15/7/14.
 */
public class InfoAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> userList;
    private LayoutInflater inflater;
    private FriendSelectHolder holder;

    // Provide a suitable constructor (depends on the kind of dataset)
    public InfoAdapter(Context mContext, List<String> userList) {
        this.mContext = mContext;
        this.userList = userList;
        inflater = LayoutInflater.from(mContext);
    }

    public class FriendSelectHolder {
        public TextView mName;
        public ImageView mSculpture;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_friend, parent, false);

        holder = new FriendSelectHolder();
        holder.mName = (TextView) convertView.findViewById(R.id.friend_name_item);
        holder.mSculpture = (ImageView) convertView.findViewById(R.id.friend_sculpture);


        if (userList != null && userList.size() != 0) {
            holder.mName.setText(userList.get(position));
        }
//
//            String userId = userList.get(position).getObjectId();
//            Bitmap bitmap = Utils.imageCache.get(userId);
//            if (bitmap == null) {
//
//            } else {
//                holder.mSculpture.setImageBitmap(bitmap);
//            }
//        }

        return convertView;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public String getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


}