/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDF;

import java.awt.Component;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Samuel
 */
public class PDFGenerator {

    public File createPDF(Component view) {
     
        JFileChooser chooser = new JFileChooser();
        
        chooser.setFileFilter(new FileNameExtensionFilter("PDF", "*.pdf"));
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        
        File save = new File("");
        int result = chooser.showSaveDialog(view);
        
        if(result == JFileChooser.APPROVE_OPTION){
            
            save = chooser.getSelectedFile();
        }
        
        return save;
    }
    
}
