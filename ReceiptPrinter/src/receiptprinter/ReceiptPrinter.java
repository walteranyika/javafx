/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package receiptprinter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

/**
 *
 * @author waltersanchez
 */
public class ReceiptPrinter {
    StringBuilder sb=new StringBuilder();
    private double total = 0;
    private Formatter f = new Formatter(sb);

    public void printTitle() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Date date = new Date();
        String now=dateFormat.format(date);
        f.format("%25s\n", "Belkins Restaurant");
        f.format("%24s\n", now);
        f.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
        f.format("%-15s %5s %10s\n", "----", "---", "-----");
    }

    public void print(String name, int qty, double price) {
        f.format("%-15.15s %5d %10.2f\n", name, qty, price);
        total += price;
    }

    public void printTotal() {
        f.format("%-15s %5s %10.2f\n", "Tax", "", total * 0.06);
        f.format("%-15s %5s %10s\n", "", "", "-----");
        f.format("%-15s %5s %10.2f\n", "Total", "", total * 1.06);
    }

    public String getReceipt()
    {
     return sb.toString();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ReceiptPrinter receipt = new ReceiptPrinter();
        receipt.printTitle();
        receipt.print("Jack's Magic Beans", 4, 4.25);
        receipt.print("Princess Peas", 3, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();
        System.out.println(receipt.getReceipt());
        
        
    }

}
