## 记录
1. 加载图片
2. 可以缓存图片
    缓存图片名字这么保证唯一性，且长度合适
        暂时使用md5的方式来解决

3. 在列表中正常展示
4. 缓存
5. 可以加载圆图，圆角图

需要下面权限

```xml
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
```