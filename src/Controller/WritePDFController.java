/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import PDF.PDFGenerator;
import View.WritePDF;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Samuel
 */
public class WritePDFController {
    
    private final WritePDF view;
    private PDFGenerator generator; 
    private ArrayList<String> body = new ArrayList<>();

    public WritePDFController(WritePDF view) {
        
        this.view = view;
        this.generator = new PDFGenerator();
    }

    public void generatePDF() {
        
//        for(String string : body){    
//            
//            if(string.equals(view.getjTextAreaBody().getText()) == false){
                
                body.add(view.getjTextAreaBody().getText());
//            }
//            
//        }
        
        
        String title = view.getjTextFieldTitle().getText();
        
     
        File pdf = generator.createPDF(view,title);
        
        if(pdf.exists()){
            
          generator.fillPDF(pdf,title,body);
        }
    }

    public void addParagraph() {
    
        body.add(view.getjTextAreaBody().getText()+"\n\n");
        
        view.getjTextAreaBody().setText("");
        
        fillPages();
    }

    public void addPage() {
      
        body.add(view.getjTextAreaBody().getText()+"\n\n");
        body.add("new page");
        
        view.getjTextAreaBody().setText("");
        fillPages();
    }


    public void start() {
   
        fillPages();
    }

    public void fillPages() {
        
      DefaultComboBoxModel model = (DefaultComboBoxModel) view.getjComboBoxPage().getModel();
      
      model.removeAllElements();
      
        int cont = 0;
        
        for (String string : body) {
            
            model.addElement(cont);
            
            cont++;
        }
    }

    public void goToPage() {
    
        Integer index = (Integer) view.getjComboBoxPage().getModel().getSelectedItem();
        
            if(body.isEmpty()== false && index != null){
                
              view.getjTextAreaBody().setText(body.get(index));
            }
    }

    public void showGitHub() {
     
        try {
            URI link = new URI("https://github.com/Samuel-Ricardo/Generate_PDF");
            Desktop.getDesktop().browse(link);
            
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(WritePDFController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
