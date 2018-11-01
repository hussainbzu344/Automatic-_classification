package com.edu.autoclass.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DemoJFileChooser extends JPanel
        implements ActionListener {
    JButton go;

    JFileChooser chooser;
    String choosertitle;
    ListModel  libraryListModel;
    ListModel  framworkListModel;
    ListModel  entryPointListModel;
    ListModel  typeListModel;



    public DemoJFileChooser() {
        go = new JButton("Select Folder");
        go.addActionListener(this);
        libraryListModel = new DefaultListModel();
        ((DefaultListModel) libraryListModel).addElement("org.spring");
        ((DefaultListModel) libraryListModel).addElement("or.boot");
        ((DefaultListModel) libraryListModel).addElement("mysql");
        framworkListModel = new DefaultListModel();
        ((DefaultListModel) framworkListModel).addElement("spring mvc");
        entryPointListModel = new DefaultListModel();
        ((DefaultListModel) entryPointListModel).addElement("main method");
        typeListModel = new DefaultListModel();
        ((DefaultListModel) typeListModel).addElement("Web mvc");
       // list = new JList(listModel);
        add(go);
        add(new JList(libraryListModel));
        add(new JList(framworkListModel));
        add(new JList(entryPointListModel));
        add(new JList(typeListModel));

    }

    public void actionPerformed(ActionEvent e) {
        int result;

        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(choosertitle);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //
        // disable the "All files" option.
        //
        chooser.setAcceptAllFileFilterUsed(false);
        //
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): "
                    +  chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : "
                    +  chooser.getSelectedFile());
        }
        else {
            System.out.println("No Selection ");
        }
    }

    public Dimension getPreferredSize(){
        return new Dimension(200, 200);
    }

    public static void main(String s[]) {
        JFrame frame = new JFrame("");
        DemoJFileChooser panel = new DemoJFileChooser();
        frame.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );
        frame.getContentPane().add(panel,"Center");
        frame.setSize(panel.getPreferredSize());
        frame.setVisible(true);
    }
}