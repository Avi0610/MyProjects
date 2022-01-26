package de.vogella.itext.write;
import com.avinash.jdbc.daos.StoreSalesDao;
import com.avinash.jdbc.daos.StoreSalesDeatailsDao;
import com.avinash.jdbc.pojos.SellingList;
import com.avinash.jdbc.pojos.StoreSales;
import com.avinash.jdbc.daos.StoreSalesDao;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.text.StyledEditorKit.UnderlineAction;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class FirstPdf {
    public static String FILE = "G:/project/";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD,BaseColor.RED);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);

    public static void main(String[] args) {
        try {
            Document document = new Document();
            StoreSalesDao ssd = new StoreSalesDao();
           PdfWriter.getInstance(document, new FileOutputStream(FILE+ssd.findLastSalesId().getStoreSalesId()+".pdf"));
            document.open();
            
            //addMetaData(document);
            addTitlePage(document);
            //addContent(document);
            
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void addTitlePage(Document document)
            throws DocumentException {
        Paragraph preface = new Paragraph();
        // We add one empty line
        addEmptyLine(preface, 1);
        // Lets write a big header
       
       
        preface.add(new Paragraph("XYZ STORES", catFont));

        
        addEmptyLine(preface, 1);
        preface.setAlignment(Element.ALIGN_LEFT);
        // Will create: Report generated by: _name, _date
        StoreSalesDao ssd = new StoreSalesDao();
        preface.add(new Paragraph(
                "Bill Created in store: " + System.getProperty("user.name") + ", " + new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                smallBold));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph(
                "Your Cash Memo For your Purchase Is ",
                smallBold));
        
        addEmptyLine(preface, 3);
        
    
     
        Anchor anchor = new Anchor("", catFont);
        Chapter catPart = new Chapter(new Paragraph(anchor),1);

       
        Section subCatPart = catPart.addSection(preface);
        preface = new Paragraph("", subFont);
        createTable(subCatPart);
        document.add(preface);
        document.add(catPart);
        
        StoreSales ss  = new StoreSales();
		StoreSalesDao ssd1 = new StoreSalesDao();
		ss = ssd1.findFinal(ssd.findLastSalesId().getStoreSalesId());
		
		preface.setAlignment(Element.ALIGN_RIGHT);
		preface.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD,BaseColor.GREEN));
		
		preface.add("Amount = "+ss.getAmount()+"\n");
		preface.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 12,
	            Font.BOLD,BaseColor.RED));
		preface.add("Discount = "+ss.getDiscount()+"\n");
		preface.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 12,
	            Font.BOLD,BaseColor.BLUE));
		preface.add("Payable = "+ss.getTotalPayable()+"\n");
		
		document.add(preface);
		
	
		
		//catPart = new Chapter(new Paragraph(anchor), 1);
		
	
        //document.add(preface);
        
       
        // Start a new page
        
       // document.newPage();
    }



    public static void createTable(Section subCatPart)
            throws BadElementException {
        PdfPTable table = new PdfPTable(7);

//         t.setBorderColor(BaseColor.GRAY);
//         t.setPadding(4);
//         t.setSpacing(4);
//         t.setBorderWidth(1);

        PdfPCell c1 = new PdfPCell(new Phrase("proId"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("pro Nmae"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Quantity"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Rate"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Cgst"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Sgst"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("payable"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        table.setHeaderRows(1);
        
		StoreSalesDao ssd = new StoreSalesDao();
		
        
        StoreSalesDeatailsDao ssdd1  = new StoreSalesDeatailsDao();
		ArrayList<SellingList> al1 = ssdd1.findAllByStoreSalesId(ssd.findLastSalesId().getStoreSalesId());
		
		for (SellingList sl : al1) {
			
			 table.addCell(""+sl.getpId());
			 table.addCell(""+sl.getpName());
			 table.addCell(""+sl.getQuantity());
			 table.addCell(""+sl.getSp());
			 table.addCell(""+sl.getCgst());
			 table.addCell(""+sl.getSgst());
			 table.addCell(""+sl.getPayable());
			
		}
		subCatPart.add(table);

      

    }



    public static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
