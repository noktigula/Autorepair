package com.nstudio.autorepair;

import java.util.List;

/**
 * Created by noktigula on 07.10.14.
 */
public interface LoadListener
{
	public void onLoadBegins();
	public void onLoadFinished(List<String> resuls);
}
