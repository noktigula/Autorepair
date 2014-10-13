package com.nstudio.autorepair;

import android.os.AsyncTask;

import java.io.InputStream;
import java.util.List;

/**
 * Created by noktigula on 07.10.14.
 */
public class LoadListItemsTask extends AsyncTask<String, Void, List<String>>
{
	private static final String TAG = LoadListItemsTask.class.getName();

	private Logger m_logger;
	private Loader m_loader;
	private XmlParser m_parser;
	private LoadListener m_loadListener;

	public LoadListItemsTask( Logger logger, Loader loader, XmlParser parser, LoadListener loadListener )
	{
		m_logger = logger;
		m_loader = loader;
		m_parser = parser;
		m_loadListener = loadListener;
		ArgumentChecker.CheckArgs( m_logger, m_loader, m_parser, m_loadListener );
	}

	@Override
	protected void onPreExecute()
	{
		m_loadListener.onLoadBegins();
	}

	@Override
	protected List<String> doInBackground( String... params )
	{
		try
		{
			InputStream inputStream = m_loader.load(params);
			return m_parser.parse( inputStream );
		}
		catch( Exception err )
		{
			m_logger.log( TAG, err.getMessage(), Logger.LEVEL.ERROR );
			return null;
		}
	}

	@Override
	protected void onPostExecute( List<String> loadedValues )
	{
		m_loadListener.onLoadFinished( loadedValues );
	}
}
