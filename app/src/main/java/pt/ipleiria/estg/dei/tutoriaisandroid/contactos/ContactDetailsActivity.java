package pt.ipleiria.estg.dei.tutoriaisandroid.contactos;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import pt.ipleiria.estg.dei.tutoriaisandroid.contactos.modelo.Contacto;
import pt.ipleiria.estg.dei.tutoriaisandroid.contactos.modelo.GestorContactos;

public class ContactDetailsActivity extends AppCompatActivity {
    public static final String GESTOR = "GESTOR";
    public static final String POSCONTACTO = "POSICAO";

    private EditText editTextID;
    private EditText editTextName;

    private GestorContactos gestor;
    private Contacto contacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        editTextID = (EditText) findViewById(R.id.editTextID);
        editTextName = (EditText) findViewById(R.id.editTextName);

        gestor = (GestorContactos) getIntent().getSerializableExtra(GESTOR);

        contacto = gestor.getContacto(getIntent().getIntExtra(POSCONTACTO, -1));

        if (contacto != null){
            editTextID.setText(contacto.getID()+"");
            editTextName.setText(contacto.getNome());
        }

    }

    public void onClickGuardar(View view) {
        int id = Integer.parseInt(editTextID.getText().toString());
        String nome = editTextName.getText().toString();

        Intent data = new Intent();
        data.putExtra(MainActivity.CONTACTO, new Contacto(id, nome));

        setResult(RESULT_OK, data);
        finish();
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, ContactDetailsActivity.class);
    }


    public static Intent createIntent(Context context, GestorContactos gestorContactos,
                                      int indice) {
        Intent intent = new Intent(context, ContactDetailsActivity.class);
        intent.putExtra(GESTOR, gestorContactos);
        intent.putExtra(POSCONTACTO, indice);
        return intent;
    }
}
