/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto_studio_de_danca.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author loren
 */

@Entity
@Table(name = "tb_pessoas")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoas implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false, length = 155)
    private String nome;
    
    @Column (nullable = false, length = 20)
    private String fone;
    
    @Column (nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataAniver;
    
    @Column (nullable = false, length = 155)
    private String email;
    
    @Column (nullable = false, length = 255)
    private String endereco;

    public Pessoas() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public Calendar getDataAniver() {
        return dataAniver;
    }

    public void setDataAniver(Calendar dataAniver) {
        this.dataAniver = dataAniver;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
