/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto_studio_de_danca.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * 
 * @author loren
 */

@Entity
@Table (name = "tb_itens_contrato")
public class itensContrato implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn (name = "contrato_id", nullable = false)
    private Contrato idContrato;
    
    @Id
    @ManyToOne
    @JoinColumn (name = "contrato_id", nullable = false)
    private Pacote idPacote;

    public itensContrato() {
    }

    public Contrato getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Contrato idContrato) {
        this.idContrato = idContrato;
    }

    public Pacote getIdPacote() {
        return idPacote;
    }

    public void setIdPacote(Pacote idPacote) {
        this.idPacote = idPacote;
    }
}
