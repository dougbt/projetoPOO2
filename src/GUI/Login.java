package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login extends JFrame {
    public JLabel lblNome, lblSenha;
    public JTextField txtNome, txtSenha;
    public JButton btnEnviar, btnCadastrar;

    public Login() throws ParseException {
        setLayout(null);
        lblNome = new JLabel("Nome:");
        txtNome = new JTextField();
        lblSenha = new JLabel("Senha:");
        txtSenha = new JTextField();
        btnEnviar = new JButton("login");
        btnCadastrar = new JButton("Cadastrar");

        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cliqueBtnEnviar();
                } catch (ParseException ex) {
                    Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        lblNome.setBounds(10, 10, 100, 30);
        txtNome.setBounds(120, 10, 200, 30);
        lblSenha.setBounds(10, 50, 100, 30);
        txtSenha.setBounds(120, 50, 200, 30);
        btnEnviar.setBounds(10, 90, 200, 30);
        btnCadastrar.setBounds(10, 130, 200, 30);

        getContentPane().add(lblNome);
        getContentPane().add(txtNome);
        getContentPane().add(lblSenha);
        getContentPane().add(txtSenha);
        getContentPane().add(btnEnviar);
        getContentPane().add(btnCadastrar);

        //Especificações da Tela
        setSize(500, 400);
        setTitle("GUI.Login");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    private void cliqueBtnEnviar() throws ParseException{
        String nome = txtNome.getText();
        String senha = txtSenha.getText();
        if(nome.equals("admin") && senha.equals("admin")){
            JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");
            new TelaInicial();
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Login ou senha incorretos!");
        }
        
    }
}
