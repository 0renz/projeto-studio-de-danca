/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto_studio_de_danca.modelo;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author loren
 */

@Entity
@Table (name = "tb_alunos")
@PrimaryKeyJoinColumn (name = "pessoa_id")
public class Alunos extends Pessoas{
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataInicio;
    
    @Column(nullable = false)
    private Integer dataPgto;
    
    public Alunos() {
    }

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Integer getDataPgto() {
        return dataPgto;
    }

    public void setDataPgto(Integer dataPgto) {
        this.dataPgto = dataPgto;
    }
}
