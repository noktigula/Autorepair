package com.nstudio.autorepair;

import java.util.Map;

/**
 * Created by noktigula on 09.10.14.
 */
public interface Accumulator<T>
{
	public void put(String key, T value);
    public Map<String, T> getAccumulated();
    public void remove(String key);
}
