package com.nstudio.autorepair;

/**
 * Created by noktigula on 07.10.14.
 */
public class ArgumentChecker
{
	public static void CheckArgs(Object... args)
	{
		for ( Object arg : args)
		{
			if (arg == null)
			{
				throw new IllegalArgumentException( "Invalid argument specified" );
			}
		}
	}
}
