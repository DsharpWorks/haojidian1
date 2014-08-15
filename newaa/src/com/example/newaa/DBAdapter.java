package com.example.newaa;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
public class DBAdapter
{
public static final String KEY_ROWID = "_id";
public static final String KEY_DATA="data";
public static final String KEY_NAME = "name";
public static final String KEY_ADDRESS = "address";
public static final String KEY_MESSAGE = "message";
private static final String TAG = "DBAdapter";
private static final String DATABASE_NAME = "books";
private static final String DATABASE_TABLE = "titles";
private static final int DATABASE_VERSION = 1;
private static final String DATABASE_CREATE ="create table titles (_id integer primary key autoincrement, "+ "name text not null, address text not null, "+ "message text not null);";
private final Context context;
private DatabaseHelper DBHelper;
private SQLiteDatabase db;
public DBAdapter(Context ctx)
{
this.context = ctx;
DBHelper = new DatabaseHelper(context);
}
private static class DatabaseHelper extends SQLiteOpenHelper
{
DatabaseHelper(Context context)
{
super(context, DATABASE_NAME, null, DATABASE_VERSION);
}
@Override
public void onCreate(SQLiteDatabase db)
{
db.execSQL(DATABASE_CREATE);
}
@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion,int newVersion)
{
Log.w(TAG, "Upgrading database from version " + oldVersion+ " to "+ newVersion + ", which will destroy all old data");
db.execSQL("DROP TABLE IF EXISTS titles");
onCreate(db);
}
}


public DBAdapter open() throws SQLException
{
db = DBHelper.getWritableDatabase();
return this;
}


public void close()
{
DBHelper.close();
}


public long insertTitle(String name, String address, String message)
{
ContentValues initialValues = new ContentValues();
initialValues.put(KEY_NAME, name);
initialValues.put(KEY_ADDRESS, address);
initialValues.put(KEY_MESSAGE, message);
return db.insert(DATABASE_TABLE, null, initialValues);
}


public boolean deleteTitle(long rowId)
{
return db.delete(DATABASE_TABLE, KEY_ROWID +"=" + rowId, null) > 0;
}


public Cursor getAllTitles()
{
return db.query(DATABASE_TABLE, new String[] {KEY_ROWID,KEY_NAME,KEY_ADDRESS,KEY_MESSAGE},
null,
null,
null,
null,
null);
}


public Cursor getTitle(long rowId) throws SQLException
{
Cursor mCursor =
db.query(true, DATABASE_TABLE, new String[] {KEY_ROWID,KEY_NAME,KEY_ADDRESS,KEY_MESSAGE},KEY_ROWID + "=" + rowId,
null,
null,
null,
null,
null);
if (mCursor != null) {
mCursor.moveToFirst();
}
return mCursor;
}


public boolean updateTitle(long rowId, String name,String address, String message)
{
ContentValues args = new ContentValues();
args.put(KEY_NAME, name);
args.put(KEY_ADDRESS, address);
args.put(KEY_MESSAGE, message);
return db.update(DATABASE_TABLE, args,
KEY_ROWID + "=" + rowId, null) > 0;
}
}
