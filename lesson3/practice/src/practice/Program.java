package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Monster {
    String name;
    int health;
    int ammo;

    public Monster(int health, int ammo, String name) {
        this.health = health;
        this.ammo = ammo;
        this.name = name;
    }

    public void about() {
        System.out.println("Monster " + name + " with health = " + health + " and ammo =  " + ammo);
    }

}

class SortByHealth implements Comparator<Monster> {
	@Override
    public int compare(Monster m1, Monster m2) {
        if (m1.health > m2.health) return 1;
        if (m1.health < m2.health) return -1;
        
        return 0;
    }
}
class SortByName implements Comparator<Monster> {
    @Override
    public int compare(Monster m1, Monster m2) {
        return m1.name.compareToIgnoreCase(m2.name);
    }
}


public class Program {
    public static void main(String[] args) {

        var m1 = new Monster(70, 20, "Mike Wazowski");
        var m2 = new Monster(90, 20, "Sullivan");
        var m3 = new Monster(80, 20, "Johnny Worthington");

        List<Monster> crowd = new ArrayList<>();
        crowd.add(m1);
        crowd.add(m2);
        crowd.add(m3);

        Collections.sort(crowd, new SortByHealth());
        for (Monster m : crowd) {
            m.about();
        }
        
        Collections.sort(crowd, new SortByName());
        for (Monster m : crowd) {
            m.about();
        }
    }
}

