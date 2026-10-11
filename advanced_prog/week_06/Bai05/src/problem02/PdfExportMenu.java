public class PdfExportMenu extends Menu {
    @Override
    public Export createExport() {
        return new PdfExport();
    }
}
