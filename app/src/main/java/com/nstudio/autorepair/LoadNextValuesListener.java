package com.nstudio.autorepair;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

/**
 * Created by noktigula on 07.10.14.
 */
public class LoadNextValuesListener implements AdapterView.OnItemSelectedListener
{
	private static final String TAG = LoadNextValuesListener.class.getName();
	private Logger m_logger;
	private String m_key;
	private List<Spinner> m_nexts;
	private Accumulator<String> m_valueAccumulator;
	private Loader m_loader;
	private XmlParser m_parser;
	private Context m_context;

	public LoadNextValuesListener( Context context, List<Spinner> nexts, String key, Accumulator<String> valueAccumulator,
								   Loader loader, XmlParser parser, Logger logger )
	{
		m_context = context;
		m_nexts = nexts;
		m_key = key;
		m_valueAccumulator = valueAccumulator;
		m_loader = loader;
		m_logger = logger;
		m_parser = parser;
		ArgumentChecker.CheckArgs(m_nexts, m_key, m_valueAccumulator, m_loader, m_logger, m_parser, m_context);
	}

	@Override
	public void onItemSelected( AdapterView<?> parent, View view, int position, long id )
	{
		//TODO all that stuff should be in derived class
		for (Spinner next : m_nexts)
		{
			next.setAdapter( null );
			next.setEnabled( false );
		}

		try
		{
			m_valueAccumulator.put( m_key, ( String ) parent.getItemAtPosition( position ) );
			List<String> values = m_parser.parse(m_loader.load( m_valueAccumulator.getAccumulated()));
			Spinner directNext = m_nexts.get( 0 );
			directNext.setAdapter( new ArrayAdapter<String>( m_context, android.R.layout.simple_spinner_item, android.R.id.text1, values) );
			directNext.setEnabled( true );
		}
		catch( Exception err )
		{
			m_logger.log( TAG, err.getMessage(), Logger.LEVEL.ERROR );
		}
	}

	@Override
	public void onNothingSelected( AdapterView<?> parent )
	{
	}
}
