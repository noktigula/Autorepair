package com.nstudio.autorepair;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by noktigula on 09.10.14.
 */
public class ValueAccumulator implements Accumulator<String>
{
	private Map<String, String> m_params = new HashMap<String, String>(  );

	@Override
	public void put(String key, String value)
	{
		m_params.put(key, value);
	}

	@Override
	public Map<String, String> getAccumulated()
	{
		return m_params;
	}

	@Override
	public void remove( String key )
	{
		if (Config.KEY_MANUFACTURER.equals( key ))
		{
			m_params.clear();
		}
		if (Config.KEY_MODEL.equals( key ))
		{
			m_params.remove( Config.KEY_MODEL );
			if (m_params.containsKey( Config.KEY_YEAR ))
			{
				m_params.remove( Config.KEY_YEAR );
			}
		}
		if (Config.KEY_YEAR.equals( key ))
		{
			m_params.remove(key);
		}
	}
}
