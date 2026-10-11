public abstract class Menu {
    public static PdfExportMenu getPdfExport() {
        return new PdfExportMenu();
    }

    public static ExcelExportMenu getExcelExport() {
        return new ExcelExportMenu();
    }

    public void doExport() {
        Export exp = createExport();
        exp.export();
    }

    public abstract Export createExport();
}
