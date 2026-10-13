public class ReportService {
    private ReportFormatter formatter;

    public ReportService(ReportFormatter formatter) {
        this.formatter = formatter;
    }

    public void export(Report data) {
        System.out.println(formatter.format(data));
    }

    // public String export(String type, Report data) {
    //     if ("JSON".equalsIgnoreCase(type)) { /* ... */ }
    //     else if ("XML".equalsIgnoreCase(type)) { /* ... */ }
    //     else return "";
}
