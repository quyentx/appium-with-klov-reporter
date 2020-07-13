
*Appium inspector capability:*

```
{
  "platformName": "Android",
  "deviceName": "Pixel2",
  "appPackage": "com.truemoney.vnwallet",
  "appActivity": ".splash.activity.activity.SplashActivity"
}
```

To run emulator with google dns from command line:
1. Add emulator script to System variable
2. Run the following command: ``` emulator @<emaulatorName> -dns-server 8.8.8.8 ```


*Install Klov reporter*
1. Install and start mongoDB as a service for your OS
2. Download Klov reporter from https://github.com/extent-framework/klov-server
3. Execute application tests
4. Run klov in command line or terminal with `java -jar klov-x-x.jar` command


*Start mongoDB instance*
1. Navigate to MongoDB binary folder
2. Run command `mongod dbPath=C:\MongoDB\data`