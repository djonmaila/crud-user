package controllers;

import models.User;
import services.UserServiceImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControllerGraphic extends JFrame {
    private JPanel panelPrincipale;
    private JLabel idLabel,nomLabel,prenomLabel,emailLabel,phoneLabel;
    private JTextField idText,nomText,prenomText,emailText,phoneText;
    private JButton savebutton,updateButton,deleteButton,actuButton;
    private DefaultTableModel model;
    private JTable table;
    private Object[][] tableData = null;
    private String[] elements = {"ID","FirstName","LastName","Email","PhoneNum"};
    private UserServiceImpl userService;
    private List<User> users;
    public ControllerGraphic(){
        userService = new UserServiceImpl();
        initComponent();
    }
    public void initComponent(){
        this.setTitle("Pain");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,450);
//        Color color = new Color(0x012564);
        this.setLayout(null);

        panelPrincipale = new JPanel();
        panelPrincipale.setBounds(0,0,800,450);
        panelPrincipale.setBackground(Color.GRAY);
        panelPrincipale.setLayout(null);

        model = new DefaultTableModel(tableData,elements);
        table = new JTable();
        table.setBounds(360,10,440,400);
        table.setModel(model);

        users = userService.getAllUser();
        for (User user:users){
            model.addRow(new String[]{String.valueOf(user.getId()),user.getFirstName(),user.getLastName(),user.getEmail(),user.getPhoneNumber()});
        }


        panelPrincipale.setBounds(0,0,800,450);
        panelPrincipale.setBackground(Color.GRAY);
        panelPrincipale.setLayout(null);



        idLabel = new JLabel("Identifiant ");
        idLabel.setBounds(20,20,150,30);
        idLabel.setFont(new Font("verdana",Font.BOLD,20));


        idText = new JTextField();
        idText.setBounds(180,20,160,30);
        idText.setFont(new Font("Arial",Font.ITALIC,10));

        nomLabel = new JLabel("FirstName ");
        nomLabel.setBounds(20,70,150,30);
        nomLabel.setFont(new Font("verdana",Font.BOLD,20));


        nomText = new JTextField();
        nomText.setBounds(180,70,160,30);
        nomText.setFont(new Font("Arial",Font.ITALIC,10));

        prenomLabel = new JLabel("LastName ");
        prenomLabel.setBounds(20,120,150,30);
        prenomLabel.setFont(new Font("verdana",Font.BOLD,20));


        prenomText = new JTextField();
        prenomText.setBounds(180,120,160,30);
        prenomText.setFont(new Font("Arial",Font.ITALIC,10));

        emailLabel = new JLabel("Email ");
        emailLabel.setBounds(20,170,150,30);
        emailLabel.setFont(new Font("verdana",Font.BOLD,20));


        emailText = new JTextField();
        emailText.setBounds(180,170,160,30);
        emailText.setFont(new Font("Arial",Font.ITALIC,10));

        phoneLabel = new JLabel("Phone Number");
        phoneLabel.setBounds(20,220,170,30);
        phoneLabel.setFont(new Font("verdana",Font.BOLD,20));


        phoneText = new JTextField();
        phoneText.setBounds(180,220,160,30);
        phoneText.setFont(new Font("Arial",Font.ITALIC,10));

        savebutton = new JButton("SAVE");
        savebutton.setBounds(20,270,100,30);
        savebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                userService.createUser(new User(Long.valueOf(idText.getText()),nomText.getText(),prenomText.getText(),emailText.getText(),phoneText.getText()));
                }catch (NumberFormatException a){
                    System.err.println("erreur de cating");
                }
            }
        });

        updateButton = new JButton("UPDATE");
        updateButton.setBounds(180,270,100,30);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    userService.updateUser(Long.valueOf(idText.getText()),new User(Long.valueOf(idText.getText()),nomText.getText(),prenomText.getText(),emailText.getText(),phoneText.getText()));
                }catch (NumberFormatException a){
                    System.err.println("erreur de casting");
                }
            }
        });

        deleteButton = new JButton("DELETE");
        deleteButton.setBounds(20,320,100,30);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    userService.deleteUser(Long.valueOf(idText.getText()));
                }catch (NumberFormatException g){
                    System.err.println("erreur lors de la suppression");
                }
            }
        });

        actuButton = new JButton("ACTUALISER");
        actuButton.setBounds(180,320,100,30);
        actuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                users = userService.getAllUser();
                for (User user:users){
                    model.addRow(new String[]{String.valueOf(user.getId()),user.getFirstName(),user.getLastName(),user.getEmail(),user.getPhoneNumber()});
                }
            }
        });

        panelPrincipale.add(idLabel);
        panelPrincipale.add(idText);
        panelPrincipale.add(nomLabel);
        panelPrincipale.add(nomText);
        panelPrincipale.add(prenomLabel);
        panelPrincipale.add(prenomText);
        panelPrincipale.add(emailLabel);
        panelPrincipale.add(emailText);
        panelPrincipale.add(phoneLabel);
        panelPrincipale.add(phoneText);
        panelPrincipale.add(savebutton);
        panelPrincipale.add(updateButton);
        panelPrincipale.add(deleteButton);
        panelPrincipale.add(actuButton);
        panelPrincipale.add(table);

        this.add(panelPrincipale);
        this.setVisible(true);
    }
    public static void main(String[] args){
        new ControllerGraphic();
    }
}
