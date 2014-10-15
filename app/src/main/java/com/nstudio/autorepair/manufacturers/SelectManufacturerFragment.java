package com.nstudio.autorepair.manufacturers;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;

import com.nstudio.autorepair.OnIdentificableItemSelectedListener;

/**
 * Created by noktgula on 14.10.2014.
 */
public class SelectManufacturerFragment extends ListFragment implements AdapterView.OnItemClickListener
{
    private OnIdentificableItemSelectedListener m_listener;
    private CursorAdapter m_adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        m_listener = ((ManufacturersActivity)getActivity()).getListener();
        View view = super.onCreateView( inflater, container, savedInstanceState );
        ListView listView = getListView();
        listView.setAdapter( m_adapter );
        listView.setOnItemClickListener( this );
        return view;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
    {
        m_listener.onIdentificableItemSelected( (Integer)m_adapter.getItem( position ) );
    }
}
