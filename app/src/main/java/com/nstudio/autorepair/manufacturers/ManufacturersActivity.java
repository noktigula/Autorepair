package com.nstudio.autorepair.manufacturers;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.nstudio.autorepair.OnIdentificableItemSelectedListener;
import com.nstudio.autorepair.R;

/**
 * Created by noktgula on 15.10.2014.
 */
public class ManufacturersActivity extends FragmentActivity implements OnIdentificableItemSelectedListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_manufacturer );
    }

    public OnIdentificableItemSelectedListener getListener()
    {
        return this;
    }

    @Override
    public void onIdentificableItemSelected(int itemId)
    {

    }
}
