/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Rogério H. Klein <rhklein@universo.univates.br>
 */
@Entity
@Table(name = "resumo_viagens")
public class ResumoViagens implements Serializable {

    private int id_r;

    private int ano;

    private int mes;

    private double total_valores;

    private double total_kms;

    private double total_horas;

    private int num_viagens;

    public ResumoViagens() {
    }

    public ResumoViagens(int id_r, int ano, int mes, double total_valores, double total_kms, double total_horas) {
        this.id_r = id_r;
        this.ano = ano;
        this.mes = mes;
        this.total_valores = total_valores;
        this.total_kms = total_kms;
        this.total_horas = total_horas;
    }

    @Id
    @Column(name = "id_r")
    public int getId_r() {
        return id_r;
    }

    public void setId_r(int id_r) {
        this.id_r = id_r;
    }

    @Column(name = "ano")
    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Column(name = "mes")
    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    @Column(name = "total_valores")
    public double getTotal_valores() {
        return total_valores;
    }

    public void setTotal_valores(double total_valores) {
        this.total_valores = total_valores;
    }

    @Column(name = "total_kms")
    public double getTotal_kms() {
        return total_kms;
    }

    public void setTotal_kms(double total_kms) {
        this.total_kms = total_kms;
    }

    @Column(name = "total_horas")
    public double getTotal_horas() {
        return total_horas;
    }

    public void setTotal_horas(double total_horas) {
        this.total_horas = total_horas;
    }
    @Column(name = "num_viagens")
    public int getNum_viagens() {
        return num_viagens;
    }

    public void setNum_viagens(int num_viagens) {
        this.num_viagens = num_viagens;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
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
        final ResumoViagens other = (ResumoViagens) obj;
        return this.id_r == other.id_r;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id_r;
        return hash;
    }

}
