public class XmlFormatter implements ReportFormatter {
    @Override
    public String format(Report data) {
        System.out.println("...Converting to XML");
        String fmt = "<report>\n";
        fmt += "  <title>" + data.getTitle() + "</title>\n";
        fmt += "  <content>" + data.getContent() + "</content>\n";
        fmt += "</report>";
        return fmt;
    }
}
