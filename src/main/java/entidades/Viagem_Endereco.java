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
@Table(name = "viagens_endereco")

public class Viagem_Endereco implements Serializable {

    @Id
    @Column(name = "viagens_id_viagem")
    private int viagens_id_viagem;

    @Id
    @Column(name = "endereco_id_end")
    private int endereco_id_end;

    @Column(name = "descricao")
    private String descricao;

    public int getViagens_id_viagem() {
        return viagens_id_viagem;
    }

    public void setViagens_id_viagem(int viagens_id_viagem) {
        this.viagens_id_viagem = viagens_id_viagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEndereco_id_end() {
        return endereco_id_end;
    }

    public void setEndereco_id_end(int endereco_id_end) {
        this.endereco_id_end = endereco_id_end;
    }
}
