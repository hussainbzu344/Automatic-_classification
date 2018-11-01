package com.edu.autoclass.main;

import com.edu.autoclass.bean.EntryPoint;
import com.edu.autoclass.bean.Framework;
import com.edu.autoclass.bean.ProjectType;
import com.edu.autoclass.bean.SearchResult;
import com.edu.autoclass.script.Discovery;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class NewJFrame extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Select project directory");

        jButton1.setText("Select Folder");
        jButton1.addActionListener(this);
        jButton2.setText("Discover");
        jButton2.addActionListener(this);


        jLabel2.setText("Library");

        jLabel3.setText("Frameworks");

        jLabel4.setText("Entry Points");

        jLabel5.setText("Type");

        jScrollPane1.setViewportView(jList1);
        jScrollPane2.setViewportView(jList2);

        jScrollPane3.setViewportView(jList3);

        jScrollPane4.setViewportView(jList4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel3)
                                                        .addGap(100, 100, 100)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(100, 100, 100)
                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(100, 100, 100)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(100, 100, 100)
                                                        .addComponent(jLabel1)
                                                        .addGap(100, 100, 100)
                                                        .addComponent(jButton1)
                                                        .addGap(100, 100, 100)
                                                        .addComponent(jButton2))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(jLabel2)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel4)
                                                        .addGap(100, 100, 100))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addGap(30,30,30)
                                        .addComponent(jLabel3)

                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36))
        );

        pack();
    }

    private String[] getFrameworks(List<Framework> frameworks) {
        String[] strings = new String[frameworks.size()];
        int index = 0;
        for (Framework framework : frameworks) {
            strings[index] = framework.getName();
        index++;
        }

        return new HashSet<String>(Arrays.asList(strings)).toArray(new String[0]);
    }

    private String[] getLibraries(List<String> libraries) {
        String[] strings = new String[libraries.size()];
        int index = 0;
        for (String library : libraries) {
        strings[index]=library;
            index++;
        }
        return strings;
    }

    private String[] getEntryPoints(List<EntryPoint> entryPoints) {
        String[] strings = new String[entryPoints.size()];
        int index = 0;
        for (EntryPoint entryPoint : entryPoints) {
            strings[index] = entryPoint.getLocation();
            index++;
        }

        return new HashSet<String>(Arrays.asList(strings)).toArray(new String[0]);
    }

    private String[] getProjectType(List<ProjectType> projectTypes) {
        String[] strings = new String[projectTypes.size()];
        int index = 0;
        for (ProjectType projectType : projectTypes) {
            strings[index] = projectType.getName();
            index++;
        }
        return new HashSet<String>(Arrays.asList(strings)).toArray(new String[0]);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().contains("Discover")) {
            jList1.clearSelection();
            jList2.clearSelection();
            jList3.clearSelection();
            jList4.clearSelection();
            Discovery discovery = new Discovery();
            final SearchResult searchResult = discovery.findLibraries(chooser.getSelectedFile().toString());
            jList1.setModel(new javax.swing.AbstractListModel<String>() {
                String[] strings = getLibraries(searchResult.getLibraries());
                public int getSize() {
                    return strings.length;
                }

                public String getElementAt(int i) {
                    return strings[i];
                }
            });


            jList2.setModel(new javax.swing.AbstractListModel<String>() {
                String[] strings =  getEntryPoints(searchResult.getEntryPoints());

                public int getSize() {
                    return strings.length;
                }

                public String getElementAt(int i) {
                    return strings[i];
                }
            });

            jList3.setModel(new javax.swing.AbstractListModel<String>() {
                String[] strings =getFrameworks(searchResult.getFrameworks());
                public int getSize() {
                    return strings.length;
                }

                public String getElementAt(int i) {
                    return strings[i];
                }
            });
            jList4.setModel(new javax.swing.AbstractListModel<String>() {
                String[] strings = getProjectType(searchResult.getProjectTypes());
                public int getSize() {
                    return strings.length;
                }

                public String getElementAt(int i) {
                    return strings[i];
                }
            });
        } else {
            chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("Select project folder");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            //
            // disable the "All files" option.
            //
            chooser.setAcceptAllFileFilterUsed(false);
            //
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                System.out.println("getCurrentDirectory(): "
                        + chooser.getCurrentDirectory());
                System.out.println("getSelectedFile() : "
                        + chooser.getSelectedFile());
            } else {
                System.out.println("No Selection ");
            }
        }
    }

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    JFileChooser chooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JList<String> jList4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration
}
