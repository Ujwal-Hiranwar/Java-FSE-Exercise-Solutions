package factories;

import implementations.PdfDocumentImpl;
import interfaces.PdfDocument;

public class PdfDocumentFactory extends DocumentFactory {
    public PdfDocument createDocument() {
        return new PdfDocumentImpl();
    }
}
