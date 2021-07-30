package com.app;

public enum Menu {
    REGISTER_TASK("0"),
    UPDATE_TASK("1"),
    REMOVE_TASK("2"),
    SHOW_ALL_TASK("3"),
    SHOW_MATRIX_TASK("4"),
    FINISH("5");
    private final String menuNum;

    Menu(String menuNum) {
        this.menuNum = menuNum;
    }

    public String getMenuNum() {
        return this.menuNum;
    }

    public Menu toMenu(String menuNum) {
        for (Menu m : values()) {
            if (m.getMenuNum().equals(menuNum)) {
                return m;
            }
        }
        return Menu.FINISH;
    }

    public static int getLength() {
        return Menu.values().length;
    }
}
