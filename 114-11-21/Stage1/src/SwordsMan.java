public class SwordsMan extends Role {

    public SwordsMan(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public void attack(Role opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " 揮劍攻擊 " + opponent.getName() +
                " 造成 " + this.getAttackPower() + " 點傷害。" + opponent);
    }

    @Override
    public void showSkill() {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.printf("┃ %-44s ┃\n", getName() + " 的特殊技能");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        System.out.println();
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.printf("┃ 技能名稱：%-32s ┃\n", "連續斬擊");
        System.out.printf("┃ 技能描述：%-32s ┃\n", "快速揮劍三次");
        System.out.printf("┃ 技能效果：%-32s ┃\n", "造成 150% 傷害");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.println();
    }
}