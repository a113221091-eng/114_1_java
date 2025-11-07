public class RPG {
    public static void main(String[] args) {
        //建立劍士和魔法師角色
        SwordsMan swordsMan_light = new SwordsMan("光之劍士", 30, 150);
        SwordsMan swordsMan_dark = new SwordsMan("暗之劍士", 25, 180);
        Magician magician_light = new Magician("光之魔法師", 20, 100, 15);
        Magician magician_dark = new Magician("暗之魔法師", 22, 120, 18);

        //戰鬥過程
        System.out.println(" 戰鬥開始 ");
        swordsMan_light.attack(swordsMan_dark);
        magician_dark.heal(swordsMan_dark);
        magician_light.attack(magician_dark);
    }
}