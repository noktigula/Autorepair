package com.nstudio.autorepair;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import java.util.Arrays;
import java.util.List;


/**
 * Created by noktigula on 08.10.14.
 */
public class SelectCarFragment extends Fragment
{
	private static final String TAG = SelectCarFragment.class.getName();

	private Spinner m_manufacturers;
	private Spinner m_models;
	private Spinner m_years;

	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
	{
		View view = inflater.inflate( R.layout.fragment_select_car, container, false );
		m_manufacturers = (Spinner)view.findViewById( R.id.spinnerManufacturers );
		m_models = (Spinner)view.findViewById( R.id.spinnerModels );
		m_years = (Spinner)view.findViewById( R.id.spinnerYears );

		Accumulator<String> selectedValueAccumulator = new ValueAccumulator();

		Loader loader = new FileLoader();
		XmlParser parser = new ValueParser();
		Logger logger = new DummyLogger();
		Context context = getActivity().getApplicationContext();

		List<Spinner> nextForFirst = Arrays.asList(m_models, m_years);
		m_manufacturers.setOnItemSelectedListener(
				new LoadNextValuesListener( context, nextForFirst, Config.KEY_MANUFACTURER,
											selectedValueAccumulator, loader, parser, logger ) );

		List<Spinner> nextForSecond = Arrays.asList( m_years );
		m_models.setOnItemSelectedListener(
				new LoadNextValuesListener(context, nextForSecond, Config.KEY_YEAR,
										   selectedValueAccumulator, loader, parser, logger) );

		//m_years.setOnItemSelectedListener(  );

		return view;
	}
}
