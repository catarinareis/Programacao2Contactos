package pt.ipleiria.estg.dei.tutoriaisandroid.contactos.modelo;

import java.io.Serializable;
import java.util.LinkedList;

public class GestorContactos implements Serializable{

    private LinkedList<Contacto> contactos;

    public GestorContactos() {
        this.contactos = new LinkedList<>();

        addInitialExamples();
    }

    private void addInitialExamples() {
        contactos.add(new Contacto(123,"Ana Silva"));
        contactos.add(new Contacto(456,"João Pereira"));
        contactos.add(new Contacto(789,"Claudemira Goncalves"));
        contactos.add(new Contacto(135,"Raquel Mira"));
        contactos.add(new Contacto(246,"Miguel Fernandes"));
    }

    public void add(Contacto contacto){
        contactos.add(contacto);
    }

    public LinkedList<Contacto> getContactos(){
        return new LinkedList<>(contactos);
    }

    public Contacto getContacto(int position){
        return contactos.get(position);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(Contacto contacto:contactos){
            sb.append(contacto).append("\n");
        }

        return sb.toString();
    }

    public LinkedList<Contacto> pesquisar(String text2Search) {
        LinkedList<Contacto> resultados = new LinkedList<>();

        for(Contacto contacto:contactos){

            if (contacto.getNome().contains(text2Search) ||
                    String.valueOf(contacto.getID()).contains(text2Search)) {
                resultados.add(contacto);
            }
        }

        return resultados;
    }
}
