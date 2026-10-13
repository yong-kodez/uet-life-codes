public class Main {
    public static void main(String[] args) {
        ReportService toJson = new ReportService(new JsonFormatter());
        ReportService toXml = new ReportService(new XmlFormatter());

        Report sample1 = new Report("Very good title", "Some useful contents");
        Report sample2 = new Report("Another good title", "Really facinating contents");

        toJson.export(sample1);
        toXml.export(sample2);
    }
}
