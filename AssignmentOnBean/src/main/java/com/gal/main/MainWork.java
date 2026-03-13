package com.gal.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainWork {
    public static void main(String args[]) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.gal.main");
        WordCounter count = context.getBean(WordCounter.class);

        System.out.println(count.wordCount());
    }
}