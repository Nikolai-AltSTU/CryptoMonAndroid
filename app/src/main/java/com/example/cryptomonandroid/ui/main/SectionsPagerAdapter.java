package com.example.cryptomonandroid.ui.main;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.cryptomonandroid.Arbitrage;
import com.example.cryptomonandroid.Costs;
import com.example.cryptomonandroid.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private int num_of_pages = 2;
    private Fragment []pages;
    @StringRes
    private static final int[] TAB_TITLES = new int[] {R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {

        super(fm);
        pages = new Fragment[num_of_pages];
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        if(position < num_of_pages) {
            if (pages[position] == null) {
                if (position == 0) {
                    pages[position] = new Costs();
                } else
                if (position == 1) {
                    pages[position] = new Arbitrage();
                }
            }
            return pages[position];
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return num_of_pages;
    }
}