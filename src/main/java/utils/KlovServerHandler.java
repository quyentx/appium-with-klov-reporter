package utils;

import java.io.File;
import java.io.IOException;

public class KlovServerHandler {
    public static void startKlovServer() throws IOException {
        Process proc = Runtime.getRuntime().exec("java -jar D:"+ File.separator+"Projects"+File.separator+"klov-server"+ File.separator +"0.2.8"+ File.separator +"klov-0.2.8.jar");
    }


    public static void main(String[] args) throws IOException {
        startKlovServer();
    }
}
