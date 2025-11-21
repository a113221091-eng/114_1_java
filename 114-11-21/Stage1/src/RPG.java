public class RPG {
    public static void main(String[] args) {

        SwordsMan swordsMan_light = new SwordsMan("光明劍士", 100, 20);
        SwordsMan swordsMan_dark = new SwordsMan("黑暗劍士", 100, 25);

        Magician magician_light = new Magician("光明法師", 80, 15, 10);
        Magician magician_dark = new Magician("黑暗法師", 80, 20, 5);

        ShieldSwordsMan shieldSwordsMan = new ShieldSwordsMan("持盾劍士", 120, 18, 8);

        Role[] gameRoles = {
                swordsMan_light, swordsMan_dark,
                magician_light, magician_dark,
                shieldSwordsMan
        };

// 技能展示（改成圖片框）
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃ 角色特殊技能展示 ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.println();

        for (Role r : gameRoles) {
            r.showSkill();
        }

        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃ 戰鬥開始！ ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        for (Role currentRole : gameRoles) {
            if (!currentRole.isAlive()) {
                continue;
            }

            if (currentRole instanceof SwordsMan) {
                Role target = gameRoles[(int) (Math.random() * gameRoles.length)];
                if (target instanceof ShieldSwordsMan)
                    ((ShieldSwordsMan) target).defence();
                currentRole.attack(target);
            } else if (currentRole instanceof Magician) {
                Magician magician = (Magician) currentRole;

                if (Math.random() < 0.5) {
                    Role target = gameRoles[(int) (Math.random() * gameRoles.length)];
                    if (target instanceof ShieldSwordsMan)
                        ((ShieldSwordsMan) target).defence();
                    currentRole.attack(target);
                } else {
                    magician.heal(gameRoles[(int) (Math.random() * gameRoles.length)]);
                }
            }
        }
    }
}
