package factories;

import implementations.WordDocumentImpl;
import interfaces.WordDocument;

public class WordDocumentFactory extends DocumentFactory {
    public WordDocument createDocument() {
        return new WordDocumentImpl();
    }
}
