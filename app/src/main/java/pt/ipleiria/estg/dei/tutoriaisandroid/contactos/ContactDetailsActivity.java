package pt.ipleiria.estg.dei.tutoriaisandroid.contactos;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import pt.ipleiria.estg.dei.tutoriaisandroid.contactos.modelo.Contacto;

public class ContactDetailsActivity extends AppCompatActivity {

    private EditText editTextID;
    private EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        editTextID = (EditText) findViewById(R.id.editTextID);
        editTextName = (EditText) findViewById(R.id.editTextName);
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

}
