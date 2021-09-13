package com.ahaguru.teacherahaguru.ui.Manage.Tabbed;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.ahaguru.teacherahaguru.ui.Manage.Invite.InviteFragment;
import com.ahaguru.teacherahaguru.ui.Manage.Requests.RequestsFragment;
import com.ahaguru.teacherahaguru.ui.Manage.Teachers.TeachersFragment;
import org.jetbrains.annotations.NotNull;


public class PagerAdapter extends FragmentStateAdapter {

    private int numOfTabs;

    public PagerAdapter(FragmentActivity fa, int numOfTabs) {
        super(fa);
        this.numOfTabs = numOfTabs;
    }


    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {

            case 0:
                return new TeachersFragment();
            case 1:
                return new RequestsFragment();
            case 2:
                return new InviteFragment();
            default:
                return null;


        }
    }

    @Override
    public int getItemCount() {
        return numOfTabs;
    }
}
