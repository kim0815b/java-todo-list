package org.homework;

import java.util.Arrays;

public enum Menu {
    NONE(0),ADD(1),DELETE(2),SELECT(3),SEARCH(4),EXIT(5);

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
