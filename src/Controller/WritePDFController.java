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

    public WritePDFController(WritePDF view) {
        this.view = view;
        this.generator = new PDFGenerator();
    }

    public void generatePDF() {
        
        if(body.isEmpty()){
            
            body.add(view.getjTextAreaBody().getText());
        }
        
        String title = view.getjTextFieldTitle().getText();
        
     
        File pdf = generator.createPDF(view,title);
        
        if(pdf.exists()){
            
          generator.fillPDF(pdf,title,body);
        }
    }

    public void addParagraph() {
    
        body.add(view.getjTextAreaBody().getText());
        
        view.getjTextAreaBody().setText("");
    }
}
