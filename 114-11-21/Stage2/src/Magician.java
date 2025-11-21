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

    @Override
    public void onDeath() {
        System.out.println("💀 " + this.getName() + " 的生命之火熄滅了...");
        System.out.println("✨ " + this.getName() + " 的身體化為無數魔法粒子，消散在空氣中。");
        System.out.println("🌟 魔法書掉落在地上，微微發光。");
        System.out.println("---");
    }

    /**
     * 魔法師的戰前準備
     * 吟唱咒語，準備施法
     */
    @Override
    public void prepareBattle() {
        System.out.println("📖 " + this.getName() + " 翻開魔法書，開始吟唱古老的咒語...");
        System.out.println("✨ 魔法能量在周圍凝聚，空氣中閃爍著神秘的光芒。");
    }

    /**
     * 魔法師的戰後行為
     * 冥想恢復魔力
     */
    @Override
    public void afterBattle() {
        System.out.println("🧘 " + this.getName() + " 閉目冥想，恢復消耗的魔力。");
    }

}