/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package report.pdfcreater;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;


/**
 *
 * @author ASUS
 */
public class PDFReport {
    
    public static void main (String ar[]) throws ClassNotFoundException, SQLException, DocumentException, FileNotFoundException
    {
        String namafile = "report.pdf";
        
        Document d= new Document();
        PdfWriter.getInstance(d, new FileOutputStream(namafile));
        d.open();
        
        Font f1 = FontFactory.getFont("Times-roman", 18, Font.ITALIC);
        Font f2 = FontFactory.getFont("Arial", 25, Font.UNDERLINE);
        Paragraph p1 = new Paragraph("ayat 1", f1);
        Paragraph p2 = new Paragraph("ayat 2");
        Paragraph p3 = new Paragraph("ayat 3", f2);
        
        int col = 5;
        int row = 3;
        PdfPTable table1 = new PdfPTable(col);
        for (int i = 0; i < row; i++) {
            table1.addCell("a1");
            table1.addCell("a2");
            table1.addCell("a3");
            table1.addCell("a4");
            table1.addCell("a5");
        }
                
        d.add(p1);
        d.add(table1);
        d.add(p3);
        d.add(p2);

        
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File(namafile);
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                System.out.println("Cannot open file!");
                // no application registered for PDFs
            }
        }
        
        d.close();
        
    
    }
    
}