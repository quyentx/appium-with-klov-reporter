package utils;

import java.io.File;
import java.io.IOException;

public class MongoDBHandler {

    public static void startMongoDB() {
        ProcessBuilder pb = new ProcessBuilder();
        pb.command("C:"+ File.separator +"MongoDB"+ File.separator +"bin"+ File.separator +"mongod", "--dbpath", "C:"+ File.separator +"MongoDB"+ File.separator+"data");
        Process p;
        try {
            p = pb.start();
            System.out.println(p.isAlive());
//            p.destroyForcibly();
//            System.out.println(p.isAlive());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        startMongoDB();
    }
}
