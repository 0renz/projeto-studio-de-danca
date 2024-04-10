/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto_studio_de_danca.modelo;

import java.util.Calendar;
import java.util.Collection;

/**
 *
 * @author loren
 */
public class Professores extends Pessoas{
    private Calendar dataAdmissao;
    private Collection<FolhaPagamento> folhaPagamento;
    private Collection<Modalidade> modalidades;

    public Professores() {
    }

    public Calendar getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Calendar dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Collection<FolhaPagamento> getFolhaPagamento() {
        return folhaPagamento;
    }

    public void setFolhaPagamento(Collection<FolhaPagamento> folhaPagamento) {
        this.folhaPagamento = folhaPagamento;
    }

    public Collection<Modalidade> getModalidades() {
        return modalidades;
    }

    public void setModalidades(Collection<Modalidade> modalidades) {
        this.modalidades = modalidades;
    }
}
