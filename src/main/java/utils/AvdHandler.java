package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class AvdHandler {

    public static void startEmulator() {
        String sdkPath = System.getenv("ANDROID_HOME");
        String emuPath = sdkPath + File.separator + "emulator"+ File.separator + "emulator";
        String emulatorName = "Pixel2";
        System.out.println("Starting emulator...");
        //To send command [emulator @DeviceName -dns-server 8.8.8.8] to open virtual device
        String[] cmdStartEmulator = new String[]{emuPath, "@" + emulatorName, "-dns-server", "8.8.8.8"};
        try {
            Process process = new ProcessBuilder(cmdStartEmulator).start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String adbPath = sdkPath + File.separator + "platform-tools"+ File.separator + "adb";
        String[] cmdCheckEmulatorStatus = new String[]{adbPath, "shell getprop sys.boot_completed"};
        try {
            Process process = new ProcessBuilder(cmdCheckEmulatorStatus).start();
            process.waitFor();
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("Emulator started successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stopEmulator() {
        String sdkPath = System.getenv("ANDROID_HOME");
        String adbPath = sdkPath + File.separator + "platform-tools" + File.separator + "adb";
            System.out.println("Killing emulator...");
            //To send command [adb emu kill] from /sdk-path/platform-tools folder
            String[] aCommand = new String[]{adbPath, "emu", "kill"};
            try {
                Process process = new ProcessBuilder(aCommand).start();
                process.waitFor(1, TimeUnit.SECONDS);
                System.out.println("Emulator closed successfully!");
            } catch (Exception e) {
                e.printStackTrace();
        }
    }
}
