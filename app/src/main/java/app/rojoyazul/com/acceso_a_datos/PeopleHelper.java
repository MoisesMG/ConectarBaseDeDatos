/*
    Clase para trabajar la clase de datos
 */
package app.rojoyazul.com.acceso_a_datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Moises on 14/11/2016.
 */

public class PeopleHelper extends SQLiteOpenHelper {
    private static final String DATA_BASE_NAME = "people.db";
    private static final int DATA_BASE_VERSION = 1;

    //definicion de los tipos de datos de las tablas
    private static final String TEXT_TIPE= "TEXT";
    private static final String INTEGER_TIPE= "INTEGER";

    //esta es la sentencia para crear la tabla Persona
    private static final String SQL_CREATE_TABLE = "CREATE TABLE "+ Contrato.TABLE_NAME +
            "(" + Contrato._ID + " " + INTEGER_TIPE + "PRIMARY KEY, " +
            Contrato.NOMBRE + " " + TEXT_TIPE  + " ," +
            Contrato.EDAD + " " + INTEGER_TIPE +
            ");";


    /*el contexto es el lugar donde se almacena la aplicacion con colores, estilos, etc para que la base de datos
    * sepa a que aplicaicon pertenece, SqliteOpenHelper ya tiene un cursor por defecto por eso se pase null en el
    * contructor*/
    public PeopleHelper(Context context){
        super(context, DATA_BASE_NAME, null, DATA_BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //aqui se crea la base datos
    }//fin del metodo

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }//fin del metodo

    //definicion de clase interna
    private class Contrato implements BaseColumns{
        //aqui se definen las constantes para las columnas. La case BaseColumns ya incluye una interface
        //con el campo id
        static final String TABLE_NAME = "Persona";
        static final String NOMBRE = "nombre";
        static final String EDAD = "edad";
    }//fin de la clase interna
}//fin de la clase
