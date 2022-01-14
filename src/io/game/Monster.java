package io.game;

public class Monster {
    private final String name;
    private int hp;
    private int baseDamage;

    public Monster(int hp, String name, int baseDamage) {
        this.hp = hp;
        this.name = name;
        this.baseDamage = baseDamage;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void attack(Player p) {
        int damage = getDamage();
        System.out.println(name + " did " + damage + " damage to you, you now have " + p.getHP() + " HP left");
        p.decreaseHP(damage);
    }


    public int getDamage() {
        return baseDamage; //a bit simpler than the player damage
    }

    public void decreaseHP(double damage) {
        this.hp -= damage;
        if (hp <= 0) {
            hp = 0;
        }
    }

    public boolean isDead() {
        return hp <= 0;
    }
}
