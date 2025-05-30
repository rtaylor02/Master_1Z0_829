package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        copy("C:\\Users\\mailb\\OneDrive\\My Java\\1Z0_829\\prep\\Master_1Z0_829\\src\\io\\file1.txt", "C:\\Users\\mailb\\OneDrive\\My Java\\1Z0_829\\prep\\Master_1Z0_829\\src\\io\\file1_copy.txt");
    }

    private static void copy(String from, String to) {
        final int CAPACITY = 1024;
        try (FileInputStream inputStream = new FileInputStream(from);
             FileOutputStream outputStream = new FileOutputStream(to)) {
            byte[] buffer = new byte[CAPACITY];
            while (inputStream.read(buffer) != -1) {
                outputStream.write(buffer);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
