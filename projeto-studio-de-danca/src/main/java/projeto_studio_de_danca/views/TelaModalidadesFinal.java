package projeto_studio_de_danca.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import projeto_studio_de_danca.modelo.Modalidade;
import projeto_studio_de_danca.modelo.dao.PersistenciaJPA;

public class TelaModalidadesFinal extends javax.swing.JFrame {

    PersistenciaJPA persistencia;

    public TelaModalidadesFinal() {
        initComponents();
        listarModalidades();
    }

    private void listarModalidades() {
        try {
            persistencia = new PersistenciaJPA();
            lstModalidades.clearSelection();
            persistencia.conexaoAberta();
            List<Modalidade> modalidades = persistencia.getModalidades();
            DefaultListModel modeloLista = new DefaultListModel<>();
            for (Modalidade modalidade : modalidades) {
                modeloLista.addElement(modalidade);
            }
            lstModalidades.setModel(modeloLista);
            persistencia.fecharConexao();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao listar modalidades: " + ex.getMessage());
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstModalidades = new javax.swing.JList<>();
        btnRemover = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Modalidades");

        btnNovo.setText("Adicionar");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lstModalidades);

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155))
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        try {
            Modalidade m = new Modalidade();
            m.setDescricao(JOptionPane.showInputDialog("Informe a descrição da modalidade: "));
            persistencia = new PersistenciaJPA();
            persistencia.conexaoAberta();
            persistencia.persist(m);
            listarModalidades();
        } catch (Exception ex) {
            Logger.getLogger(TelaModalidadesFinal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        Modalidade modalidadeSelecionada = lstModalidades.getSelectedValue();
        if (modalidadeSelecionada != null) {
            int confirmacaoDel = JOptionPane.showConfirmDialog(rootPane,
                    "Tem certeza que deseja remover modalidade " + modalidadeSelecionada.getDescricao() + "?");
            if (confirmacaoDel == JOptionPane.YES_OPTION) {
                try {
                    persistencia = new PersistenciaJPA();
                    persistencia.conexaoAberta();

                    // Recarregar a entidade
                    Modalidade modalidadeGerenciada = (Modalidade) persistencia.find(Modalidade.class, modalidadeSelecionada.getId());

                    if (modalidadeGerenciada != null) {
                        persistencia.remover(modalidadeGerenciada);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Modalidade não encontrada no banco de dados.");
                    }

                    persistencia.fecharConexao();
                    listarModalidades();
                } catch (Exception e) {
                    System.err.println("Erro ao excluir modalidade: " + e.getMessage());
                } finally {
                    persistencia.fecharConexao();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane,
                    "Nenhuma modalidade selecionada");
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Modalidade modalidadeSelecionada = lstModalidades.getSelectedValue();
        if (modalidadeSelecionada != null) {
            try {
                persistencia = new PersistenciaJPA();
                persistencia.conexaoAberta();
                TelaCadastroModalidade telaCadastro = new TelaCadastroModalidade(this, true);
                telaCadastro.setModalidade(modalidadeSelecionada);
                telaCadastro.setVisible(true);
                listarModalidades();
            } catch (Exception e) {
                System.err.println("Erro ao editar modalidade: " + e.getMessage());
            } finally {
                persistencia.fecharConexao();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma modalidade para editar");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaModalidadesFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaModalidadesFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaModalidadesFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaModalidadesFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaModalidadesFinal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Modalidade> lstModalidades;
    // End of variables declaration//GEN-END:variables
}
