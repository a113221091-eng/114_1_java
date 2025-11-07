public class SwordsMan extends Role {
    // 建構子：傳遞給父類別 Role
    public SwordsMan(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    // 攻擊方法：接受任何 Role，並以繁體中文輸出攻擊訊息
    public void attack(Role opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " 攻擊 " + opponent.getName() + "，造成 " + this.getAttackPower() + " 點傷害。");
    }

    @Override
    public String toString() {
        return super.toString() + ", 職業: 劍士";
    }
}