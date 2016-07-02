package com.example.marvin.familylink._UI.pager;

import android.support.v4.view.ViewPager;

/**
 * Created by mawenjing on 15/5/19.
 */
public interface PageIndicator extends ViewPager.OnPageChangeListener {
    public void setViewPager(ViewPager view);

    public void setViewPager(ViewPager view, int initialPosition);
    public void setCurrentItem(int item);

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener listener);

    public void notifyDataSetChanged();
}
