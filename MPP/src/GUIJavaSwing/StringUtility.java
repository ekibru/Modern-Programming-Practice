package GUIJavaSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashSet;
import java.util.Set;

public class StringUtility extends JFrame {
    public static void main(String[] args) {
        JFrame jf = new JFrame("String Utility");

        JButton countBtn = new JButton("Count Letters");
        countBtn.setSize(120,30);
        countBtn.setFont(new Font("Arial", Font.BOLD, 20));

        JButton reverseBtn = new JButton("Reserve Letters");
        reverseBtn.setSize(120,30);
        reverseBtn.setFont(new Font("Arial", Font.BOLD, 20));

        JButton removeBtn = new JButton("Remove Duplicates");
        removeBtn.setSize(120,30);
        removeBtn.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel inputLabel = new JLabel("Input");
        inputLabel.setBounds(20,0,120,30);
        JTextField inputText = new JTextField();
        inputText.setBounds(20,20,120,30);

        JLabel outputLabel = new JLabel("Output");
        outputLabel.setBounds(20,40,120,30);
        JTextField outputText = new JTextField();
        outputText.setBounds(20,60,120,30);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBounds(50,20,200,200);


        JPanel textsPanel = new JPanel();
        textsPanel.setLayout(null);
        textsPanel.setBounds(270,20,200,200);

        countBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputText.setText(Integer.toString(inputText.getText().length()));
            }

        });

        reverseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputText.setText(new StringBuilder(inputText.getText()).reverse().toString());
            }
        });

        removeBtn.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    outputText.setText(utility.removeDuplicates(inputText.getText().toCharArray()));
        }
        });

        Container c = jf.getContentPane();

        buttonsPanel.add(countBtn);
        buttonsPanel.add(reverseBtn);
        buttonsPanel.add(removeBtn);

        textsPanel.add(inputLabel);
        textsPanel.add(inputText);

        textsPanel.add(outputLabel);
        textsPanel.add(outputText);

        c.add(buttonsPanel);
        c.add(textsPanel);

        JMenuBar mb = new JMenuBar();
        JMenu myMenu = new JMenu();
        myMenu.setText("my menu");

        JMenuItem firstItem = new JMenuItem("First Item");
        JMenuItem secondItem = new JMenuItem("Second Item");
        JMenuItem thirdItem = new JMenuItem("Third Item");

        firstItem.addActionListener(actionListener);
        secondItem.addActionListener(actionListener);
        thirdItem.addActionListener(actionListener);

        myMenu.add(firstItem);
        myMenu.add(secondItem);
        myMenu.add(thirdItem);

        mb.add(myMenu);
        jf.setJMenuBar(mb);

        jf.setSize(800,500);
        jf.setLayout(null);
        jf.setVisible(true);

    }

    static ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
        }
    };

}
class utility{
    static String removeDuplicates(char[] chars)
    {
        Set<Character> charSet = new LinkedHashSet<Character>();
        for (char c : chars) {
            charSet.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : charSet) {
            sb.append(character);
        }
        return sb.toString();
    }
}
