/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyTools;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class PrintInvoice implements Printable{

    JFrame frame;
    
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if(pageIndex > 0)
            return NO_SUCH_PAGE;
        
        Graphics2D g = (Graphics2D)graphics;
        g.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        
        frame.printComponents(graphics);
        
        return PAGE_EXISTS;
    }
    
    public PrintInvoice(JFrame parent){
        frame = parent;
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        boolean ok = job.printDialog();
        
        if(ok){
            try {
                job.print();
            } catch (PrinterException ex) {
                Logger.getLogger(PrintInvoice.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
