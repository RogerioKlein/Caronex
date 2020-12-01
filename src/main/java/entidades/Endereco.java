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
@Table(name = "endereco")

public class Endereco implements Serializable {

    private int id_end;

    private int numero;

    private String logradouro;

    private String complemento;

    private String bairro;

    private String status;

    private int cidade_id_cid;

    private int cep;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_end")
    public int getId_end() {
        return id_end;
    }

    public void setId_end(int id_end) {
        this.id_end = id_end;
    }

    @Column(name = "cep")
    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    @Column(name = "numero")
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Column(name = "logradouro")
    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    @Column(name = "complemento")
    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Column(name = "bairro")
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "cidade_id_cid")
    public int getCidade_id_cid() {
        return cidade_id_cid;
    }

    public void setCidade_id_cid(int cidade_id_cid) {
        this.cidade_id_cid = cidade_id_cid;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id_end;
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Endereco other = (Endereco) obj;
        if (this.id_end != other.id_end) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id_end=" + id_end + ", numero=" + numero + ", logradouro=" + logradouro + ", complemento=" + complemento + ", bairro=" + bairro + ", status=" + status + ", cidade_id_cid=" + cidade_id_cid + ", cep=" + cep + '}';
    }
    
}
