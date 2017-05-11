package pt.ipleiria.estg.dei.tutoriaisandroid.contactos;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.LinkedList;

import pt.ipleiria.estg.dei.tutoriaisandroid.contactos.modelo.Contacto;
import pt.ipleiria.estg.dei.tutoriaisandroid.contactos.modelo.GestorContactos;

public class SearchActivity extends AppCompatActivity {
    public static final String GESTOR = "GESTOR";

    private EditText editTextPesquisar;
    private ListView listViewResults;

    private GestorContactos gestor;

    private ArrayAdapter<Contacto> adaptador;
    private LinkedList<Contacto> resultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        editTextPesquisar = (EditText) findViewById(R.id.editTextTermosPesquisa);
        listViewResults = (ListView) findViewById(R.id.listViewResults);

        gestor = (GestorContactos) getIntent().getSerializableExtra(GESTOR);

    }

    public void onClickPesquisar(View view) {
        String textoAPesquisar = editTextPesquisar.getText().toString();

        if (adaptador == null) {
            resultados = gestor.pesquisar(textoAPesquisar);
            adaptador = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1,
                    resultados);

            listViewResults.setAdapter(adaptador);
        } else {
            resultados.clear();
            resultados.addAll(gestor.pesquisar(textoAPesquisar));
            adaptador.notifyDataSetChanged();
        }
    }

    public static Intent createIntent(Context context, GestorContactos gestorContactos){
        Intent intent = new Intent(context, SearchActivity.class);
        intent.putExtra(GESTOR, gestorContactos);
        return intent;
    }
}
