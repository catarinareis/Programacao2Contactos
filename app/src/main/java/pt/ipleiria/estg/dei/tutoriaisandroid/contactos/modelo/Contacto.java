package pt.ipleiria.estg.dei.tutoriaisandroid.contactos.modelo;

import java.io.Serializable;

public class Contacto implements Serializable {
    private long ID;
    private String nome;

    public Contacto(long ID, String nome) {
        this.ID = ID;
        this.nome = nome;
    }

    public long getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "ID: " + ID + "\tNome: " + nome;
    }
}
