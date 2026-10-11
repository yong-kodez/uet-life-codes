public class Main {
    public static void main(String[] args) {
        System.out.println("2) Factory Method");
        PdfExportMenu pdfExp = Menu.getPdfExport();
        ExcelExportMenu excelExp = Menu.getExcelExport();

        pdfExp.doExport();
        excelExp.doExport();
        System.out.println();
    }
}
