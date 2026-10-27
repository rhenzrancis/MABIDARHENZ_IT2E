package com.scc;

import com.scc.dao.DatabaseInitializer;
import com.scc.dao.UserDao;
import com.scc.ui.Authentication;

import java.util.Scanner;

/** Single application entry point. */
public final class Main {
    private Main() { }

    public static void main(String[] args) {
        DatabaseInitializer.initialize();

        Scanner scanner = new Scanner(System.in);
        UserDao userDao = new UserDao();
        Authentication authentication = new Authentication(scanner, userDao);
        authentication.start();
    }
}
