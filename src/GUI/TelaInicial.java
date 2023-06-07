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
public class TelaInicial extends JFrame{
    
    public JLabel lblNome, lblCategoria, lblEstado, lblQuantidade, lblPreco;
    public JTextField txtNome;
    public JTextField txtQuantidade;
    public JTextField txtPreco;
    public JComboBox cmbCategoria;
    public JComboBox cmbEstado;
    public JButton btnEnviar;
    
    private String[] categoriaPeca = {"Servidor", "Desktop", "Notebook"};
    private String[] estadoPeca = {"Novo", "Usado"};
    
    public TelaInicial() throws ParseException{
        
        setLayout(null);
        
        lblNome = new JLabel("Nome da Peça:");
        txtNome = new JTextField();
        lblCategoria = new JLabel("Categoria:");
        cmbCategoria = new JComboBox(categoriaPeca);
        lblEstado = new JLabel("Estado:");
        cmbEstado = new JComboBox(estadoPeca);
        lblQuantidade = new JLabel("Quantidade:");
        txtQuantidade = new JTextField();
        lblPreco = new JLabel("Preço:");
        txtPreco = new JTextField();
        btnEnviar = new JButton("Enviar e Prosseguir");
        
        
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    cliqueBtnEnviar();
                } catch (ParseException ex) {
                    Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
        lblNome.setBounds(10, 10, 200, 25);
        txtNome.setBounds(120, 10, 200, 25);
        lblCategoria.setBounds(10, 40, 200, 25);
        cmbCategoria.setBounds(120,40,200,25);
        lblEstado.setBounds(10, 70, 200, 25);
        cmbEstado.setBounds(120,70,200,25);
        lblQuantidade.setBounds(10,100,200,25);
        txtQuantidade.setBounds(120,100,200,25);
        lblPreco.setBounds(10,130,200,25);
        txtPreco.setBounds(120,130,200,25);
        btnEnviar.setBounds(125, 220, 150, 50);

        getContentPane().add(lblNome);
        getContentPane().add(txtNome);
        getContentPane().add(lblCategoria);
        getContentPane().add(cmbCategoria);
        getContentPane().add(lblEstado);
        getContentPane().add(cmbEstado);
        getContentPane().add(lblQuantidade);
        getContentPane().add(txtQuantidade);
        getContentPane().add(lblPreco);
        getContentPane().add(txtPreco);
        getContentPane().add(btnEnviar);
        
        //Especificações da Tela
        setSize(400, 350);
        setTitle("Tela Inicial");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void cliqueBtnEnviar() throws ParseException{
        String nome = txtNome.getText(),
               categoria = cmbCategoria.getSelectedItem().toString(),
               estado = cmbEstado.getSelectedItem().toString(),
               quantidade = txtQuantidade.getText(),
               preco = txtPreco.getText();
        
        float preco_float = Float.parseFloat(preco);
        int quantidade_int = Integer.parseInt(quantidade);
        
        System.out.println("Nome da Peça: " + nome);
        System.out.println("Categoria: " + categoria);
        System.out.println("Estado: " + estado);
        System.out.println("Quantidade: " + quantidade_int);
        System.out.println("Preço: " + preco_float);
        
        try(PrintWriter pw = new PrintWriter(new File("informacao_hardware"))){
            pw.println("Nome da Peça: " + nome);
            pw.println("Categoria: " + categoria);
            pw.println("Estado: " + estado);
            pw.println("Quantidade: " + quantidade_int);
            pw.println("Preço: " + preco_float);
            
        }catch(FileNotFoundException e){
            System.out.println("Arquivo não existe");
        }
        try {
             BDConnection.insereInformacao(nome, categoria, estado, quantidade_int, preco_float);
        } catch (Exception e) {
            System.out.println(e);
        }
        this.dispose();
        new TelaSecundaria();
    }
}