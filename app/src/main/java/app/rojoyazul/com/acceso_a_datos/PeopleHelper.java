/*
    Clase para trabajar la clase de datos
 */
package app.rojoyazul.com.acceso_a_datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Moises on 14/11/2016.
 */

public class PeopleHelper extends SQLiteOpenHelper {
    public PeopleHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
