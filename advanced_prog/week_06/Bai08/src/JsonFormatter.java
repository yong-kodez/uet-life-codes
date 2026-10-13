public class JsonFormatter implements ReportFormatter {
    @Override
    public String format(Report data) {
        System.out.println("...Converting to JSON");
        String fmt = "{\n";
        fmt += "  \"title\": \"" + data.getTitle() + "\",\n";
        fmt += "  \"content\": \"" + data.getContent() + "\"\n";
        fmt += "}";
        return fmt;
    }
}
