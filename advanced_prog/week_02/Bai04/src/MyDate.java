public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate(int d, int m, int y) {
        this.day = d;
        this.month = m;
        this.year = y;
    }
    public MyDate(MyDate o) {
        this(o.day, o.month, o.year);
    }
    
    public int getDay() { return this.day; }
    public int getMonth() { return this.month; }
    public int getYear() { return this.year; }
    
    public boolean yearCheck(int y) {
        if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0)
            return true;
        return false;
    }
    public boolean validDate(int d, int m, int y) {
        // int d = dmy.getDay();
        // int m = dmy.getMonth();
        // int y = dmy.getYear();

        if (d < 1 || m < 1 || y < 0) return false;
        if (d > 31 || m > 12) return false;

        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (yearCheck(y)) days[2] = 29;
        if (d > days[m]) return false;
        return true;
    } 

    public boolean setDate(int d, int m, int y) {
        if (validDate(d, m, y)) {
            this.day = d;
            this.month = m;
            this.year = y;
            return true;
        }
        return false;
    }
    public boolean setDay(int d) {
        if (validDate(d, this.month, this.year)) {
            this.day = d;
            return true;
        }
        return false;
    }
    public boolean setMonth(int m) {
        if (validDate(this.day, m, this.year)) {
            this.month = m;
            return true;
        }
        return false;
    }
    public boolean setYear(int y) {
        if (validDate(this.day, this.month, y)) {
            this.year = y;
            return true;
        }
        return false;
    }
}
