package com.nstudio.autorepair;

import android.widget.Spinner;

import org.w3c.dom.Document;

/**
 * Created by noktigula on 09.10.14.
 */
public interface ValueUploader
{
	public Document upload(String key, String value) throws Exception;
}
