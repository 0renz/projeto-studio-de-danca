package projeto_studio_de_danca;

import org.junit.Test;
import projeto_studio_de_danca.modelo.dao.PersistenciaJPA;
import projeto_studio_de_danca.modelo.Modalidade;

public class TestePersistenciaJPA {
      @Test
    public void testConexaoJPA() {
        //criar um objeto do tipo PersistenciaJPA.
        PersistenciaJPA jpa = new PersistenciaJPA();
        if (jpa.conexaoAberta()) {
            System.out.println("conectou no BD via jpa ...");
            jpa.fecharConexao();
        } else {
            System.out.println("nao conectou no BD ...");

        }
    } 
    
    @Test
    public void testeModalidadeJPA() throws Exception {
        PersistenciaJPA jpa = new PersistenciaJPA();
        if (jpa.conexaoAberta()) {
            System.out.println("conectou no BD via jpa ...");
            Modalidade modalidade_1 = new Modalidade();
            modalidade_1.setId(1);
            modalidade_1.setDescricao("FitDance");
            jpa.persist(modalidade_1);
            System.out.println("Modalidade " + modalidade_1.getDescricao() + " inserida no banco");
            jpa.fecharConexao();
        } else {
            System.out.println("nao conectou no BD ...");

        }
    }
}
