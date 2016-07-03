package com.example.marvin.familylink._UI.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.marvin.familylink.R;
import com.example.marvin.familylink._UI._Utils.BLog;
import com.example.marvin.familylink._UI.adapter.ContentAdapter;
import com.example.marvin.familylink._UI.models.Content;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
//import com.example.marvin.familylink._UI.adapter.ContentAdapter;


/**
 * Created by mawenjing on 15/5/18.
 */

// TODO view layer code should be placed under a same parent, like /view/fragment/ /view/activity/ /view/component/
public class MineFragment extends Fragment {
    private static Context context;
    private static final String URL = "https://familyshare-211bb.firebaseio.com/family";

    List<Content> contentList;
    private ListView mContentList;
    private ContentAdapter mAdapter;

    public MineFragment() {
    }

    public static MineFragment newInstance() {
        MineFragment mineFragment = new MineFragment();
        return mineFragment;
    }

    // Fetch file cache and show
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (BLog.logEnable == true) {
            BLog.d("### Friend Fragment onCreateView");
        }

        View view = inflater.inflate(R.layout.fragment_mine, null);
        context = getActivity();
        mContentList = (ListView) view.findViewById(R.id.list_content);

        contentList = new ArrayList<Content>();
        mAdapter = new ContentAdapter(context, contentList);
        getContentList("0");
        setContentListView(contentList);

        return view;
    }

    // Do some refresh work
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (BLog.logEnable == true) {
            BLog.d("###Friend fragment on resume.");
        }

        getContentList("1");
        setContentListView(contentList);
    }


    private void setContentListView(List<Content> contentList) {
        if (contentList != null && context != null) {
            BLog.d("### contentList not null");
            mAdapter = new ContentAdapter(context, contentList);
            mContentList.setAdapter(mAdapter);
        }
    }

    private void getContentList(String name) {
        Firebase mFireRef_con = new Firebase(URL + "/person/" + name + "/content/");
        mFireRef_con.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Content> contentList = new ArrayList<Content>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Content content = new Content((String) snapshot.child("con").getValue(),
                            (String) snapshot.child("picture").getValue(),
                            (String) snapshot.child("time").getValue());
                    contentList.add(content);
                }

                setContentListView(contentList);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
    }

//    public ArrayList<Content> get_person_content(String name)
//    {
//        ArrayList<Content> result = new ArrayList<>();
//        for (int i = 0; i < 2; i++)
//        {
//            final Content conf = new Content();
//            Firebase mFireRef_con = new Firebase(URL + "/person/" + name + "/content/" + Integer.toString(i) + "/con");
//            mFireRef_con.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    conf.content = dataSnapshot.getValue(String.class);
//                }
//                @Override
//                public void onCancelled(FirebaseError firebaseError) {
//                }
//            });
//
//            Firebase mFireRef_pic = new Firebase(URL + "/person/" + name + "/content/" + Integer.toString(i) + "/picture");
//            mFireRef_pic.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    conf.picture = dataSnapshot.getValue(String.class);
//                }
//
//                @Override
//                public void onCancelled(FirebaseError firebaseError) {
//
//                }
//            });
//
//            Firebase mFireRef_time = new Firebase(URL + "/person/" + name + "/content/");
//            mFireRef_time.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    conf.time = dataSnapshot.getValue(String.class);
//                }
//
//                @Override
//                public void onCancelled(FirebaseError firebaseError) {
//
//                }
//            });
//            result.add(conf);
//        }
//        return result;
//    }
//
//        recommendFriendList = Utils.readUserMemoryThenFile(context, Constants.RECOMMEND_FRIEND_MEMORY_KEY, Constants.EVENT_REQUEST);
//        receivingRequestList = Utils.readUserMemoryThenFile(context, Constants.RECEIVING_REQUEST_KEY, Constants.EVENT_ACCPET);
//
//        setFriendListView(friendList);
//        setFunctionListView(receivingRequestList, recommendFriendList);
//        refresh();


