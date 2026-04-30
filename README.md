# 数独 Sudoku

为华为 Pura X Max 折叠屏优化的数独游戏。

## 特性

- 🎮 经典数独，三档难度（简单/中等/困难）
- 📝 笔记模式 + 一键笔记（二次确认）
- 💡 智能提示（选中空格直接显示答案）
- 🔍 实时错误检测 + 唯余法高亮
- 🏆 最佳记录系统
- 📱 自适应折叠屏（外屏 5.4寸 / 内屏 7.7寸）
- 🔄 支持竖屏和横屏
- 🎨 清新薄荷绿配色

## 技术栈

- Android (Kotlin) + WebView
- H5 单文件实现，无外部依赖
- 目标 SDK: 34 / 最低 SDK: 26

## 构建

```bash
./gradlew assembleDebug
```

APK 输出: `app/build/outputs/apk/debug/app-debug.apk`

## 环境要求

- JDK 17
- Android SDK (API 34)
