# Bottom Navigation
This application is example of how to use [BottomNavigationView](https://developer.android.com/reference/android/support/design/widget/BottomNavigationView.html).
* This app is implemented in Kotlin
* Disable BottomNavigationView shift mode.  
![screenshot](docs/screenshot.png)

## Prerequisites
* Android SDK 29
* Android Build Tool 28.0.3
* Androidx 1.1.0
* Android Plugin for Gradle 3.5.3
* Kotlin gradle plugin 1.3.41

## Getting Started
Build with Android Studio 3.5.3

## Disable shifting mode
### Since Support library 28

```xml
    <android.support.design.widget.BottomNavigationView
        ・・・
        app:labelVisibilityMode="labeled"
        ・・・
    />
```

### Support library 27 or lower ([target-sdk-27](https://github.com/yasszu/bottom-navigation/tree/target-sdk-27))

Use the extension of [BottomNavigationView](https://github.com/yasszu/bottom-navigation/blob/master/app/src/main/java/com/example/bottomnavigation/extension/BottomNavigationView.kt).

```java
bottomNavigationView.disableShiftMode()
```

You need to configure proguard-rules.pro file if you want use ProGuard. Such as below:   

```
-keepclassmembers class android.support.design.internal.BottomNavigationMenuView { 
    boolean mShiftingMode; 
}
```
