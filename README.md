# MeerimErmekbaevaMobileTest
Repository for Mobile Test tasks (EPAM TA training)

How to run exercise-1:
1. Run Android Studio. Choose menu "Tools" - "AVD manager" 
2. Create virtual device (for example - Pixel 5 with Android 11.0 - x86_64 (there is an installed chrome browser))
3. Run virtual device.
4. Run appium server with host "0.0.0.0" and port "4723"
5. Run test with command "mvn clean test -P web" for web test
6. Run test with command "mvn clean test -P native" for native test

How to run exercise-2:
1. Put your token and project name ("firstname_lastname") into the test.properties file
2. Turn on vpn
3. By default Android udid is ce11171b791f6c0603 - Samsung Galaxy S8. Need to check if device available before test.
4. By default iOS udid is 00008020-00094961369A002E - iPhone XR. Need to check if device available before test.
5. To run android web test - run test with command "mvn clean test -P androidWeb"
6. To run iOS web test - run test with command "mvn clean test -P iOSWeb"
7. To run android native test:
- choose device at cloudmobile, then manually install EPAMTestApp.apk on device
- run test with command "mvn clean test -P androidNative"
6. To run iOS native test:
- choose device at cloudmobile, then manually install EPAMTestApp.ipa on device
- run test with command "mvn clean test -P iOSNative"
