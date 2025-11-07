public class Magician extends Role {
    // 治癒力
    private int healPower;

    // 建構子：姓名、生命值、攻擊力、治癒力（順序與型別配合父類別 Role）
    public Magician(String name, int health, int attackPower, int healPower) {
        super(name, health, attackPower);
        this.healPower = healPower;
    }

    // 取得治癒力
    public int getHealPower() {
        return healPower;
    }
    // 攻擊對手（接受 Role，可攻擊任何角色）
    public void attack(Role opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " 攻擊 " + opponent.getName() + "，造成 " + this.getAttackPower() + " 點傷害！");
    }
    // 治癒隊友（接受 Role，使用父類別的 getter/setter）
    public void heal(Role ally) {
        ally.setHealth(ally.getHealth() + this.healPower);
        System.out.println(this.getName() + " 治癒 " + ally.getName() + "，恢復 " + healPower + " 點生命值！");
    }

    public String toString() {
        return super.toString() + ", 治癒力: " + healPower;
    }
}