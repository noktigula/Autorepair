package com.nstudio.autorepair;

import android.util.Log;

/**
 * Created by noktigula on 09.10.14.
 */
public class DummyLogger implements Logger
{
	@Override
	public void log( String tag, String message, LEVEL level )
	{
		switch (level)
		{
			case VERBOSE: Log.v( tag, message ); return;
			case DEBUG: Log.d(tag, message); return;
			case INFO: Log.i( tag, message ); return;
			case WARNING: Log.w( tag, message ); return;
			case ERROR: Log.e( tag, message ); return;
			case ASSERT: Log.d( tag, "ASSERT: " + message ); return;
		}
	}
}
