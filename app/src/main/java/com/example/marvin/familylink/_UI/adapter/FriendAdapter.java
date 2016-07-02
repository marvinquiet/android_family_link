//package com.example.marvin.familylink._UI.adapter;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.avos.avoscloud.AVUser;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import io.petchat._Utils.Utils;
//import io.petchat.cache.FileCache;
//import io.petchat.yochat.R;
//
///**
// * Created by marvin on 15/7/14.
// */
//public class FriendAdapter extends BaseAdapter {
//    private Context mContext;
//    private LayoutInflater inflater;
//    private List<AVUser> userList = new ArrayList<AVUser>();
//    private FriendSelectHolder holder;
//
//    private FileCache fileCache;
//
//    // Provide a suitable constructor (depends on the kind of dataset)
//    public FriendAdapter(Context mContext, List<AVUser> userList) {
//        this.mContext = mContext;
//        this.userList = userList;
//        inflater = LayoutInflater.from(mContext);
//    }
//
//    public class FriendSelectHolder {
//        public TextView mName;
//        public ImageView mSculpture;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        convertView = inflater.inflate(R.layout.item_friend, parent, false);
//
//        holder = new FriendSelectHolder();
//        holder.mName = (TextView) convertView.findViewById(R.id.friend_name_item);
//
//        holder.mSculpture = (ImageView) convertView.findViewById(R.id.friend_sculpture);
//
//        if (userList != null && userList.size() != 0) {
//            holder.mName.setText(userList.get(position).getUsername());
//
//            String userId = userList.get(position).getObjectId();
//            Bitmap bitmap = Utils.imageCache.get(userId);
//            if (bitmap == null) {
//                try {
//                    fileCache = FileCache.getFileCache(this.mContext);
//
//                    bitmap = fileCache.getUserPhoto(userId);
//                    if (bitmap != null) {
//                        holder.mSculpture.setImageBitmap(fileCache.getUserPhoto(userId));
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            } else {
//                holder.mSculpture.setImageBitmap(bitmap);
//            }
//        }
//
//        return convertView;
//    }
//
//    @Override
//    public int getCount() {
//        return userList.size();
//    }
//
//    @Override
//    public AVUser getItem(int position) {
//        return userList.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//
//}