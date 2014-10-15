package com.nstudio.autorepair.manufacturers;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nstudio.autorepair.R;

/**
 * Created by noktgula on 14.10.2014.
 */
public class CarAdapter extends CursorAdapter
{
    public CarAdapter(Context context, Cursor c)
    {
        super( context, c, 0 );
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup)
    {
        View view = LayoutInflater.from( context ).inflate( R.layout.layout_car_list_item, viewGroup, false );
        ViewHolder holder = new ViewHolder();
        holder.m_title = (TextView)view.findViewById( R.id.manufacturerName );
        holder.m_view = (ImageView)view.findViewById( R.id.manufacturerImg );
        view.setTag( holder );
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor)
    {
        throw new RuntimeException( "Not implemented yet" );
    }

    private static class ViewHolder
    {
        public TextView m_title;
        public ImageView m_view;
    }
}
