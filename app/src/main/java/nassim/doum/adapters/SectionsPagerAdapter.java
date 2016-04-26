package nassim.doum.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import nassim.doum.fragments.FragmentProduit;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        FragmentProduit mainFragment = new FragmentProduit();
        Bundle bundle = new Bundle();
        bundle.putInt("pos",position);
        mainFragment.setArguments(bundle);
        return mainFragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Homme";
            case 1:
                return "Femme";
            case 2:
                return "Enfant";
        }
        return null;
    }
}
