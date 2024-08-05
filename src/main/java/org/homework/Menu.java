package org.homework;

import java.util.Arrays;

public enum Menu {
    NONE(0),ADD(1),DELETE(2),SELECT(3),SELECTALL(4),SEARCH(5),EXIT(6);

    private final int value;
    Menu(int value) {
        this.value = value;
    }

    public static Menu get(int value) {
        return Arrays.stream(values())
                .filter(menu -> menu.value == value)
                .findAny()
                .orElse(NONE);
    }
}
