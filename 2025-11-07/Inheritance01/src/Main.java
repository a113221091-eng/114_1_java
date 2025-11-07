// 提示：要執行程式，按 <shortcut actionId="Run"/> 或點擊工具列的執行圖示。
// 提示：將游標置於被標示的文字上，按 <shortcut actionId="ShowIntentionActions"/> 可查看 IntelliJ 的修正建議。
public class Main {
    public static void main(String[] args) {
        // 啟動訊息
        System.out.println("Hello，歡迎！");

        // 範例迴圈
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }

        // 建立角色並示範攻擊與治癒
        SwordsMan swordsMan = new SwordsMan("亞瑟", 100, 20);
        Magician magician = new Magician("梅林", 80, 10, 15);

        System.out.println(swordsMan);
        System.out.println(magician);

        // 劍士攻擊魔法師
        swordsMan.attack(magician);
        // 魔法師治癒劍士
        magician.heal(swordsMan);

        System.out.println("攻擊與治癒後狀態：");
        System.out.println(swordsMan);
        System.out.println(magician);
    }
}
