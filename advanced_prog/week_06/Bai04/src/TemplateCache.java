import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class TemplateCache {
    private HashMap<String, ReportTemplate> cache;

    public TemplateCache() {
        cache = new HashMap<String, ReportTemplate>();
        ReportTemplate temp1 = new ReportTemplate("Report 1", "Contact",
                               new ArrayList<>(List.of("Header 1", "Header 2", "Header 3")));
        ReportTemplate temp2 = new ReportTemplate("Math 1", "Contact",
                               new ArrayList<>(List.of("Header 1", "Header 2", "Header 3")));

        cache.put("report01", temp1);
        cache.put("report02", temp2);
    }    

    public ReportTemplate get(String key) {
        return cache.get(key);
    }
}
