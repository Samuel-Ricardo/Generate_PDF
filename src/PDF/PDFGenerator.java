/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDF;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author Samuel
 */
public class PDFGenerator {

   
    private PdfWriter writer;

    public PDFGenerator() {
        
      
    }
    
    public File createPDF(Component view) {
        
         
        JFileChooser  chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("PDF", "*.pdf"));
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        
        File save = new File("");
        int result = chooser.showSaveDialog(view);
        
        if(result == JFileChooser.APPROVE_OPTION){
            
            save = chooser.getSelectedFile();
        }
        
        return save;
    }

    public void fillPDF(File pdf, String title, ArrayList<String> body) {
     
        FileOutputStream outputStream = null;
        try {
            
            Document document = new Document();
            
            outputStream = new FileOutputStream(pdf);
            
            PdfWriter.getInstance(document, outputStream);
            
            document.open();
            
                document.setPageSize(PageSize.A4);
                document.addTitle(title);
            
            document.close();
            
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(PDFGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                outputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(PDFGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
