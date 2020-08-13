/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import PDF.PDFGenerator;
import View.WritePDF;
import java.io.File;

/**
 *
 * @author Samuel
 */
public class WritePDFController {
    
    private final WritePDF view;
    private PDFGenerator generator; 

    public WritePDFController(WritePDF view) {
        this.view = view;
        this.generator = new PDFGenerator();
    }

    public void generatePDF() {
     
        File pdf = generator.createPDF(view);
        
        if(pdf.exists()){
            
          generator.fillPDF(pdf,,);
        }
    }
}
