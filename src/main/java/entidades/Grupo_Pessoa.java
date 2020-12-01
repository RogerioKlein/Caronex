/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author roger
 */
@Entity
@Table(name = "grupo_pessoa")

public class Grupo_Pessoa implements Serializable {

    @Id
    @JoinColumn(name = "id_grupo")
    private int id_grupo;

    @Id
    @JoinColumn(name = "id_pessoa")
    private int id_pessoa;

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    @Override
    public String toString() {
        return "Grupo_Pessoa{" + "id_grupo=" + id_grupo + ", id_pessoa=" + id_pessoa + '}';
    }

}
