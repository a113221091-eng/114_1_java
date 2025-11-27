public abstract class Role {
    private String name;
    private int health;
    private int attackPower;

    public Role(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public abstract void attack(Role opponent);

    public abstract void showSkill();

    @Override
    public String toString() {
        return "角色名稱: " + name + ", 生命值: " + health;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        System.out.println("💥 " + name + " 受到 " + damage + " 點傷害！目前生命值：" + health);

        if (!isAlive()) {
            onDeath();
        }
    }

    public abstract void onDeath();

    public abstract void prepareBattle();

    public abstract void afterBattle();
}
