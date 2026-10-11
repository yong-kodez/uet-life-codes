import java.util.List;
import java.util.ArrayList;

public class ReportTemplate implements Prototype {
    private String title;
    private String footer;
    private List<String> sections;

    public ReportTemplate(String title, String footer, List<String> sections) {
        this.title = title;
        this.footer = footer;
        this.sections = sections;
    }

    public ReportTemplate(ReportTemplate rt) {
        this.title = rt.title;
        this.footer = rt.footer;
        this.sections = new ArrayList<>(rt.sections);
    }

    public void setTitle(String title) { this.title = title; }

    @Override
    public ReportTemplate clone() {
        return new ReportTemplate(this);
    }

    @Override
    public String toString() {
        String fmt = "* " + title;
        for (String s : sections) {
            fmt += "\n  - " + s;
        }
        fmt += "\n# " + footer;
        return fmt;
    }
}
