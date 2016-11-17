/*
    Clase para trabajar la clase de datos
 */
package app.rojoyazul.com.acceso_a_datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * Created by Moises on 14/11/2016.
 */

public class PeopleHelper extends SQLiteOpenHelper {

    //nombre y version de la base de datos
    private static final String DATA_BASE_NAME = "people_v1.db";
    private static final int DATA_BASE_VERSION = 1;

    //definicion de los tipos de datos de las tablas
    private static final String TEXT_TIPE= "TEXT";
    private static final String INTEGER_TIPE= "INTEGER";

    //esta es la sentencia para crear la tabla Persona
    private static final String SQL_CREATE_TABLE_PERSONA = "CREATE TABLE "+ Contrato.TABLE_NAME +
            "( " + Contrato._ID + " " + INTEGER_TIPE + " PRIMARY KEY, " +
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
        //aqui se crea la base datos, aqui se ejecutan las consultas de creacin
        db.execSQL(SQL_CREATE_TABLE_PERSONA);
    }//fin del metodo

    /**
     * El metodo es para insertar registros en la tabla persona, pasando los parametros nombre y edad
     * para ser guardado en la base de datos.
     * @param nombre valor de la columna nombre
     * @param edad valor del campo edad
     * @return verdadero si se inserto, falso si hubo error
     */
    public boolean InsertarRegistro(String nombre, int edad){
        //primero debemos obtener la base de datos en modo escritura
        ContentValues values = new ContentValues();
        values.put(Contrato.NOMBRE, nombre);//para agregar los valores a insertar en el metodo insert
        values.put(Contrato.EDAD, edad);
        long resultado = (long) this.getWritableDatabase().insert(Contrato.TABLE_NAME, null,values);

        return resultado != -1; //si el resultado es diferente de -1 retorno verdadero
    }//fin del metodo

    /**
     * El metodo lista los registros en la consala
     */
    public void ListarRegistros(){
        //primero debemos obtener la base de datos en modo lectura
        SQLiteDatabase database = this.getReadableDatabase();

        //arreglo de cadenas con los nombre de las columnas de la base de datos
        String [] columnas = {Contrato._ID, Contrato.NOMBRE, Contrato.EDAD};

        //variable para almacenar los resultados de la base de datos
        Cursor cursor;

        //consulta para exraer los datos de las columnas
        cursor = database.query(Contrato.TABLE_NAME, columnas, null, null, null, null, null, null);

        //recorremos todas las filas recuperadas
        while(cursor.moveToNext()){
            String nombre = cursor.getString(1);
            int edad = cursor.getInt(2);

            Log.d("Filas", "Nombre: " + nombre + " Edad: " + edad + "\n");
        }//fin de while

        cursor.close();
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
