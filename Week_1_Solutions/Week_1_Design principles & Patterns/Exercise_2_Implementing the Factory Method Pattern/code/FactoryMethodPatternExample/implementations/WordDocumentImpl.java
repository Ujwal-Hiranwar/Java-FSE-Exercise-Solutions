package implementations;

import interfaces.ExcelDocument;
import interfaces.PdfDocument;
import interfaces.WordDocument;

public class WordDocumentImpl implements WordDocument {
    public void openWord() {
        System.out.println("Opening a Word document.");
    }
}




