package projeto_studio_de_danca;

import java.util.Calendar;
import java.util.Date;
import org.junit.Test;
import projeto_studio_de_danca.modelo.dao.PersistenciaJPA;
import projeto_studio_de_danca.modelo.Modalidade;
import projeto_studio_de_danca.modelo.Pagamentos;

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
    
        @Test
    public void testePagamentosJPA() throws Exception {
        PersistenciaJPA jpa = new PersistenciaJPA();
        if (jpa.conexaoAberta()) {
            System.out.println("conectou no BD via jpa ...");
            Pagamentos pagamento_1 = new Pagamentos();
            pagamento_1.setId(1);
            pagamento_1.setDataVcto(Calendar.getInstance());
            pagamento_1.setValor(1500.14);
            pagamento_1.setDataPgto(Calendar.getInstance());
            pagamento_1.setValorPgto(1000.14);
            jpa.persist(pagamento_1);
            System.out.println("Pagamento " + pagamento_1.getId() + " inserida no banco");
            jpa.fecharConexao();
        } else {
            System.out.println("nao conectou no BD ...");

        }
    }
}
