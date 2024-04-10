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
public class Contrato {
    private Integer id;
    private Calendar dataInicio;
    private Double valorDesconto;
    private Alunos aluno;
    private Collection<itensContrato> itensContrato;
    private FormaPgto formaPgto;

    public Contrato() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public FormaPgto getFormaPgto() {
        return formaPgto;
    }

    public void setFormaPgto(FormaPgto formaPgto) {
        this.formaPgto = formaPgto;
    }

    public Collection<itensContrato> getItensContrato() {
        return itensContrato;
    }

    public void setItensContrato(Collection<itensContrato> itensContrato) {
        this.itensContrato = itensContrato;
    }

    public Alunos getAluno() {
        return aluno;
    }

    public void setAluno(Alunos aluno) {
        this.aluno = aluno;
    }
}
