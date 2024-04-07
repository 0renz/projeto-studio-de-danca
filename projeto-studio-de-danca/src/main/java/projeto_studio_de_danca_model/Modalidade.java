package projeto_studio_de_danca_model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_modalidade")
public class Modalidade implements Serializable {

    @Id
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String descricao;

    public Modalidade() {
    }

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
}
