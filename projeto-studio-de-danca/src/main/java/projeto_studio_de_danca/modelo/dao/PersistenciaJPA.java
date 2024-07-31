/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto_studio_de_danca.modelo.dao;

import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import projeto_studio_de_danca.modelo.Modalidade;

/**
 *
 * @author loren
 */
public class PersistenciaJPA implements InterfacePersistencia {
    
    public EntityManagerFactory factory;    //fabrica de gerenciadores de entidades
    public EntityManager entity;            //gerenciador de entidades JPA

    public PersistenciaJPA(){
        
        //parametro: é o nome da unidade de persistencia (Persistence Unit)
        factory = Persistence.createEntityManagerFactory("teste_projeto-studio-de-danca_jar_1.0PU");
        entity = factory.createEntityManager();        
    }
    
    @Override
    public Boolean conexaoAberta() {
        
        return entity.isOpen();   
    }

    @Override
    public void fecharConexao() {
        
        entity.close();        
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
       
        return entity.find(c, id);//encontra um determinado registro              
    }

    @Override
    public void persist(Object o) throws Exception {
        
        entity.getTransaction().begin();// abrir a transacao.
        entity.persist(o); //realiza o insert ou update.
        entity.getTransaction().commit(); //comita a transacao (comando sql)                
    }

    @Override
    public void remover(Object o) throws Exception {
        
        entity.getTransaction().begin();// abrir a transacao.
        entity.remove(o); //realiza o delete
        entity.getTransaction().commit(); //comita a transacao (comando sql)                
    }
   
     public List<Modalidade> getModalidades() {
            return entity.createQuery("SELECT m FROM Modalidade m", Modalidade.class).getResultList();
    }
}
