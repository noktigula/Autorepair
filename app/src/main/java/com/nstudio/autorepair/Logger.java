package com.nstudio.autorepair;

/**
 * Created by noktigula on 07.10.14.
 */
public interface Logger
{
	public enum LEVEL
	{
		VERBOSE,
		DEBUG,
		INFO,
		WARNING,
		ERROR,
		ASSERT
	};

	public void log(String tag, String message, LEVEL level);
}
