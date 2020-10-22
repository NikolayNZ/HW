package com.gmail.hw;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Создайте консольный «текстовый редактор» с возможностью
        сохранения набранного текста в файл.*/
        File file = new File("HW2020.txt");
        Scanner sc = new Scanner(System.in);
        System.out.println("Напишіть текст:");
        String text = sc.nextLine();

        try (PrintWriter pw = new PrintWriter(file)) {
            pw.print(text);
        } catch (IOException e) {
            System.out.println(e);
        }
        /*  Напишите метод для сохранения в текстовый файл
        двухмерного массива целых чисел.*/
        int [] [] arr = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
        File file1 = new File("newFile.txt");
        try {
            file1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        arrToFile(arr, file1);
    }
        public static void arrToFile(int [] [] b, File fileX) {
        try (PrintWriter a = new PrintWriter (fileX)) {
            for (int i = 0; i < b.length; i++) {
                a.println(Arrays.toString(b[i]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /*Реализуйте метод который выведет на экран список всех
        каталогов которые «лежат» в каталоге который будет
        параметром этого метода.*/
        File file = new File(".");
        showCatalog(file);
    }
        public static void showCatalog (File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    System.out.println(files[i]);
                }
            }
        } else {
            System.out.println("В В данном каталоге нет каталогов");
        }
    }

}