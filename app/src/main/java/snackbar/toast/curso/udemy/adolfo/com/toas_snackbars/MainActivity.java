package snackbar.toast.curso.udemy.adolfo.com.toas_snackbars;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void crearToas(){
        //para crear un toas se necesita llamar su metodo makeText
        //que ide los parametros siguientes:
        //Toas.makeText(contexto,texto que se ostrara en el toas,duracion del toast).show()
        Toast mToast = Toast.makeText(getApplicationContext(),"Hola, soy un toast!!",Toast.LENGTH_SHORT);
        //si queremos cambiar su color de fondo, tenemos que obtener su vista primero
        View toasView = mToast.getView();
        //ya que teemos su vista, le asignamos un backgroundColor
        toasView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimaryDark));
        //y lo mostramos
        mToast.show();
    }

    public void crearSnackBarYToast(View v){
        //para hacer un snackbar, es necesario crear un objeto Snackbar
        //llamar su clase make y pasarle de matarmetros
        //(vista, en este caso la vista del textview,el texto dentro del snackbar,y su duracion)
        Snackbar mSnack = Snackbar.make(v,"Hola!! soy un snackbar",Snackbar.LENGTH_SHORT);
        //si queremos cambiar el background color del snackbar, es necesario tomar su vista
        //despues de tomar su lista, asignarle un backgroundColor y asignarle un (contexto,color)
        mSnack.getView().setBackgroundColor(ContextCompat.getColor(this,R.color.colorAccent));
        //le podemos asignar una accion, esta incluye un clicklistener, lo mandamos a llamar y al presionar su accion
        //regresara la accion progrmada, en este caso un toast
        //a la misma accion le asignaremos un color a su texto
        mSnack.setActionTextColor(ContextCompat.getColor(MainActivity.this,R.color.colorPrimary));
        mSnack.setAction("accion", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mandamos a llamar el metodo que creara el toast
                crearToas();
            }
        });
        //despues se manda a llamar el metodo show para mostrar el snackbar
        mSnack.show();
    }

}
