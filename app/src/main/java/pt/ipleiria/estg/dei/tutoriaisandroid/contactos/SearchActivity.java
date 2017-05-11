package pt.ipleiria.estg.dei.tutoriaisandroid.contactos;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import pt.ipleiria.estg.dei.tutoriaisandroid.contactos.modelo.GestorContactos;

public class SearchActivity extends AppCompatActivity {
    public static final String GESTOR = "GESTOR";

    private EditText editTextPesquisar;
    private TextView textViewResults;

    private GestorContactos gestorContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        editTextPesquisar = (EditText) findViewById(R.id.editTextTermosPesquisa);
        textViewResults = (TextView) findViewById(R.id.textViewResults);

        gestorContactos = (GestorContactos) getIntent().getSerializableExtra(GESTOR);

    }

    public void onClickPesquisar(View view) {
        String text2Search = editTextPesquisar.getText().toString();

        String results = gestorContactos.pesquisar(text2Search);

        textViewResults.setText(results);

    }

    public static Intent createIntent(Context context, GestorContactos gestorContactos){
        Intent intent = new Intent(context, SearchActivity.class);
        intent.putExtra(GESTOR, gestorContactos);
        return intent;
    }
}
