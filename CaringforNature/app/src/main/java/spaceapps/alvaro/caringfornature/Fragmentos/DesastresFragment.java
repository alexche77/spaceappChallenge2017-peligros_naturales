package spaceapps.alvaro.caringfornature.Fragmentos;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import spaceapps.alvaro.caringfornature.Fragmentos.Modelos.Desastre;
import spaceapps.alvaro.caringfornature.R;
import spaceapps.alvaro.caringfornature.Fragmentos.dummy.DummyContent;
import spaceapps.alvaro.caringfornature.Fragmentos.dummy.DummyContent.DummyItem;
import universum.studios.android.font.Font;

import java.util.ArrayList;
/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class DesastresFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private ArrayList<Desastre> listaDesastres;
    private DatabaseReference databaseReference;
    private RecyclerView recyclerView;
    private MyDesastresRecyclerViewAdapter recyclerViewAdapter;
    private LinearLayout l;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public DesastresFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static DesastresFragment newInstance(int columnCount) {
        DesastresFragment fragment = new DesastresFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseReference = FirebaseDatabase.getInstance().getReference("incendios");
    }

    private void borrarItem(DataSnapshot dataSnapshot) {

    }

    private void obtenerDesastres(DataSnapshot dataSnapshot) {


            Desastre desastre = dataSnapshot.getValue(Desastre.class);
            Log.d("LOG_FIREBAS","Desastre traido desde DB"+desastre.getBrillo());
            listaDesastres.add(desastre);
            l.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            recyclerViewAdapter = new MyDesastresRecyclerViewAdapter(listaDesastres, mListener);
            recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        Obteniendo datos desde firebase
        listaDesastres = new ArrayList<>();

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                obtenerDesastres(dataSnapshot);
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                obtenerDesastres(dataSnapshot);
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                borrarItem(dataSnapshot);
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        View view = inflater.inflate(R.layout.fragment_desastres_list, container, false);
        recyclerView =(RecyclerView) view.findViewById(R.id.list);
        l= (LinearLayout)view.findViewById(R.id.noMessages);

        configurarToolbar(view);
        // Set the adapter
        if (recyclerView != null) {
            Context context = view.getContext();
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(recyclerViewAdapter);
        }
        return view;
    }

    private void configurarToolbar(View view) {
        View padreToolbar = view.findViewById(R.id.padre_toolbar_desastres);
        Toolbar toolbar = (Toolbar)padreToolbar.findViewById(R.id.toolbar_interna_desastres);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title_desastres);
//        Fuente personalizada
        final Font fuente = Font.create("CaviarDreams.ttf");
        mTitle.setTypeface(fuente.getTypeface(getContext()));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Desastre item);
    }
}
