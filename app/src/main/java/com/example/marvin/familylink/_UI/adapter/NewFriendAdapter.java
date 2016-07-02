//package com.example.marvin.familylink._UI.adapter;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.avos.avoscloud.AVUser;
//
//import java.io.IOException;
//import java.util.List;
//
//import de.greenrobot.event.EventBus;
//import io.petchat._Utils.Constants;
//import io.petchat._Utils.MessageUtils;
//import io.petchat._Utils.Utils;
//import io.petchat.cache.FileCache;
//import io.petchat.eventbus.RefreshFriendEvent;
//import io.petchat.yochat.R;
//
///**
// * Created by marvin on 15/7/18.
// */
//public class NewFriendAdapter extends BaseAdapter {
//    private Context context;
//    private LayoutInflater inflater;
//    private List<AVUser> userList;
//    private FriendSelectHolder holder;
//    private FileCache fileCache;
//
//    // Provide a suitable constructor (depends on the kind of dataset)
//    public NewFriendAdapter(Context context, List<AVUser> userList) {
//        inflater = LayoutInflater.from(context);
//        this.userList = userList;
//        this.context = context;
//    }
//
//    public class FriendSelectHolder {
//        public TextView mName;
//        public ImageView mSculpture;
//        public Button mNewFriend;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        convertView = inflater.inflate(R.layout.item_friend, parent, false);
//        final AVUser user = getItem(position);
//        final String type = (String) user.get(Constants.EVENT_TYPE);
//
//        holder = new FriendSelectHolder();
//        holder.mName = (TextView) convertView.findViewById(R.id.friend_name_item);
//        holder.mSculpture = (ImageView) convertView.findViewById(R.id.friend_sculpture);
//        holder.mNewFriend = (Button) convertView.findViewById(R.id.friend_new_button);
//        holder.mNewFriend.setVisibility(View.VISIBLE);
//
//        if (user != null) {
//            holder.mName.setText(user.getUsername());
//            if (type.equals(Constants.EVENT_REQUEST)) {
//                holder.mNewFriend.setText("添加");
//            } else if (type.equals(Constants.EVENT_ACCPET)) {
//                holder.mNewFriend.setText("接受");
//            } else if (type.equals(Constants.EVENT_SENT)) {
//                holder.mNewFriend.setText("已发送");
//                holder.mNewFriend.setEnabled(false);
//                holder.mNewFriend.setBackground(null);
//                holder.mNewFriend.setTextColor(context.getResources().getColor(R.color.md_blue_grey_500));
//            }
//
//            holder.mNewFriend.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Button button = (Button) v;
//                    MessageUtils.addFriend(context, user);
//                    if (type.equals(Constants.EVENT_REQUEST)) {
//                        button.setText("已发送");
//                    } else if (type.equals(Constants.EVENT_ACCPET)) {
//                        button.setText("已接受");
//                        EventBus.getDefault().post(new RefreshFriendEvent());
//                    }
//                    button.setEnabled(false);
//                    button.setBackground(null);
//                    button.setTextColor(context.getResources().getColor(R.color.md_blue_grey_500));
//                }
//            });
//
//            String userId = user.getObjectId();
//            Bitmap bitmap = Utils.imageCache.get(userId);
//            if (bitmap == null) {
//                try {
//                    fileCache = FileCache.getFileCache(this.context);
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
//}
