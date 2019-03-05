package org.udls.masterweb.ce.gui.components.CentrosMedicos;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapterMain  extends FragmentPagerAdapter {

    FragmentManager fragmentManager;

    ListadoCentrosMedicos fragmentListadoCentrosMedicos;

    public ViewPagerAdapterMain(FragmentManager fragmentManager)
    {
        super(fragmentManager);
        this.fragmentManager = fragmentManager;
        inicializar();
    }

    private void inicializar()
    {
        fragmentListadoCentrosMedicos = new ListadoCentrosMedicos();
    }

    public ListadoCentrosMedicos getFragmentListadoCentrosMedicos()
    {
        return fragmentListadoCentrosMedicos;
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0 : return fragmentListadoCentrosMedicos;
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
