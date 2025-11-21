public class Magician extends Role {

    private int mana;

    public Magician(String name, int health, int attackPower, int mana) {
        super(name, health, attackPower);
        this.mana = mana;
    }

    @Override
    public void attack(Role opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " 施放魔法攻擊 " + opponent.getName() +
                " 造成 " + this.getAttackPower() + " 點傷害。" + opponent);
    }

    public void heal(Role ally) {
        ally.setHealth(ally.getHealth() + mana);
        System.out.println(this.getName() + " 對 " + ally.getName() +
                " 施放治癒，恢復 " + mana + " 點生命值。" + ally);
    }

    @Override
    public void showSkill() {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.printf("┃ %-44s ┃\n", getName() + " 的特殊技能");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        System.out.println();
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.printf("┃ 技能名稱：%-32s ┃\n", "元素爆發");
        System.out.printf("┃ 技能描述：%-32s ┃\n", "召喚強大魔法攻擊");
        System.out.printf("┃ 技能效果：%-32s ┃\n", "範圍魔法傷害");
        System.out.printf("┃ 額外效果：%-32s ┃\n", "恢復自身魔力");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.println();
    }
}