package com.app;

public enum Menu {
    REGISTER_TASK("0"),
    REMOVE_TASK("1"),
    SHOW_ALL_TASK("2"),
    SHOW_MATRIX_TASK("3"),
    FINISH("4");
    private final String menuName;

    Menu (String menuName){
        this.menuName = menuName;
    }

    public String getMenu(){
        return this.menuName;
    }

    public Menu toMenu(String menuName) {
        for (Menu m : values()) {
            if (m.getMenu().equals(menuName)) {
                return m;
            }
        }
        return Menu.FINISH;
    }
}
