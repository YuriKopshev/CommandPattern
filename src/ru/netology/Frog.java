package ru.netology;

public class Frog {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 10;

    protected int position;

    public Frog() {
        position = 5;
    }

    public boolean jump(int steps) {
        // сделаем прыжок, если прыжок слишком большой
        // для поля, то не прыгнем и вернём false
        return (getPosition() + steps) < MAX_POSITION;
    }

    public static int getMinPosition() {
        return MIN_POSITION;
    }

    public static int getMaxPosition() {
        return MAX_POSITION;
    }

    public int getPosition() {
        return position;
    }
}
