package GUI;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author professores
 * 
 *  1° passo
 */
public class TelaSecundaria extends JFrame{
    
    public JLabel lblNome, lblTelefone, lblForma, lblEndereco, lblReputacao;
    public JTextField txtNome;
    public JTextField txtTelefone;
    public JTextField txtForma;
    public JTextField txtEndereco;
    public JTextField txtReputacao;
    public JComboBox cmbForma;
    public JButton btnEnviar;
    
    private String[] formaContato = {"WhatsApp", "Ligação"};
    
    public TelaSecundaria() throws ParseException{
        
        setLayout(null);
        
        lblNome = new JLabel("Fornecedor:");
        txtNome = new JTextField();
        lblTelefone = new JLabel("Telefone:");
        txtTelefone = new JTextField();
        lblForma = new JLabel("Forma de contato:");
        cmbForma = new JComboBox(formaContato);
        lblEndereco = new JLabel("Endereço:");
        txtEndereco = new JTextField();
        lblReputacao = new JLabel("Reputação (1 a 10):");
        txtReputacao = new JTextField();
        
        btnEnviar = new JButton("Enviar e criar novo cadastro");
        
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    cliqueBtnEnviar();
                } catch (ParseException ex) {
                    Logger.getLogger(TelaSecundaria.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
        lblNome.setBounds(10, 10, 200, 25);
        txtNome.setBounds(130, 10, 200, 25);
        lblTelefone.setBounds(10, 40, 200, 25);
        txtTelefone.setBounds(130, 40, 200, 25);
        lblForma.setBounds(10, 70, 200, 25);
        cmbForma.setBounds(130, 70, 200, 25);
        lblEndereco.setBounds(10, 100, 200, 25);
        txtEndereco.setBounds(130, 100, 200, 25);
        lblReputacao.setBounds(10, 130, 200, 25);
        txtReputacao.setBounds(130, 130, 200, 25);
        btnEnviar.setBounds(115, 210, 200, 50);

        getContentPane().add(lblNome);
        getContentPane().add(txtNome);
        getContentPane().add(lblTelefone);
        getContentPane().add(txtTelefone);
        getContentPane().add(lblForma);
        getContentPane().add(cmbForma);
        getContentPane().add(lblEndereco);
        getContentPane().add(txtEndereco);
        getContentPane().add(lblReputacao);
        getContentPane().add(txtReputacao);
        getContentPane().add(btnEnviar);
        
        //Especificações da Tela
        setSize(400, 350);
        setTitle("Tela Secundária");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void cliqueBtnEnviar() throws ParseException{
        String nome = txtNome.getText(),
               telefone = txtTelefone.getText(),
               forma = cmbForma.getSelectedItem().toString(),
               endereco = txtEndereco.getText(),
               reputacao = txtReputacao.getText();
        
                
        int telefone_int = Integer.parseInt(telefone);
        float reputacao_float = Float.parseFloat(reputacao);
        
        System.out.println("Fornecedor: " + nome);
        System.out.println("Telefone: " + telefone_int);
        System.out.println("Forma de Contato: " + forma);
        System.out.println("Endereço: " + endereco);
        System.out.println("Reputação: " + reputacao_float);
        
        try(PrintWriter pw = new PrintWriter(new File("fornecedor_hardware"))){
            pw.println("Nome do Fornecedor: " + nome);
            pw.println("Telefone: " + telefone_int);
            pw.println("Forma de Contato: " + forma);
            pw.println("Endereço: " + endereco);
            pw.println("Reputação: " + reputacao_float);
            
        }catch(FileNotFoundException e){
            System.out.println("Arquivo não existe");
        }
        try {
             BDConnection_2.insereFornecedor(nome, telefone_int, forma, endereco, reputacao_float);
        } catch (Exception e) {
            System.out.println(e);
        }
        this.dispose();
        new TelaInicial();
    }
}