package spaceapps.alvaro.caringfornature.Fragmentos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import spaceapps.alvaro.caringfornature.Fragmentos.DesastresFragment.OnListFragmentInteractionListener;
import spaceapps.alvaro.caringfornature.Fragmentos.Modelos.Desastre;
import spaceapps.alvaro.caringfornature.Fragmentos.dummy.DummyContent.DummyItem;
import spaceapps.alvaro.caringfornature.R;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyDesastresRecyclerViewAdapter extends RecyclerView.Adapter<MyDesastresRecyclerViewAdapter.ViewHolder> {


    private final List<Desastre> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyDesastresRecyclerViewAdapter(List<Desastre> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_desastres, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        String fechaDesastre = "Fecha: "+mValues.get(position).getFecha_obtenido()+" Hora:"+mValues.get(position).getHora_obtenido();
        String cadenaCoordenadas= "Longitud: "+mValues.get(position).getLatitud()+" Latitud:"+mValues.get(position).getLongitud();
        holder.mIdView.setText(fechaDesastre);
        holder.mContentView.setText(cadenaCoordenadas);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
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
