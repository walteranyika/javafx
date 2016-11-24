/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printingsample;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JTextArea;

public class PrintingSample {

    public static void main(String[] args) {
        PrintingSample s=new PrintingSample();
        s.a();
    }
    public void a() {
        PageFormat format = new PageFormat();
        Paper paper = new Paper();

        double paperWidth = 3;//3.25
        double paperHeight = 3.69;//11.69
        double leftMargin = 0.12;
        double rightMargin = 0.10;
        double topMargin = 0;
        double bottomMargin = 0.01;

        paper.setSize(paperWidth * 200, paperHeight * 200);
        paper.setImageableArea(leftMargin * 200, topMargin * 200,
                (paperWidth - leftMargin - rightMargin) * 200,
                (paperHeight - topMargin - bottomMargin) * 200);

        format.setPaper(paper);

        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        aset.add(OrientationRequested.PORTRAIT);
//testing 

        PrinterJob printerJob = PrinterJob.getPrinterJob();
        Printable printable = new ReceiptPrint();

        format = printerJob.validatePage(format);
        boolean don = printerJob.printDialog();
        printerJob.setPrintable(printable, format);
        try {
            printerJob.print(aset);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class ReceiptPrint implements Printable {

     public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
            throws PrinterException {

        
        String strText = null;
        
        int lineStart;           // start index of line in textarea
        int lineEnd;             // end index of line in textarea
        int lineNumber;
        int lineCount;
        
        Graphics2D g2d = (Graphics2D) graphics;
        Font font = new Font("MONOSPACED", Font.BOLD, 9);

        if (pageIndex < 0 || pageIndex >= 1) {
            return Printable.NO_SUCH_PAGE;
        }
        JTextArea textarea = new JTextArea(10, 40);
        ReceiptPrinter receipt = new ReceiptPrinter();
        receipt.printTitle();
        receipt.print("Jack's Magic Beans", 4, 4.25);
        receipt.print("Princess Peas", 3, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();
        System.out.println(receipt.getReceipt());  
        
        textarea.append(receipt.getReceipt());
        
        textarea.setEditable(false);

        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        g2d.setFont(font);
        lineNumber = 0;
        lineCount = textarea.getLineCount();
        strText = textarea.getText();
        /*MediaTracker mt = new MediaTracker(textarea);
         URL imageURL = null;
         try {

         imageURL = new URL(mainDirectory+"quindell.png");
         } catch (MalformedURLException me) {
         me.printStackTrace();
         }

         //--- Load the image and wait for it to load
         Image image = Toolkit.getDefaultToolkit().getImage(imageURL);
         mt.addImage(image, 0);
         */

        while (lineCount != 0) {
            try {

                lineStart = textarea.getLineStartOffset(lineNumber);
                lineEnd = textarea.getLineEndOffset(lineNumber);
                strText = textarea.getText(lineStart, lineEnd - lineStart);
            } catch (Exception exception) {
                System.out.println("Printing error:" + exception);                  // have to catch BadLocationException
            }

            g2d.drawString(strText, 1, (lineNumber + 1) * 18);
            //spacing    between lines
            lineNumber = lineNumber + 1;
            lineCount--;
        }
        //g2d.drawString(null, lineEnd, lineEnd);
        return Printable.PAGE_EXISTS;
    }
}