package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastro extends JFrame {
    JLabel lblNome, lblSenha;
    JTextField txtNome, txtSenha;
    JButton btnEnviar;

    public TelaCadastro(){
        setTitle("Cadastro");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lblNome = new JLabel("Nome:");
        txtNome = new JTextField();

        lblSenha = new JLabel("Senha:");
        txtSenha = new JTextField();

        btnEnviar = new JButton("Cadastrar");

        lblNome.setBounds(20, 20, 100, 20);
        txtNome.setBounds(20, 40, 100, 20);

        lblSenha.setBounds(20, 60, 100, 20);
        txtSenha.setBounds(20, 80, 100, 20);

        btnEnviar.setBounds(20, 100, 100, 20);

        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastraUsuario();;
            }
        });    

        getContentPane().add(lblNome);
        getContentPane().add(txtNome);
        getContentPane().add(lblSenha);
        getContentPane().add(txtSenha);
        getContentPane().add(btnEnviar);

        setVisible(true);
    }

        private void cadastraUsuario(){
            String nome = txtNome.getText();


            Usuario usuario = new Usuario();
            usuario.gravarUsuario();
            System.out.println(usuario);        
    }
}
