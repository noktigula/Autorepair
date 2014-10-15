package com.nstudio.autorepair.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by noktgula on 15.10.2014.
 */
public class AutoProvider extends ContentProvider
{
	private static final Map<String, String> m_manufacturersProjectionMap = new HashMap<String, String>(  );
	private static final Map<String, String> m_modelsProjectionMap = new HashMap<String, String>(  );
	private static final Map<String, String> m_imagesProjectioNMap = new HashMap<String, String>(  );

	static
	{
		m_manufacturersProjectionMap.put( AutoContract.Manufacturers._ID, AutoContract.Manufacturers._ID );
		m_manufacturersProjectionMap.put( AutoContract.Manufacturers._COUNT, AutoContract.Manufacturers._COUNT );
		m_manufacturersProjectionMap.put( AutoContract.Manufacturers.TITLE, AutoContract.Manufacturers.TITLE );
		m_manufacturersProjectionMap.put( AutoContract.Manufacturers.ID_IMAGE, AutoContract.Manufacturers.ID_IMAGE );

		m_modelsProjectionMap.put( AutoContract.Models._ID, AutoContract.Models._ID );
		m_modelsProjectionMap.put( AutoContract.Models._COUNT, AutoContract.Models._COUNT );
		m_modelsProjectionMap.put( AutoContract.Models.TITLE, AutoContract.Models.TITLE );
		m_modelsProjectionMap.put( AutoContract.Models.ID_IMAGE, AutoContract.Models.ID_IMAGE );
		m_modelsProjectionMap.put( AutoContract.Models.ID_MANUFACTURER, AutoContract.Models.ID_MANUFACTURER );
		m_modelsProjectionMap.put( AutoContract.Models.YEAR, AutoContract.Models.YEAR );

		m_imagesProjectioNMap.put( AutoContract.Images._ID, AutoContract.Images._ID );
		m_imagesProjectioNMap.put( AutoContract.Images._COUNT, AutoContract.Images._COUNT );
		m_imagesProjectioNMap.put( AutoContract.Images.PATH, AutoContract.Images.PATH );
	}

	private static final UriMatcher m_uriMatcher = new UriMatcher( UriMatcher.NO_MATCH );

	private static final int MANUFACTURERS_COLLECTION = 0;
	private static final int MANUFACTURERS_ITEM = 1;

	private static final int MODELS_COLLECTION = 2;
	private static final int MODELS_ITEM = 3;

	private static final int IMAGE_COLLECTION = 4;
	private static final int IMAGE_ITEM = 5;

	static
	{
		m_uriMatcher.addURI( AutoContract.AUTHORITY, AutoContract.Manufacturers.TABLE_NAME, MANUFACTURERS_COLLECTION );
		m_uriMatcher.addURI( AutoContract.AUTHORITY, AutoContract.Manufacturers.TABLE_NAME + "/#", MANUFACTURERS_ITEM );

		m_uriMatcher.addURI( AutoContract.AUTHORITY, AutoContract.Models.TABLE_NAME, MODELS_COLLECTION );
		m_uriMatcher.addURI( AutoContract.AUTHORITY, AutoContract.Models.TABLE_NAME + "/#", MODELS_ITEM );

		m_uriMatcher.addURI( AutoContract.AUTHORITY, AutoContract.Images.TABLE_NAME, IMAGE_COLLECTION );
		m_uriMatcher.addURI( AutoContract.AUTHORITY, AutoContract.Images.TABLE_NAME + "/#", IMAGE_ITEM );
	}

	private static class DBHelper extends SQLiteOpenHelper
	{
		public DBHelper( Context context )
		{
			super( context, AutoContract.DATABASE_NAME, null, AutoContract.DATABASE_VERSION );
		}

		@Override
		public void onCreate( SQLiteDatabase db )
		{
			String queryCreateTableManufacturers = "CREATE TABLE " + AutoContract.Manufacturers.TABLE_NAME + " ( "
					+ AutoContract.Manufacturers._ID + " INTEGER PRIMARY KEY AUTO INCREMENT, "
					+ AutoContract.Manufacturers.TITLE + " TEXT NOT NULL, "
					+ AutoContract.Manufacturers.ID_IMAGE + " INTEGER)";

			String queryCreateTableModels = "CREATE TABLE " +AutoContract.Models.TABLE_NAME + " ( "
					+ AutoContract.Models._ID + " INTEGER PRIMARY KEY AUTO INCREMENT, "
					+ AutoContract.Models.TITLE + " TEXT NOT NULL, "
					+ AutoContract.Models.ID_IMAGE + " INTEGER, "
					+ AutoContract.Models.ID_MANUFACTURER + " INTEGER NOT NULL)";

			String queryCreateTableImages = "CREATE TABLE " + AutoContract.Images.TABLE_NAME + " ( "
					+ AutoContract.Images._ID + " INTEGER PRIMARY KEY AUTO INCREMENT, "
					+ AutoContract.Images.PATH + " TEXT NOT NULL)";

			db.beginTransaction();

			try
			{
				db.execSQL( queryCreateTableManufacturers );
				db.execSQL( queryCreateTableModels );
				db.execSQL( queryCreateTableImages );
				db.setTransactionSuccessful();
			}
			finally
			{
				db.endTransaction();
			}

		}

		@Override
		public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion )
		{
			throw new RuntimeException( "Unsupported yet" );
		}
	}

    @Override
    public boolean onCreate()
    {
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings2, String s2)
    {
        return null;
    }

    @Override
    public String getType(Uri uri)
    {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues)
    {
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings)
    {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings)
    {
        return 0;
    }
}
