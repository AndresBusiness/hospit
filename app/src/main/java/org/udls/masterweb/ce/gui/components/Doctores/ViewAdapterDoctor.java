package org.udls.masterweb.ce.gui.components.Doctores;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewAdapterDoctor extends FragmentPagerAdapter {

    FragmentManager fragmentManager;
    ListadoDoctores fragmentListadoDoctores;

    public ViewAdapterDoctor(FragmentManager fragmentManager)
    {
        super(fragmentManager);
        this.fragmentManager = fragmentManager;
        inicializar();
    }

    private void inicializar()
    {
        fragmentListadoDoctores = new ListadoDoctores();
    }

    public ListadoDoctores getFragmentListadoDoctores()
    {
        return fragmentListadoDoctores;
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0 : return fragmentListadoDoctores;
            default : return null;
        }
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }
}
