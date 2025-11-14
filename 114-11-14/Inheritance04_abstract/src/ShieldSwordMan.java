public class ShieldSwordMan extends SwordsMan {

    private int defenseCapacity;

    // 建構子：初始化持盾劍士的名稱、生命值和攻擊力
    public ShieldSwordMan(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    // 攻擊對手（劍客／魔法師），對類別的參考指到了類別物件
    @Override
    public void attack(Role opponent) {
        int reducedDamage = this.getAttackPower() - 5;  // 持盾劍士攻擊力減少5點
        opponent.setHealth(opponent.getHealth() - reducedDamage);

        System.out.println(
                this.getName() + " 持劍攻擊 " + opponent.getName() +
                        "，造成 " + reducedDamage + " 點傷害 " + opponent
        );
    }
    public int getDefenseCapacity() {
        return defenseCapacity;
    }

    public void defense(){
        this.setHealth(this.getHealth()+defenseCapacity);
        System.out.println(this.getName()+ " 使用防禦，增加 " + defenseCapacity + " 點生命值。" + this);
    }
}

