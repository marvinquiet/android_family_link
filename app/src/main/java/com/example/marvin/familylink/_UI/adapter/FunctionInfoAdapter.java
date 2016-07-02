//package com.example.marvin.familylink._UI.adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import io.petchat.yochat.R;
//
///**
// * Created by marvin on 15/7/14.
// */
//public class FunctionInfoAdapter extends BaseAdapter {
//    private Context mContext;
//    private String[] functionList = {"新的朋友"};
//    private int newFriendNum;
//    private LayoutInflater inflater;
//    private boolean newFriendRequest;
//
//    private FriendSelectHolder holder;
//    // Provide a suitable constructor (depends on the kind of dataset)
//    public FunctionInfoAdapter(Context mContext, boolean newFriendRequest, int newFriendNum) {
//        this.mContext = mContext;
//        this.newFriendRequest = newFriendRequest;
//        this.newFriendNum = newFriendNum;
//        inflater = LayoutInflater.from(mContext);
//    }
//
//    public class FriendSelectHolder {
//        public TextView mName;
//        public ImageView mSculpture;
//        public LinearLayout mNewFiendLayout;
//        public TextView mNewFriendNum;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        convertView = inflater.inflate(R.layout.item_friend, parent, false);
//
//        holder = new FriendSelectHolder();
//        holder.mName = (TextView) convertView.findViewById(R.id.friend_name_item);
//        holder.mSculpture = (ImageView) convertView.findViewById(R.id.friend_sculpture);
//        holder.mNewFiendLayout = (LinearLayout) convertView.findViewById(R.id.new_friend_layout);
//        holder.mNewFriendNum = (TextView) convertView.findViewById(R.id.new_friend_num);
//
//        holder.mSculpture.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_new_friend));
//        holder.mName.setText(functionList[position]);
//
//        if (newFriendNum != 0) {
//            holder.mNewFiendLayout.setVisibility(View.VISIBLE);
//            if (newFriendRequest) {
//                holder.mNewFiendLayout.setBackground(mContext.getResources().getDrawable(R.drawable.ic_circle_new));
//            } else {
//                holder.mNewFiendLayout.setBackground(mContext.getResources().getDrawable(R.drawable.ic_circle_recommend));
//            }
//            holder.mNewFriendNum.setText(String.valueOf(newFriendNum));
//        }
//
//        return convertView;
//    }
//
//    @Override
//    public int getCount() {
//        return functionList.length;
//    }
//
//    @Override
//    public String getItem(int position) {
//        return functionList[position];
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//}
//
