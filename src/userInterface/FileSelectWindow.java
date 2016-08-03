/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import java.io.File;

/**
 *
 * @author Griffin
 */
public class FileSelectWindow extends javax.swing.JFrame
{

    private final SlideUI slideUI;

    private final String purpose;

    /**
     * Creates new form FileSelectWindow
     *
     * @param slideUI
     * @param purpose
     */
    public FileSelectWindow(SlideUI slideUI, String purpose)
    {
        this.slideUI = slideUI;
        this.purpose = purpose;
        initComponents();
        jFileChooser.setCurrentDirectory(new File("."));
        if (this.purpose.equals("save") || this.purpose.equals("XMLSave"))
        {
            jFileChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        } else
        {
            jFileChooser.setDialogType(javax.swing.JFileChooser.OPEN_DIALOG);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jFileChooser = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("slide");

        jFileChooser.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jFileChooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Calls a method of slideUI depending on what purpose this window was
     * constructed with.
     *
     * @param evt unused
     */
    private void jFileChooserActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jFileChooserActionPerformed
    {//GEN-HEADEREND:event_jFileChooserActionPerformed
        File file = jFileChooser.getSelectedFile();
        switch (this.purpose)
        {
            case "XMLSave":
                file = new File(file.toString() + ".xml");
                this.slideUI.XMLSave(file);
                break;
            case "XMLLoad":
                this.slideUI.XMLLoad(file);
                break;
            case "save":
                file = new File(file.toString() + ".sld");
                this.slideUI.save(file);
                break;
            case "load":
                this.slideUI.load(file);
                break;
        }
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jFileChooserActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser;
    // End of variables declaration//GEN-END:variables
}