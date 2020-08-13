/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import PDF.PDFGenerator;
import View.WritePDF;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Samuel
 */
public class WritePDFController {
    
    private final WritePDF view;
    private PDFGenerator generator; 
    private ArrayList<String> body = new ArrayList<>();
    private int index;

    public WritePDFController(WritePDF view) {
        this.view = view;
        this.generator = new PDFGenerator();
        this.index = 0;
    }

    public void generatePDF() {
        
        body.add(view.getjTextAreaBody().getText());
        
        String title = view.getjTextFieldTitle().getText();
        
     
        File pdf = generator.createPDF(view,title);
        
        if(pdf.exists()){
            
          generator.fillPDF(pdf,title,body);
        }
    }

    public void addParagraph() {
    
        body.add(view.getjTextAreaBody().getText());
        body.add(" ");
        
        view.getjTextAreaBody().setText("");
        index ++;
        fillPages();
    }

    public void addPage() {
      
        body.add(view.getjTextAreaBody().getText());
        body.add("new page");
        
        view.getjTextAreaBody().setText("");
        index ++;
        fillPages();
    }


    public void start() {
   
        fillPages();
        
    
    }

    public void fillPages() {
        int cont = 0;
        
        for (String string : body) {
            
            view.getjComboBoxPage().addItem(cont);
            
            cont++;
        }
    }
}
