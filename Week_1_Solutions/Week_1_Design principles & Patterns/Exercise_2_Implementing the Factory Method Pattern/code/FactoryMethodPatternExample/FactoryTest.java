import factories.ExcelDocumentFactory;
import factories.PdfDocumentFactory;
import factories.WordDocumentFactory;
import interfaces.ExcelDocument;
import interfaces.PdfDocument;
import interfaces.WordDocument;

public class FactoryTest {
    public static void main(String[] args) {
        WordDocumentFactory wordFactory = new WordDocumentFactory();
        WordDocument wordDoc = wordFactory.createDocument();
        wordDoc.openWord();

        PdfDocumentFactory pdfFactory = new PdfDocumentFactory();
        PdfDocument pdfDoc = pdfFactory.createDocument();
        pdfDoc.openPdf();

        ExcelDocumentFactory excelFactory = new ExcelDocumentFactory();
        ExcelDocument excelDoc = excelFactory.createDocument();
        excelDoc.openExcel();
    }
}