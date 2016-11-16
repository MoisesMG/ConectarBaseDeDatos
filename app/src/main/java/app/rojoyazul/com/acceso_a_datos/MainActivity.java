package app.rojoyazul.com.acceso_a_datos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PeopleHelper helper = new PeopleHelper(this);
        helper.InsertarRegistro("Juan", 21);
        helper.InsertarRegistro("Moises", 19);
        helper.InsertarRegistro("Travis", 33);
    }//fin del metodo
}//fin de la clase
