package GUIJavaSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressForm extends JFrame {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Address Form");


        ///labels
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(50,30,150,20);

        JLabel streetLabel = new JLabel("Street");
        streetLabel.setBounds(220,30,150,20);

        JLabel cityLabel = new JLabel("City");
        cityLabel.setBounds(390,30,150,20);

        JLabel stateLabel = new JLabel("State");
        stateLabel.setBounds(150,100,150,20);

        JLabel zipLabel = new JLabel("Zip");
        zipLabel.setBounds(320,100,150,20);


        ////text
        JTextField nameText = new JTextField();
        nameText.setBounds(50,50,150,30);

        JTextField streetText = new JTextField();
        streetText.setBounds(220,50,150,30);

        JTextField cityText = new JTextField();
        cityText.setBounds(390,50,150,30);

        JTextField stateText = new JTextField();
        stateText.setBounds(150,130,150,30);

        JTextField zipText = new JTextField();
        zipText.setBounds(320,130,150,30);

        JButton submitBtn = new JButton("Submit");
        submitBtn.setBounds(200,200,150,30);
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println(e.getActionCommand());
                System.out.println( nameText.getText()+"\n"+stateText.getText()+"\n"+cityText.getText()+", "+stateText.getText()+" "+zipText.getText());
            }
        });

        Container c = jf.getContentPane();

        c.add(nameLabel);
        c.add(nameText);

        c.add(streetLabel);
        c.add(streetText);

        c.add(cityLabel);
        c.add(cityText);

        c.add(stateLabel);
        c.add(stateText);

        c.add(zipLabel);
        c.add(zipText);

        c.add(submitBtn);

        jf.setSize(600,400);
        jf.setLayout(null);
        jf.setVisible(true);

    }
}
