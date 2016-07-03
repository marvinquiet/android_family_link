package com.example.marvin.familylink._UI.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marvin.familylink.R;
import com.example.marvin.familylink._UI.models.Content;

import java.util.List;
import java.util.Random;

/**
 * Created by marvin on 15/7/14.
 */
public class ContentAdapter extends BaseAdapter {
    private Context mContext;
    private List<Content> contentList;
    private LayoutInflater inflater;
    private FriendSelectHolder holder;

    // Provide a suitable constructor (depends on the kind of dataset)
    public ContentAdapter(Context mContext, List<Content> contentList) {
        this.mContext = mContext;
        this.contentList = contentList;
        inflater = LayoutInflater.from(mContext);
    }

    public class FriendSelectHolder {
        public TextView mContent;
        public ImageView mPicture;
        public TextView mTime;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_friend, parent, false);

        holder = new FriendSelectHolder();
        holder.mContent = (TextView) convertView.findViewById(R.id.content_info);
        holder.mPicture = (ImageView) convertView.findViewById(R.id.content_pic);
        holder.mTime = (TextView) convertView.findViewById(R.id.content_time);

        if (contentList != null && contentList.size() != 0) {
            Content curContent = contentList.get(position);
            holder.mContent.setText(curContent.content);
            if (curContent.picture == null || curContent.picture == "")
                holder.mPicture.setVisibility(View.GONE);
            else {
                Random random = new Random();
                switch (random.nextInt(5)) {
                    case 0:
                        holder.mPicture.setImageResource(R.drawable.ic_love_1);
                        break;
                    case 1:
                        holder.mPicture.setImageResource(R.drawable.ic_love_2);
                        break;
                    case 2:
                        holder.mPicture.setImageResource(R.drawable.ic_love_3);
                        break;
                    case 3:
                        holder.mPicture.setImageResource(R.drawable.ic_love4);
                        break;
                    case 4:
                        holder.mPicture.setImageResource(R.drawable.ic_love_5);
                        break;
                    default:
                        break;

                }
                holder.mPicture.setVisibility(View.VISIBLE);
            }

            holder.mTime.setText(curContent.time);
        }

        return convertView;
    }

    @Override
    public int getCount() {
        return contentList.size();
    }

    @Override
    public Content getItem(int position) {
        return contentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


}