//package com.example.marvin.familylink._UI.adapter;
//
//import android.content.Context;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentPagerAdapter;
//
//import com.example.marvin.familylink._UI._Utils.Constants;
//
//import io.petchat._UI.FriendFragment;
//import io.petchat._UI.TaskFragment;
//import io.petchat._Utils.Constants;
//
///**
// * Created by mawenjing on 15/5/18.
// */
//public class MainFragmentAdapter extends FragmentPagerAdapter {
//    private String[] titleStr = {Constants.FAMILY_FRAGMENT, Constants.MINE_FRAGMENT};
//
//    public MainFragmentAdapter(FragmentManager fm) {
//        super(fm);
//    }
//
//    public MainFragmentAdapter(FragmentManager fm, Context context) {
//        super(fm);
//    }
//
//    @Override
//    public Fragment getItem(int position) {
//        switch (position) {
//            case 0:
//                return TaskFragment.newInstance();
//            case 1:
//                return FriendFragment.newInstance();
//        }
//        return null;
//    }
//
//    @Override
//    public CharSequence getPageTitle(int position) {
//        return titleStr[position];
//    }
//
//    @Override
//    public int getCount() {
//        return titleStr.length;
//    }
//
//    @Override
//    public int getItemPosition(Object object) {
//        return POSITION_NONE;
//    }
//}
