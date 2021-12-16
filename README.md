# MeerimErmekbaevaMobileTest
Repository for Mobile Test tasks (EPAM TA training)

How to run exercise-1:
1. Run Android Studio. Choose menu "Tools" - "AVD manager" 
2. Create virtual device (for example - Pixel 5 with Android 11.0 - x86_64 (there is an installed chrome browser))
3. Run virtual device.
4. Run appium server with host "0.0.0.0" and port "4723"
5. Run test with command "mvn clean test -P web" for web test
6. Run test with command "mvn clean test -P native" for native test
