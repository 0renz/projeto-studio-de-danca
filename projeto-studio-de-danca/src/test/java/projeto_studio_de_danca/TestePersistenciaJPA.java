package projeto_studio_de_danca;

import java.util.Calendar;
import java.util.Date;
import org.junit.Test;
import projeto_studio_de_danca.modelo.Alunos;
import projeto_studio_de_danca.modelo.Contrato;
import projeto_studio_de_danca.modelo.FormaPgto;
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
            modalidade_1.setId(2);
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
    
    @Test
    public void testeAlunoJPA() throws Exception {
        PersistenciaJPA jpa = new PersistenciaJPA();
        if (jpa.conexaoAberta()) {
            System.out.println("conectou no BD via jpa ...");
            Alunos aluno_1 = new Alunos();
            aluno_1.setId(1);
            aluno_1.setNome("Adilso");
            aluno_1.setFone("aaaaaaaaaaaaa");
            aluno_1.setDataAniver(Calendar.getInstance());
            aluno_1.setEmail("aaaaaaaaaaaaaa@aaaaaa.com");
            aluno_1.setEndereco("rua aa  aa 131");
            aluno_1.setDataInicio(Calendar.getInstance());
            aluno_1.setDataPgto(1);
            
            jpa.persist(aluno_1);
            System.out.println("Aluno:  " + aluno_1.getId() + " inserido no banco");
            
            Contrato contrato_1 = new Contrato();
            contrato_1.setId(1);
            contrato_1.setValorDesconto(15.00);
            contrato_1.setAluno(aluno_1);
            contrato_1.setFormaPgto(FormaPgto.PIX);
            System.out.println("Contrato: " + contrato_1.getId() + " inserido no banco");
            jpa.fecharConexao();
        } else {
            System.out.println("nao conectou no BD ...");

        }
    }
}    

   
