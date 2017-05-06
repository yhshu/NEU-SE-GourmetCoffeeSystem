import java.io.FileNotFoundException;
import java.io.IOException;

public interface CatalogLoader {
    Catalog loadCatalog(String var1) throws FileNotFoundException, IOException, DataFormatException;
}