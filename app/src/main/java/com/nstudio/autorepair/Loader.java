package com.nstudio.autorepair;

import org.w3c.dom.Document;

import java.util.Map;

/**
 * Created by noktigula on 07.10.14.
 */
public interface Loader
{
	public Document load(Map<String, String> params) throws Exception;
}
