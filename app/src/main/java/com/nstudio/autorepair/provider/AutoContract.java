package com.nstudio.autorepair.provider;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by noktgula on 15.10.2014.
 */
public final class AutoContract
{
    public static final String AUTHORITY = "com.nstudio.autorepair.provider";
	public static final String DATABASE_NAME = "autorepair.db";
	public static final int DATABASE_VERSION = 1;

    public static final class Manufacturers implements BaseColumns
    {
		public static final String TABLE_NAME = "Manufacturers";
		public static final Uri CONTENT_URI = Uri.parse( "content://" + AUTHORITY + "/" + TABLE_NAME );
		public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.nstudio.manufacturers";
		public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.nstudio.manufacturer";
		public static final String DEFAULT_SORT_ORDER = _ID + " ASC";

		public static final String TITLE = "Title";
		public static final String ID_IMAGE = "idImage";
	}

	public static final class Models implements BaseColumns
	{
		public static final String TABLE_NAME = "Models";
		public static final Uri CONTENT_URI = Uri.parse( "content://" + AUTHORITY + "/" + TABLE_NAME );
		public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.nstudio.models";
		public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.nstudio.model";
		public static final String DEFAULT_SORT_ORDER = _ID + " ASC";

		public static final String TITLE = "Title";
		public static final String ID_MANUFACTURER = "idManufacturer";
		public static final String YEAR = "Year";
		public static final String ID_IMAGE = "idImage";
	}

	public static final class Images implements BaseColumns
	{
		public static final String TABLE_NAME = "Images";
		public static final Uri CONTENT_URI = Uri.parse( "content://" + AUTHORITY + "/" + TABLE_NAME );
		public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.nstudio.images";
		public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.nstudio.image";
		public static final String DEFAULT_SORT_ORDER = _ID + " ASC";

		public static final String PATH = "Path";
	}
}
