package com.nstudio.autorepair;

import org.w3c.dom.Document;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * Created by noktigula on 07.10.14.
 */
public class ValueParser implements XmlParser
{
	@Override
	public List<String> parse( InputStream stream ) throws Exception
	{
		XmlPullParserFactory xppFactory = XmlPullParserFactory.newInstance();
		xppFactory.setNamespaceAware( true );

		XmlPullParser xpp = xppFactory.newPullParser();
		xpp.setInput( stream, "UTF-8" );
		int currentTag = xpp.getEventType();
		while(currentTag != XmlPullParser.END_DOCUMENT)
		{
			//if (currentTag == XmlPullParser.)
		}
	}
}
