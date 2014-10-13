package com.nstudio.autorepair;

import org.w3c.dom.Document;

import java.io.InputStream;
import java.util.List;

/**
 * Created by noktigula on 07.10.14.
 */
public interface XmlParser
{
	public List<String> parse(InputStream stream) throws Exception;
}
