package spaceapps.alvaro.caringfornature.Fragmentos;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import spaceapps.alvaro.caringfornature.Fragmentos.Modelos.Desastre;
import spaceapps.alvaro.caringfornature.R;
import universum.studios.android.font.Font;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class DesastresFragment extends Fragment {


    private FirebaseRecyclerAdapter<Desastre, ViewHolder> adapter;

    private OnListFragmentInteractionListener mListener;
    private LinearLayout l;
    private RecyclerView recyclerView;

    public DesastresFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static DesastresFragment newInstance() {
        return  new DesastresFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_desastres_list, container, false);
//        Obteniendo datos desde firebase
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("incendios");

        databaseReference.keepSynced(true);

        Log.d("REF", "R: "+ databaseReference.toString());

        l = (LinearLayout) view.findViewById(R.id.noMessages);


        Context context = view.getContext();


        l.setVisibility(View.VISIBLE);
        adapter = new FirebaseRecyclerAdapter<Desastre, ViewHolder>(
                Desastre.class,
                R.layout.fragment_desastres,
                ViewHolder.class,
                databaseReference) {
            @Override
            public void populateViewHolder(ViewHolder holder, Desastre model, int position) {
                Log.d("Elemento","Fuego->"+model.getDireccion());
                String fechaDesastre = "Fecha: "+model.getFecha_obtenido()+" Hora:"+model.getHora_obtenido();
                String cadenaCoordenadas=model.getDireccion();
                holder.mIdView.setText(fechaDesastre);
                holder.mContentView.setText(cadenaCoordenadas);
            }
        };
        configurarToolbar(view);
        recyclerView = (RecyclerView) view.findViewById(R.id.listaIncendios);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        if (adapter.getItemCount()>0){

            recyclerView.setAdapter(adapter);
            l.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
        else{
            l.setVisibility(View.VISIBLE);
        }

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                l.setVisibility(View.GONE);
                recyclerView.setAdapter(adapter);
                recyclerView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

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

        adapter.cleanup();
    }
    @Override
    public void onStart() {
        super.onStart();

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
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView mIdView;
        final TextView mContentView;
        public Desastre mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.fecha_desastre);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}

