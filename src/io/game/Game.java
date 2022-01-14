package io.game;

public class Game {
    public static void main(String[] args) throws InterruptedException {
        Monster monster = new Monster(100, "troll", 2);
        Player player = new Player("lusket");
        if (player.battle(monster)) {
            System.out.println("you continue on your journey");
        } else {
            System.out.println("Thx for playing!");
            return;
        }
        //more game logic here
    }
}
