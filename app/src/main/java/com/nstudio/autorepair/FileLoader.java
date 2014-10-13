package com.nstudio.autorepair;

import org.w3c.dom.Document;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by noktigula on 09.10.14.
 */
public class FileLoader implements Loader
{
	@Override
	public Document load( Map<String, String> params ) throws Exception
	{
		String path = preparePath( params );
		InputStream stream = new BufferedInputStream( new FileInputStream( path ) );
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse( stream );
		stream.close();
		return doc;
	}

	private String preparePath(Map<String, String> params)
	{
		StringBuilder pathBuilder = new StringBuilder( "./" );
		if (!params.containsKey( Config.KEY_MANUFACTURER ))
		{
			throw new IllegalArgumentException( "Manufacturer not specified" );
		}

		pathBuilder.append( params.get( Config.KEY_MANUFACTURER ) );
		appendPath( params, Config.KEY_MODEL, pathBuilder );
		appendPath( params, Config.KEY_YEAR, pathBuilder );

		return pathBuilder.toString();
	}

	private void appendPath( Map<String, String> params, String key, StringBuilder receiver )
	{
		if (!params.containsKey( key )) return;

		receiver.append( "/" );
		receiver.append( params.get( key ) );
	}
}
