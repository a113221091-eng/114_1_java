public class Time2 {
    private int hour; // 0 - 23
    private int minute; // 0 - 59
    private int second; // 0 - 59

    // 無參數建構子：
    // 將每個成員變數初始化為零
    public Time2() {
        this(0, 0, 0); // 呼叫三參數建構子
    }

    // 建構子：提供 hour，minute 與 second 預設為 0
    public Time2(int hour) {
        this(hour, 0, 0); // 呼叫三參數建構子
    }

    // 建構子：提供 hour 與 minute，second 預設為 0
    public Time2(int hour, int minute) {
        this(hour, minute, 0); // 呼叫三參數建構子
    }

    // 建構子：提供 hour, minute, second
    public Time2(int hour, int minute, int second) {
        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("小時必須為 0-23");
        }

        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("分鐘必須為 0-59");
        }

        if (second < 0 || second >= 60) {
            throw new IllegalArgumentException("秒數必須為 0-59");
        }

        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    // 建構子：使用另一個 Time2 物件建立
    public Time2(Time2 time) {
        // 呼叫三參數建構子
        this(time.hour, time.minute, time.second);
    }

    // 設定方法
    // 使用 24 小時制設定時間；驗證資料
    public void setTime(int hour, int minute, int second) {
        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("小時必須為 0-23");
        }

        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("分鐘必須為 0-59");
        }

        if (second < 0 || second >= 60) {
            throw new IllegalArgumentException("秒數必須為 0-59");
        }

        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    // 驗證並設定小時
    public void setHour(int hour) {
        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("小時必須為 0-23");
        }

        this.hour = hour;
    }

    // 驗證並設定分鐘
    public void setMinute(int minute) {
        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("分鐘必須為 0-59");
        }

        this.minute = minute;
    }

    // 驗證並設定秒數
    public void setSecond(int second) {
        if (second < 0 || second >= 60) {
            throw new IllegalArgumentException("秒數必須為 0-59");
        }

        this.second = second;
    }

    // 取得小時
    public int getHour() {return hour;}

    // 取得分鐘
    public int getMinute() {return minute;}

    // 取得秒數
    public int getSecond() {return second;}

    // 轉換為 24 小時制字串 (HH:MM:SS)
    public String toUniversalString() {
        return String.format(
                "%02d:%02d:%02d", getHour(), getMinute(), getSecond());
    }

    // 轉換為標準時間字串 (H:MM:SS 上午或下午)
    public String toString() {
        String period = (getHour() < 12 ? "上午" : "下午");
        return String.format("%d:%02d:%02d %s",
                ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
                getMinute(), getSecond(), period);
    }
}