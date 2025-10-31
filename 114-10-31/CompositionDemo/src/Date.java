public class Date {
    private int month; // 1-12
    private int day; // 1-31 based on month
    private int year; // any year

    private static final int[] daysPerMonth =
            {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // 建構子：確認給定年份下月份與日期是否正確
    public Date(int month, int day, int year) {
        // 檢查月份是否在範圍內
        if (month <= 0 || month > 12) {
            throw new IllegalArgumentException(
                    "月份 (" + month + ") 必須為 1-12");
        }

        // 檢查該月份的日期是否在合理範圍
        if (day <= 0 ||
                (day > daysPerMonth[month] && !(month == 2 && day == 29))) {
            throw new IllegalArgumentException("日期 (" + day + ") 超出該月份與年份的範圍");
        }

        // 若為二月 29 日，檢查是否為閏年
        if (month == 2 && day == 29 && !(year % 400 == 0 ||
                (year % 4 == 0 && year % 100 != 0))) {
            throw new IllegalArgumentException("日期 (" + day + ") 超出該月份與年份的範圍");
        }

        this.month = month;
        this.day = day;
        this.year = year;

        //System.out.printf("Date 建構子建立日期物件: %s%n", this);
    }

    // 回傳格式為 month/day/year 的字串
    public String toString() {
        return String.format("%d/%d/%d", month, day, year);
    }
}