/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.asaid.view;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import br.com.asaid.dto.AssistenciaDTO;
import br.com.asaid.ctr.AssistenciaCTR;
import br.com.asaid.dto.ProdutoDTO;
import br.com.asaid.dto.ClienteDTO;
import br.com.asaid.dto.AdminDTO;

public class AtualizarAssistVIEW extends javax.swing.JInternalFrame {
    AssistenciaDTO assistenciaDTO = new AssistenciaDTO();
    AssistenciaCTR assistenciaCTR = new AssistenciaCTR();
    ProdutoDTO produtoDTO = new ProdutoDTO();    
    ClienteDTO clienteDTO = new ClienteDTO();  
    
    ResultSet rs; //Variavel usada para preenchimeto da tabela e dos campos
    int gravar_alterar; //Variavel usada para saber se esta alterando o incluindo
    DefaultTableModel modelo_jtlAssist; //Variavel para guardar o modelo da tabela
    
    /**
     * Creates new form AtualizarAssistVIEW
     */
    public AtualizarAssistVIEW() {
        initComponents();
        this.setSize(768, 465);
        //Chama todos os métodos liberaCampos
        liberaCampos(false);
        //Chama o método liberaBotoes
        liberaBotoes(false, true);
        //Atribui um modelo para manipular a tabela 
        modelo_jtlAssist = (DefaultTableModel) jtlAssist.getModel();
    }
    
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }//Fecha método setPosicao()
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        lblObs = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtlAssist = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        pesquisa_produto = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atualizar assistência");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Atualização de assistência");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        lblStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblStatus.setText("Status:");

        lblObs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblObs.setText("Observações:");

        txtObs.setColumns(20);
        txtObs.setRows(5);
        jScrollPane1.setViewportView(txtObs);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStatus))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblObs)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblObs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jtlAssist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Assist", "Cod Produto", "Data Entrada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtlAssist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtlAssistMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtlAssist);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Cod Produto:");

        btnPesquisar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/asaid/view/imagens/pesquisar.png"))); // NOI18N
        btnPesquisar.setAlignmentY(0.0F);
        btnPesquisar.setBorder(null);
        btnPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPesquisar.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        btnPesquisar.setMaximumSize(new java.awt.Dimension(113, 35));
        btnPesquisar.setMinimumSize(new java.awt.Dimension(113, 35));
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pesquisa_produto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(pesquisa_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnSalvar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/asaid/view/imagens/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setAlignmentY(0.0F);
        btnSalvar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSalvar.setMaximumSize(new java.awt.Dimension(113, 35));
        btnSalvar.setMinimumSize(new java.awt.Dimension(113, 35));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/asaid/view/imagens/sair.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.setAlignmentY(0.0F);
        btnSair.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSair.setMaximumSize(new java.awt.Dimension(113, 35));
        btnSair.setMinimumSize(new java.awt.Dimension(113, 35));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtlAssistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtlAssistMouseClicked
        preencheCampos(Integer.parseInt(String.valueOf(jtlAssist.getValueAt(jtlAssist.getSelectedRow(), 0))));
        liberaBotoes(true, true);
    }//GEN-LAST:event_jtlAssistMouseClicked

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        preencheTabela(Integer.parseInt(pesquisa_produto.getText()));
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(verificaPreenchimentoGeral()){
            if(gravar_alterar==1){
                gravar();
                gravar_alterar=0;
            }
           
            limpaCampos();
            liberaCampos(false);
            liberaBotoes(false, true);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void gravar(){
        try{
            assistenciaDTO.setStatus(txtStatus.getText());
            assistenciaDTO.setObs_assist(txtObs.getText());
            
            JOptionPane.showMessageDialog(null,
                    assistenciaCTR.atualizarStatusAssistencia(assistenciaDTO)
            );
            
        }
        catch(Exception e){
            System.out.println("Erro ao Gravar" + e.getMessage());
        }
    }//Fecha método gravar()
    
  

     private void preencheTabela(int cod_produto){
        try{
            //Limpa todas as linhas
            modelo_jtlAssist.setNumRows(0);

            //Enquanto tiver linhas - faça
            produtoDTO.setCod_produto(cod_produto);
            rs = assistenciaCTR.consultarAssistencia(assistenciaDTO, produtoDTO, clienteDTO, 7); //1 = é a pesquisa por marca na classe DAO
            while(rs.next()){
                modelo_jtlAssist.addRow(new Object[]{
                  rs.getString("id_assist"),
                  rs.getString("cod_produto"),
                  rs.getString("data")
                });
            }        
        }
        catch(Exception erTab){
            System.out.println("Erro SQL: "+erTab);
        }  
    }
     
    private void preencheCampos(int id_assist){
        try{
            assistenciaDTO.setId_assist(id_assist);
            rs = assistenciaCTR.consultarAssistencia(assistenciaDTO, produtoDTO, clienteDTO, 9); 
            if(rs.next()){
                limpaCampos();
                String observacao = "";
                txtStatus.setText(rs.getString("status"));
                observacao =    rs.getString("obs_assist") + "\n" +
                                "---------------\n\n" +
                                "Data: " +
                                "\nStatus: " +
                                "\nObservação: ";
                txtObs.setText(observacao);
                
                gravar_alterar = 1;
                liberaCampos(true);
            }
        }
        catch(Exception erTab){
            System.out.println("Erro SQL: "+erTab);
        }  
    }
    
    private void liberaCampos(boolean a){
        txtStatus.setEnabled(a);
        txtObs.setEnabled(a);
    }//Fecha método liberaCampos(boolean a)
    
    private void limpaCampos(){
        txtStatus.setText("");
        txtObs.setText("");
    }//Fecha método limpaCampos()
    
    private void liberaBotoes(boolean a, boolean b){
        btnSalvar.setEnabled(a);
        btnSair.setEnabled(b);
    }
   
    private boolean verificaPreenchimentoGeral() {                            
        if(txtStatus.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "O campo Status deve ser preenchido");
            txtStatus.requestFocus();
            return false;
        } else {
            if(txtObs.getText().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "O campo Descrição deve ser preenchido");
                txtObs.requestFocus();
                return false;
            }
            else{
                return true;
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtlAssist;
    private javax.swing.JLabel lblObs;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTextField pesquisa_produto;
    private javax.swing.JTextArea txtObs;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}