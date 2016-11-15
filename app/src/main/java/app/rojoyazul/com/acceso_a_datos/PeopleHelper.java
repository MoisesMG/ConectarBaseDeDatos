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
    private static final String DATA_BASE_NAME = "people.db";
    private static final int DATA_BASE_VERSION = 1;

    /*el contexto es el lugar donde se almacena la aplicacion con colores, estilos, etc para que la base de datos
    * sepa a que aplicaicon pertenece, SqliteOpenHelper ya tiene un cursor por defecto por eso se pase null en el
    * contructor*/
    public PeopleHelper(Context context){
        super(context, DATA_BASE_NAME, null, DATA_BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
