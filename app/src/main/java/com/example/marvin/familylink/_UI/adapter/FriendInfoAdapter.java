//package com.example.marvin.familylink._UI.adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.TextView;
//
//import java.util.List;
//
//import io.petchat.yochat.R;
//
///**
// * Created by marvin on 15/7/18.
// */
//public class FriendInfoAdapter extends BaseAdapter {
//    private LayoutInflater inflater;
//    private List<String> userInfo;
//    private String[] infoDescription = {"手机号", "邮箱"};
//    private FriendSelectHolder holder;
//    // Provide a suitable constructor (depends on the kind of dataset)
//    public FriendInfoAdapter (Context context, List<String> userInfo) {
//        inflater = LayoutInflater.from(context);
//        this.userInfo = userInfo;
//    }
//
//    public class FriendSelectHolder {
//        public TextView mDescription;
//        public TextView mDetail;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        convertView = inflater.inflate(R.layout.item_friend_info, parent, false);
//
//        holder = new FriendSelectHolder();
//        holder.mDescription = (TextView) convertView.findViewById(R.id.info_description);
//        holder.mDetail = (TextView) convertView.findViewById(R.id.info_detail);
//
//        holder.mDescription.setText(infoDescription[position]);
//        holder.mDetail.setText(getItem(position));
//
//        return convertView;
//    }
//
//    @Override
//    public int getCount() {
//        return userInfo.size();
//    }
//
//    @Override
//    public String getItem(int position) {
//        return userInfo.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//}