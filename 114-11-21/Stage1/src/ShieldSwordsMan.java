public class ShieldSwordsMan extends SwordsMan {

    private int defenseCapacity;

    public ShieldSwordsMan(String name, int health, int attackPower, int defenseCapacity) {
        super(name, health, attackPower);
        this.defenseCapacity = defenseCapacity;
    }

    @Override
    public void attack(Role opponent) {
        int reducedDamage = this.getAttackPower() - 5;
        opponent.setHealth(opponent.getHealth() - reducedDamage);
        System.out.println(this.getName() + " 揮劍攻擊 " + opponent.getName() +
                " 造成 " + reducedDamage + " 點傷害。" + opponent);
    }

    public int getDefenseCapacity() {
        return defenseCapacity;
    }

    public void defence() {
        this.setHealth(this.getHealth() + defenseCapacity);
        System.out.println(this.getName() + " 使用盾牌防禦，恢復 " +
                defenseCapacity + " 點生命值。" + this);
    }

    @Override
    public void showSkill() {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.printf("┃ %-44s ┃\n", getName() + " 的特殊技能");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        System.out.println();
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.printf("┃ 技能名稱：%-32s ┃\n", "盾牌猛擊");
        System.out.printf("┃ 技能描述：%-32s ┃\n", "使用盾牌撞擊敵人");
        System.out.printf("┃ 技能效果：%-32s ┃\n", "造成傷害並暈眩");
        System.out.printf("┃ 防禦加成：%-32s ┃\n", "+8 防禦力");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.println();
    }
}