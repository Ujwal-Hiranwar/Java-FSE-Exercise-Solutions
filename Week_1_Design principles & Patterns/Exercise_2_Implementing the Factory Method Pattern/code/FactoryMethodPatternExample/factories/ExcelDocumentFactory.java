package factories;

import implementations.ExcelDocumentImpl;
import interfaces.ExcelDocument;

public class ExcelDocumentFactory extends DocumentFactory {
    public ExcelDocument createDocument() {
        return new ExcelDocumentImpl();
    }
}
