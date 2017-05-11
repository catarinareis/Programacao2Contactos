package pt.ipleiria.estg.dei.tutoriaisandroid.contactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import pt.ipleiria.estg.dei.tutoriaisandroid.contactos.modelo.Contacto;
import pt.ipleiria.estg.dei.tutoriaisandroid.contactos.modelo.GestorContactos;

public class MainActivity extends AppCompatActivity {

    private static final int ADDCONTACT = 1;
    public static final String CONTACTO = "CONTACTO";

    private GestorContactos gestor;

    private TextView textViewContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestor = new GestorContactos();

        textViewContactos = (TextView) findViewById(R.id.textViewContactos);

        textViewContactos.setText(gestor.toString());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuAddContact:
                Intent intent = ContactDetailsActivity.createIntent(this);
                startActivityForResult(intent, ADDCONTACT);
                return true;
            case R.id.menuSearch:
                intent = SearchActivity.createIntent(this, gestor);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ADDCONTACT && resultCode == RESULT_OK){
            Contacto contacto = (Contacto) data.getSerializableExtra(CONTACTO);

            gestor.add(contacto);

            textViewContactos.setText(gestor.toString());
        }
    }
}
