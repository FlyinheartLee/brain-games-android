# BrainGames Android App

益智游戏合集 - 集成10款H5益智游戏的Android应用

## 项目结构

```
BrainGamesAndroid/
├── app/
│   ├── src/main/
│   │   ├── java/com/braingames/
│   │   │   ├── MainActivity.kt      # 主页Activity
│   │   │   ├── GameActivity.kt      # 游戏Activity
│   │   │   ├── GameAdapter.kt       # RecyclerView适配器
│   │   │   └── Game.kt              # 游戏数据类
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   ├── activity_main.xml
│   │   │   │   ├── activity_game.xml
│   │   │   │   └── item_game.xml
│   │   │   ├── values/
│   │   │   │   ├── colors.xml       # 浅色主题颜色
│   │   │   │   ├── strings.xml
│   │   │   │   └── themes.xml
│   │   │   ├── values-night/
│   │   │   │   └── colors.xml       # 深色主题颜色
│   │   │   └── drawable/            # 矢量图标
│   │   └── AndroidManifest.xml
│   ├── build.gradle.kts
│   └── proguard-rules.pro
├── build.gradle.kts
├── settings.gradle.kts
└── gradle/wrapper/
```

## 集成的10款游戏

1. **数独** - 经典数字填充游戏
2. **数字迷宫** - 迷宫寻路游戏
3. **摩天楼** - 摩天大楼建造谜题
4. **2048** - 数字合并游戏
5. **华容道** - 滑块解谜游戏
6. **扫雷** - 经典扫雷游戏
7. **接水管** - 管道连接游戏
8. **记忆翻牌** - 记忆配对游戏
9. **推箱子** - 仓库番游戏
10. **数桥** - 岛屿连接谜题

## 技术规格

- **目标系统**: Android 8.0+ (API 26+)
- **开发语言**: Kotlin
- **构建工具**: Gradle 8.4
- **最低SDK**: 26
- **目标SDK**: 34
- **编译SDK**: 34

## 功能特性

- 📱 2列网格布局游戏列表
- 🎮 WebView全屏游戏加载
- 🔄 加载进度条显示
- ⚠️ 返回键防误触确认
- 🌙 支持深色/浅色模式
- 📐 适配各种屏幕尺寸

## 手动构建步骤

### 环境要求

1. **JDK 17** 或更高版本
2. **Android Studio** (推荐) 或 **Android SDK Command Line Tools**
3. **Android SDK** - API 26~34

### 使用 Android Studio 构建

1. 打开 Android Studio
2. 选择 `Open an existing project`
3. 选择 `BrainGamesAndroid` 文件夹
4. 等待 Gradle Sync 完成
5. 点击菜单 `Build` → `Build Bundle(s) / APK(s)` → `Build APK(s)`
6. APK输出路径：`app/build/outputs/apk/debug/app-debug.apk`

### 使用命令行构建

```bash
# 进入项目目录
cd BrainGamesAndroid

# 确保已设置 ANDROID_HOME 环境变量
export ANDROID_HOME=/path/to/android-sdk

# 赋予gradlew执行权限
chmod +x gradlew

# 构建Debug APK
./gradlew assembleDebug

# 构建Release APK
./gradlew assembleRelease
```

## APK输出路径

- **Debug版本**: `app/build/outputs/apk/debug/app-debug.apk`
- **Release版本**: `app/build/outputs/apk/release/app-release-unsigned.apk`

## 安装APK

```bash
# 使用adb安装
adb install app/build/outputs/apk/debug/app-debug.apk
```

## 项目文件清单

### Kotlin源文件 (4个)
- `app/src/main/java/com/braingames/Game.kt`
- `app/src/main/java/com/braingames/MainActivity.kt`
- `app/src/main/java/com/braingames/GameActivity.kt`
- `app/src/main/java/com/braingames/GameAdapter.kt`

### 布局文件 (3个)
- `app/src/main/res/layout/activity_main.xml`
- `app/src/main/res/layout/activity_game.xml`
- `app/src/main/res/layout/item_game.xml`

### 资源文件
- `app/src/main/res/values/colors.xml`
- `app/src/main/res/values/strings.xml`
- `app/src/main/res/values/themes.xml`
- `app/src/main/res/values-night/colors.xml`
- `app/src/main/res/drawable/` (14个矢量图标)

### 配置文件
- `app/src/main/AndroidManifest.xml`
- `app/build.gradle.kts`
- `build.gradle.kts`
- `settings.gradle.kts`
- `gradle/wrapper/gradle-wrapper.properties`

## 权限说明

应用仅需要以下权限：
- `INTERNET` - 用于加载H5游戏
- `ACCESS_NETWORK_STATE` - 检测网络状态

## 注意事项

1. 游戏需要网络连接才能正常加载
2. 所有游戏均为H5网页版，托管在GitHub Pages
3. 应用本身不包含游戏资源，均为在线加载

---

**总文件数**: 约30个文件
**项目路径**: `/Users/flyinheart/.openclaw/workspace/BrainGamesAndroid/`
# Build triggered at 2026-03-21 20:26:31
