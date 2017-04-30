package spaceapps.alvaro.caringfornature;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

import me.riddhimanadib.library.BottomBarHolderActivity;
import me.riddhimanadib.library.NavigationPage;
import spaceapps.alvaro.caringfornature.Fragmentos.AlertaFragment;
import spaceapps.alvaro.caringfornature.Fragmentos.DesastresFragment;
import spaceapps.alvaro.caringfornature.Fragmentos.Modelos.Desastre;
import spaceapps.alvaro.caringfornature.Fragmentos.Modelos.Noticias;
import spaceapps.alvaro.caringfornature.Fragmentos.NoticiasFragment;
import spaceapps.alvaro.caringfornature.Fragmentos.Perfil;
import spaceapps.alvaro.caringfornature.Fragmentos.dummy.DummyContent;

public class MainActivity extends BottomBarHolderActivity implements Perfil.OnFragmentInteractionListener, DesastresFragment.OnListFragmentInteractionListener, AlertaFragment.OnListFragmentInteractionListener, NoticiasFragment.OnListFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // four navigation pages that would be displayed as four tabs
        // contains title, icon and fragment instance
        NavigationPage page1 = new NavigationPage("Alertas", ContextCompat.getDrawable(this, R.drawable.ic_alertas), AlertaFragment.newInstance(1));
        NavigationPage page2 = new NavigationPage("Siniestros", ContextCompat.getDrawable(this, R.drawable.ic_siniestros), DesastresFragment.newInstance(1));
        NavigationPage page3 = new NavigationPage("Profile", ContextCompat.getDrawable(this, R.drawable.ic_perfil), Perfil.newInstance("",""));
        NavigationPage noticias = new NavigationPage("Noticias", ContextCompat.getDrawable(this, R.drawable.ic_noticias), NoticiasFragment.newInstance(1));
        // add them in a list
        List<NavigationPage> navigationPages = new ArrayList<>();
        navigationPages.add(noticias);
        navigationPages.add(page1);
        navigationPages.add(page2);
        navigationPages.add(page3);

        // pass them to super method
        super.setupBottomBarHolderActivity(navigationPages);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(Desastre item) {

    }


    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    @Override
    public void onListFragmentInteraction(Noticias item) {

    }
}
