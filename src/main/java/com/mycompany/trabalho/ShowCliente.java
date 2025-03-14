/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.trabalho;

import controller.Controller;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author victor
 */
public class ShowCliente extends javax.swing.JFrame {

    /**
     * Creates new form ShowCliente
     */
    
    private String busca;
    
    public ShowCliente() {
        initComponents();
        preencherTabela();
        
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
    }
    
    private static ShowCliente instance;
    
    private Controller controle;
    
    public static ShowCliente getInstance(){
        if(instance == null){
            instance = new ShowCliente();
        }
        return instance;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        EditarButton = new javax.swing.JToggleButton();
        Delette = new javax.swing.JButton();
        buscar = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cliente.jpeg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(252, 254, 254));

        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Cpf", "Telefone", "Quantidade Veiculo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Tabela.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TabelaFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(Tabela);

        EditarButton.setBackground(new java.awt.Color(255, 204, 0));
        EditarButton.setForeground(new java.awt.Color(255, 255, 102));
        EditarButton.setText("Editar ");
        EditarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarButtonActionPerformed(evt);
            }
        });

        Delette.setBackground(new java.awt.Color(255, 51, 51));
        Delette.setForeground(new java.awt.Color(153, 0, 0));
        Delette.setText("Delete");
        Delette.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletteActionPerformed(evt);
            }
        });

        buscar.setText("Buscar ...");
        buscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                buscarFocusLost(evt);
            }
        });
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        jToggleButton1.setBackground(new java.awt.Color(0, 153, 51));
        jToggleButton1.setForeground(new java.awt.Color(153, 255, 153));
        jToggleButton1.setText("Buscar Cliente");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Delette)
                        .addGap(18, 18, 18)
                        .addComponent(EditarButton))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton1)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditarButton)
                    .addComponent(Delette))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TabelaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TabelaFocusLost
        // TODO add your handling code here:
        
        System.out.println(Arrays.toString(Tabela.getComponents())
        );
        
    }//GEN-LAST:event_TabelaFocusLost

    private void EditarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarButtonActionPerformed
                                                    
         Controller controle = Controller.getInstance();
        DefaultTableModel model = (DefaultTableModel) Tabela.getModel();

        if (Tabela.isEditing()) {
            Tabela.getCellEditor().stopCellEditing(); // Garante que os dados editados sejam salvos antes da leitura
        }

        for (int i = 0; i < model.getRowCount(); i++) {
            String nome = (String) model.getValueAt(i, 0);
            String telefone = (String) model.getValueAt(i, 1);
            String cpf = (String) model.getValueAt(i, 2);

            System.out.println("Editando CPF: " + cpf + " | Nome: " + nome + " | Telefone: " + telefone);

            boolean sucesso = controle.editarCliente(cpf, nome, telefone);

            if (!sucesso) {
                JOptionPane.showMessageDialog(null, "Erro ao editar cliente com CPF: " + cpf);
            }
        }

        preencherTabela();
        JOptionPane.showMessageDialog(null, "Edições salvas com sucesso!");
    
    }//GEN-LAST:event_EditarButtonActionPerformed

    private void DeletteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletteActionPerformed
        // TODO add your handling code here:

        // Obtém a linha selecionada
        int linhaSelecionada = Tabela.getSelectedRow();

        // Se nenhuma linha estiver selecionada, exibe um alerta
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um cliente para deletar!");
            return;
        }

        // Obtém o CPF da linha selecionada (coluna 2 da tabela)
        String cpf = (String) Tabela.getValueAt(linhaSelecionada, 2);

        // Exibe um alerta de confirmação
        int confirmacao = JOptionPane.showConfirmDialog(null, 
                "Deseja realmente excluir este cliente?", 
                "Confirmação", JOptionPane.YES_NO_OPTION);

        // Se o usuário confirmar a exclusão
        if (confirmacao == JOptionPane.YES_OPTION) {
            Controller controle = Controller.getInstance();
            controle.deletarCliente(cpf);

            // Exibe uma mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso!");

            // Remove a linha da tabela
            DefaultTableModel model = (DefaultTableModel) Tabela.getModel();
            model.removeRow(linhaSelecionada);
        }
    }//GEN-LAST:event_DeletteActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        
        filtrarTabela(busca);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_buscarActionPerformed

    private void buscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscarFocusLost
        // TODO add your handling code here:
        
        busca = buscar.getText();
        
        System.out.println(busca);
        
        
    }//GEN-LAST:event_buscarFocusLost

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ShowCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowCliente().setVisible(true);
            }
        });
    }
    
    

public void preencherTabela() {
    // Obtém a instância do controlador
    Controller controle = Controller.getInstance();
    Map<String, Map<String, String>> clientes = controle.getClientes();

    // Obtém o modelo da tabela
    DefaultTableModel model = (DefaultTableModel) Tabela.getModel();

    // Limpa a tabela antes de adicionar novos dados (evita duplicações)
    model.setRowCount(0);

    // Percorre os clientes e adiciona na tabela
    for (Map<String, String> clienteData : clientes.values()) {
        String nome = clienteData.get("nome");
        String telefone = clienteData.get("telefone");
        String cpf = clienteData.get("cpf");

        // Contar a quantidade de veículos
        String veiculos = clienteData.get("veiculos");
        int quantidadeVeiculos = veiculos.equals("Nenhum veículo associado") ? 0 : veiculos.split("\\[").length - 1;

        // Adiciona a linha no modelo da tabela
        model.addRow(new Object[]{nome, telefone, cpf, quantidadeVeiculos});
    }
}

private void filtrarTabela(String pesquisa) {
    DefaultTableModel modelo = (DefaultTableModel) Tabela.getModel();
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
    Tabela.setRowSorter(sorter);

    // Aplica o filtro usando expressões regulares (ignora maiúsculas/minúsculas)
    if (pesquisa.trim().length() == 0) {
        sorter.setRowFilter(null);
    } else {
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + pesquisa, 0, 2)); // Filtra pelo Nome (coluna 0) e CPF (coluna 2)
    }
}






    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delette;
    private javax.swing.JToggleButton EditarButton;
    private javax.swing.JTable Tabela;
    private javax.swing.JTextField buscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
