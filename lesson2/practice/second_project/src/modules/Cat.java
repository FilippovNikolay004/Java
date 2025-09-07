package modules;

import java.util.GregorianCalendar;

enum EyesColor {
    YELLOW, BLACK, BROWN, GREEN, BLUE, DIFFERENT, BLIND
};

public class Cat {

    // fields
    private int gender;
    private String nick;
    private long craziness;
    private int hungry;
    private String color;
    private int paws = 4; // -128...127
    private int lives = 9;
    private boolean hasTail = true;
    private boolean hasFur = true;
    private EyesColor eyesColor = EyesColor.GREEN;
    private GregorianCalendar birthdate = new GregorianCalendar(2024, 0, 1);
    private String[] favouriteMeal = {"Whiskas", "Milk"};
    private double weight = 5000; // in grams
    private String kind;
    private int energy = 100; // 0...100
    private boolean isAlive = true;

    // constructors, c-tors
    public Cat(String nick, int hungry, int crazy) {
        this.nick = nick;
        this.hungry = hungry;
        craziness = crazy;
    }

    public Cat() {

    }

    // methods
    public void play() {
        if (getPaws() <= 0) {
            System.out.println("Cat has no paws! It doesnt wanna play!");
            return;
        }
        if (getHungry() == 100) {
            System.out.println("Cat is hungry!");
            return;
        }
        if (getEnergy() < 20) {
            System.out.println("Cat is tired!");
            return;
        }
        if (!isIsAlive()) {
            System.out.println("Cat is dead!");
            return;
        }
        setEnergy(getEnergy() - 10);
        setCraziness(getCraziness() + getRandomValue(-5, +5));
        setHungry(getHungry() + getRandomValue(0, 10));
        setWeight(getWeight() - getRandomValue(0, 1000));
    }

    public void sleep() {
        setHungry(100);
        setEnergy(100);
    }

    public void eat(String meal) {
        for (String m : getFavouriteMeal()) {
            if (meal.equals(m)) {
                setHungry(0);
                setEnergy(100);
                setCraziness(getCraziness() - 10);
                setWeight(getWeight() + 1000);
                makeSound();
                return;
            }
        }
        setHungry(getHungry() - 10);
        setEnergy(getEnergy() + 10);
    }

    public void friendship(Cat another) {
        if (this.getGender() == another.getGender()) {
            int situation = getRandomValue(0, 5);
            switch (situation) {
                case 0:
                    this.setLives(this.getLives() - 1);
                    if (this.getLives() <= 0) {
                        this.setIsAlive(false);
                    }
                    break;
                case 1:
                    another.setLives(another.getLives() - 1);
                    if (another.getLives() <= 0) {
                        another.setIsAlive(false);
                    }
                    break;
                case 2:
                    this.setPaws((byte) (this.getPaws() - 1));
                    if (this.getPaws() < 0) {
                        this.setPaws((byte) 0);
                    }
                    break;
                case 3:
                    another.setPaws((byte) (another.getPaws() - 1));
                    if (another.getPaws() < 0) {
                        another.setPaws((byte) 0);
                    }
                    break;
                case 4:
                    this.setHasTail(false);
                    break;
                case 5:
                    another.setHasTail(false);
                    break;
            }
        }
    }

    public void makeSound() {
        System.out.println("MEOW MEOW!");
    }

    public static int getRandomValue(int min, int max) {
        int count = max - min + 1;
        int value = (int) (Math.random() * count) + min;
        return value;
    }

    public void print() {
        System.out.println("================================");
        System.out.println("Name: " + getNick());
        System.out.println("Craziness: " + getCraziness());
        System.out.println("Hungry: " + getHungry());
        System.out.println("Paws: " + getPaws());
        System.out.println("Lives: " + getLives());
        System.out.println("Weight: " + getWeight());
        System.out.println("Energy: " + getEnergy());
        System.out.println("================================");
    }

    public String toString() {
    	return nick + " " + paws;
    }
    
    /**
     * @return the gender
     */
    public int getGender() {
        return gender;
    }
    /**
     * @param gender the gender to set
     */
    public void setGender(int gender) {
        this.gender = gender;
    }

    /**
     * @return the nick
     */
    public String getNick() {
        return nick;
    }
    /**
     * @param nick the nick to set
     */
    public void setNick(String nick) {
        this.nick = nick;
    }

    /**
     * @return the craziness
     */
    public long getCraziness() {
        return craziness;
    }
    /**
     * @param craziness the craziness to set
     */
    public void setCraziness(long craziness) {
        this.craziness = craziness;
    }

    /**
     * @return the hungry
     */
    public int getHungry() {
        return hungry;
    }
    /**
     * @param hungry the hungry to set
     */
    public void setHungry(int hungry) {
        this.hungry = hungry;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }
    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the paws
     */
    public int getPaws() {
        return paws;
    }
    /**
     * @param paws the paws to set
     */
    public void setPaws(int paws) {
        if (paws < 0 || paws > 4) {
            paws = 4;
        }
        this.paws = paws;
    }

    /**
     * @return the lives
     */
    public int getLives() {
        return lives;
    }

    /**
     * @param lives the lives to set
     */
    public void setLives(int lives) {
        this.lives = lives;
    }

    /**
     * @return the hasTail
     */
    public boolean isHasTail() {
        return hasTail;
    }

    /**
     * @param hasTail the hasTail to set
     */
    public void setHasTail(boolean hasTail) {
        this.hasTail = hasTail;
    }

    /**
     * @return the hasFur
     */
    public boolean isHasFur() {
        return hasFur;
    }

    /**
     * @param hasFur the hasFur to set
     */
    public void setHasFur(boolean hasFur) {
        this.hasFur = hasFur;
    }

    /**
     * @return the eyesColor
     */
    public EyesColor getEyesColor() {
        return eyesColor;
    }

    /**
     * @param eyesColor the eyesColor to set
     */
    public void setEyesColor(EyesColor eyesColor) {
        this.eyesColor = eyesColor;
    }

    /**
     * @return the birthdate
     */
    public GregorianCalendar getBirthdate() {
        return birthdate;
    }

    /**
     * @param birthdate the birthdate to set
     */
    public void setBirthdate(GregorianCalendar birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * @return the favouriteMeal
     */
    public String[] getFavouriteMeal() {
        return favouriteMeal;
    }

    /**
     * @param favouriteMeal the favouriteMeal to set
     */
    public void setFavouriteMeal(String[] favouriteMeal) {
        this.favouriteMeal = favouriteMeal;
    }

    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * @return the kind
     */
    public String getKind() {
        return kind;
    }

    /**
     * @param kind the kind to set
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * @return the energy
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * @param energy the energy to set
     */
    public void setEnergy(int energy) {
        this.energy = energy;
    }

    /**
     * @return the isAlive
     */
    public boolean isIsAlive() {
        return isAlive;
    }

    /**
     * @param isAlive the isAlive to set
     */
    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
}
