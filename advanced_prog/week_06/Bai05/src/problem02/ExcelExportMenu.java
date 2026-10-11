public class ExcelExportMenu extends Menu {
    @Override
    public Export createExport() {
        return new ExcelExport();
    }
}
