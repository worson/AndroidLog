# AndroidLog
> 一个极简的日志打印工具库，方便大家简单调试使用

![ffa0f3de8a35e0abde2b58dca00b1e27](https://tva1.sinaimg.cn/large/007S8ZIlgy1gj0na1aqyij30ra04cq3h.jpg)


目前具备的简单功能有：
- 指定日志级别过滤日志
- 打印日志调用栈信息

# 导入库到项目

根目录gradle文件下配置
```
allprojects {
    repositories {
        ...
        maven { url 'https://www.jitpack.io' }
    }
}
```
应用目录gradle文件下配置依赖
```
implementation 'com.github.worson:AndroidLog:0.2'
```

# 使用方法

设置日志级别
```
L.init(Log.VERBOSE)
```

设置打印调用栈
```
L.setStackTrace(true)
```

打印日志，lamda方法在过滤日志可减少性能消耗
```
L.d(TAG) {"onCreate: "}
```