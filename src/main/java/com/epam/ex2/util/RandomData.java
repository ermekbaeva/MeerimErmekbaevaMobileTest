package com.epam.ex2.util;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomData {
    public static String username = RandomStringUtils.random(10, true, false);
    public static String email = RandomStringUtils.random(6, true, false) + "@gmail.com";
    public static String password = RandomStringUtils.random(10, true, true);
}
