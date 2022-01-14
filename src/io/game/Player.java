package io.game;

import java.util.Random;

public class Player {
    private final static Random r = new Random();
    private final String playerName;
    private int maxHP = 100;
    private int hp = 100;
    private int baseDamage = 3;
    private int level = 1;
    private Weapon weapon;

    public Player(String playerName) {
        this.playerName = playerName;
    }


    //Returns true if we win, false if we lose
    public boolean battle(Monster monster) throws InterruptedException {
        while (true) {
            monster.attack(this);
            if (this.isDead()) {
                System.out.println("You didnt survive the battle against " + monster.getName());
                return false;
            }
            this.attack(monster);
            if (monster.isDead()) {
                System.out.println("You killed the monster, yay");
                return true;
            }
            Thread.sleep(300); //So the game doesnt finish instant
            System.out.println();
            System.out.println();
        }
    }

    private void attack(Monster monster) {
        double damage = getDamage(); //saving it here so we can show how much damage and use the same number for decreaseHP(as the getDamage method is random based)
        monster.decreaseHP(damage);
        System.out.println("You did " + damage + " damage to " + monster.getName() + " it now has " + monster.getHp() + " HP left");
    }

    private boolean isDead() {
        return hp <= 0;
    }

    public double getDamage() {
        double damage = r.nextInt(baseDamage) + 2 + level * 2;
        if (weapon != null) {
            return damage + weapon.getDamage();
        }
        return damage;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String getName() {
        return playerName;
    }

    public void decreaseHP(int damage) {
        hp -= damage;
        if (hp <= 0) {
            hp = 0;
        }
    }

    public int getHP() {
        return hp;
    }
}
