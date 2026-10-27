package com.scc.ui;

import com.scc.model.User;
import java.util.Scanner;

public final class AdminMenu extends UserMenu {
    public AdminMenu(Scanner scanner, User user) {
        super(scanner, user, "ADMIN MENU");
    }
}
