/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto_studio_de_danca.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 
 */
@Entity
@Table(name="tb_modalidade")
public class Modalidade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "modalidade_id")
    private Integer id;
    
    @Column(nullable = false, length = 155, name = "modalidade_descricao")
    private String descricao;

    //    Validação do Mapeamento Bidirecional: Garantir que o mapeamento @OneToMany em Professor 
//    e @ManyToOne em Modalidade estejam corretamente configurados para refletir o relacionamento bidirecional.
    @ManyToOne
    @JoinColumn(name="modalidade_professor")
    private Professores professor;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Professores getProfessor() {
        return professor;
    }

    public void setProfessor(Professores professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return id + ": " + descricao;
    }
}