//    class GetFriendsNumTask extends AsyncTask<Void, Void, List<List<AVUser>>> {
//        @Override
//        protected List<List<AVUser>> doInBackground(Void... params) {
//            List<List<AVUser>> userList = new ArrayList<List<AVUser>>();
//            List<AVUser> getRequestList = new ArrayList<AVUser>();
//            List<AVUser> getRecommendList = new ArrayList<AVUser>();
//
//            try {
//                AVQuery<AVUser> followerQuery = AVUser.getCurrentUser().followerQuery(AVUser.class);
//                followerQuery.include("follower");
//
//                getRequestList = followerQuery.find();
//                List<AVUser> friendList = MessageUtils.getFriends();
//                if (getRequestList != null && friendList != null) {
//                    getRequestList.removeAll(friendList);
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            getRecommendList = MessageUtils.getFriendRecommendation();
//            Utils.saveUserMemoryThenFile(context, getRequestList, Constants.RECEIVING_REQUEST_KEY);
//            Utils.saveUserMemoryThenFile(context, getRecommendList, Constants.RECOMMEND_FRIEND_MEMORY_KEY);
//
//            if (getRequestList != null) {
//                for (int i = 0; i < getRequestList.size(); i++) {
//                    getRequestList.get(i).put(Constants.EVENT_TYPE, Constants.EVENT_ACCPET);
//                }
//            }
//
//            if (getRecommendList != null) {
//                for (int i = 0; i < getRecommendList.size(); i++) {
//                    getRecommendList.get(i).put(Constants.EVENT_TYPE, Constants.EVENT_REQUEST);
//                }
//            }
//
//            userList.add(getRequestList);
//            userList.add(getRecommendList);
//            return userList;
//        }
//
//        @Override
//        protected void onPostExecute(List<List<AVUser>> userList) {
//            super.onPostExecute(userList);
//            List<AVUser> getRequestList = new ArrayList<AVUser>();
//            List<AVUser> getRecommendList = new ArrayList<AVUser>();
//
//            if (userList != null && userList.size() != 0) {
//                getRequestList = userList.get(0);
//                getRecommendList = userList.get(1);
//            }
//
//            fileCache.saveUserListPhoto(getRequestList);
//            fileCache.saveUserListPhoto(getRecommendList);
//
//            setFunctionListView(getRequestList, getRecommendList);
//        }
//    }

    /**
     * Use {@link ContentAdapter} to adapt friend ListView
     */
//    private void setFriendListView(List<AVUser> friendList) {
//        if (friendList != null && friendList.size() != 0) {
//            userList.clear();
//            userList.addAll(friendList);
//        }
//
//        if (userList != null && context != null) {
//            mAdapter.notifyDataSetChanged();
//            mFriendList.setAdapter(mAdapter);
//            mFriendList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    Intent intent = new Intent(context, FriendInfoActivity.class);
//                    intent.putExtra(Constants.FRIENDINFO_ID, userList.get(position).getObjectId());
//                    intent.putExtra(Constants.FRIENDINFO_USERNAME, userList.get(position).getUsername());
//                    intent.putExtra(Constants.FRIENDINFO_PHONE, userList.get(position).getMobilePhoneNumber());
//                    intent.putExtra(Constants.FRIENDINFO_EMAIL, userList.get(position).getEmail());
//                    startActivity(intent);
//
//                }
//            });
//        }
//    }

    /**
     * FriendRequest or RecommendFriend
     *
     */
//    private void setFunctionListView(List<AVUser> requestList, List<AVUser> recommendList) {
//        if (context != null) {
//            if (requestList != null && requestList.size() != 0) {
//                mFunctionAdapter = new FunctionInfoAdapter(context, true, requestList.size());
//            } else if (recommendList != null && recommendList.size() != 0) {
//                mFunctionAdapter = new FunctionInfoAdapter(context, false, recommendList.size());
//            } else {
//                mFunctionAdapter = new FunctionInfoAdapter(context, false, 0);
//            }
//
//            mFunctionAdapter.notifyDataSetChanged();
//            mFunctionList.setAdapter(mFunctionAdapter);
//            mFunctionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    if (position == 0) {
//                        startActivity(new Intent(context, NewFriendActivity.class));
//                    }
//                }
//            });
//
//        }
//
//    }


//    @Override
//    public void onStart() {
//        super.onStart();
//        EventBus.getDefault().register(this);
//    }
//
//    @Override
//    public void onStop() {
//        EventBus.getDefault().unregister(this);
//        super.onStop();
//    }

//    public void onEvent(RefreshFriendEvent event) {
//        refresh();
//    }
//
//    private void refresh() {
//        if (Utils.isNetworkAvailable(context) == true) {
//            new GetFriendListTask(context, new AsyncResponse() {
//                @Override
//                public void asyncTaskFinish(Object object) {
//                    if (object != null) {
//                        setFriendListView((List<AVUser>) object);
//                    }
//                }
//            }).execute();
//
//            new GetFriendsNumTask().execute();
//        } else {
//            Utils.showConnectionNADialog(context);
//        }
//    }

}
