/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author roger
 */
@Entity
@Table(name = "viagens")

public class Viagem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_viagem")
    private int id_viagem;

    @Column(name = "data_viagem")
    private Date data_viagem;

    @Column(name = "valor_viagem")
    private Double valor_viagem;

    @Column(name = "km_viagem")
    private Double km_viagem;

    @Column(name = "horas_viagem")
    private Date horas_viagem;

    @Column(name = "id_veiculo")
    private int id_veiculo;

    @Column(name = "id_motorista")
    private int id_motorista;

    @Column(name = "id_grupo")
    private int id_grupo;

    @Column(name = "status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId_viagem() {
        return id_viagem;
    }

    public void setId_viagem(int id_viagem) {
        this.id_viagem = id_viagem;
    }

    public Date getData_viagem() {
        return data_viagem;
    }

    public void setData_viagem(Date data_viagem) {
        this.data_viagem = data_viagem;
    }

    public Double getValor_viagem() {
        return valor_viagem;
    }

    public void setValor_viagem(Double valor_viagem) {
        this.valor_viagem = valor_viagem;
    }

    public Double getKm_viagem() {
        return km_viagem;
    }

    public void setKm_viagem(Double km_viagem) {
        this.km_viagem = km_viagem;
    }

    public Date getHoras_viagem() {
        return horas_viagem;
    }

    public void setHoras_viagem(Date horas_viagem) {
        this.horas_viagem = horas_viagem;
    }

    public int getId_veiculo() {
        return id_veiculo;
    }

    public void setId_veiculo(int id_veiculo) {
        this.id_veiculo = id_veiculo;
    }

    public int getId_motorista() {
        return id_motorista;
    }

    public void setId_motorista(int id_motorista) {
        this.id_motorista = id_motorista;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

}
