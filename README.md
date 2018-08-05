README -- LifeCat Android
===========================
![许可](https://img.shields.io/dub/l/vibe-d.svg) 
:cat: :smiley_cat: :kissing_cat:

|title|content|
|:---:|:---:
|desc|智能成长相册系统LifeCat-Android
|author|ten
|version|Version 1
|date|2018
|framework|Android Java

#### Android应用开发

APP基于Android平台，使用AndroidStudio开发，UI遵循MaterialDesign设计原则，结合使用了Android原生组件与GitHub上的开源组件。

#### 主要界面：

    欢迎界面：播放欢迎视频。

    登录/注册：用户登录/注册的操作均会连接到数据库，进行同数据库的操作

    主页面：跳转到其他页面，以及侧边栏显示用户信息

    上传图片：取得用户权限后，可以读取本机内的图片库或使用摄像头进行拍照，最多选中9张照片进行上传。

    相册：展示用户的图片库，基于卡片式布局，有效的进行界面的美观和管理

#### 主要功能：

    服务器通信：使用Http协议进行数据传输，通过开源库OkHttp进行实现，能够向服务器发送POST请求，服务器使用java部署，能够通过jdbc获取数据库信息并返回响应，从而实现图片的上传存储与下载功能。

    图片展示：使用卡片式布局，实现良好的界面展示设计，实现Android图片显示功能。

    用户信息安全验证：通过与数据库的交互，实现用户的登录与注册，确保用户信息的安全性

    登录/注册：通过OkHttp发送POST请求到WEB服务器端，服务器端返回响应

    选择并上传图片：Album开源库

    电子宠物互动功能：语料库关键词匹配
  
#### gradle依赖
    dependencies {  
            implementation fileTree(include: ['*.jar'], dir: 'libs')  
            implementation 'com.android.support:appcompat-v7:27.1.1'  
            implementation 'com.android.support.constraint:constraint-layout:1.1.0'  
            implementation 'com.jakewharton:butterknife:8.5.1'  
            implementation 'com.android.support:design:27.1.1'  
            //开源album:选取照片  
            implementation 'com.yanzhenjie:album:1.0.0'  
            //侧滑栏  
            implementation 'com.android.support:design:27.1.1'  
            implementation 'de.hdodenhof:circleimageview:2.1.0'  
            //卡片式布局  
            implementation 'com.android.support:recyclerview-v7:27.1.1'  
            implementation 'com.android.support:cardview-v7:27.1.1'   
            implementation 'com.github.bumptech.glide:glide:3.7.0'  
            //OkHttp  
            implementation 'com.squareup.okhttp3:okhttp:3.7.0'  
            testImplementation 'junit:junit:4.12'  
            androidTestImplementation 'com.android.support.test:runner:1.0.2'  
            androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'  
      }  

### SHOW
 ![image](https://img-blog.csdn.net/20180510170053798?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
 
 ![image](https://img-blog.csdn.net/20180510170115342?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
 
 ![image](https://img-blog.csdn.net/20180510170246857?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
 
 ![image](https://img-blog.csdn.net/20180510170308303?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
 
 ![image](https://img-blog.csdn.net/2018051017033881?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
 
 ![image](https://img-blog.csdn.net/20180510170406690?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
 
 ![image](https://img-blog.csdn.net/20180510170436135?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
 
 ![image](https://img-blog.csdn.net/2018051017045469?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![image](https://img-blog.csdn.net/20180510170517458?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)


 
 ******************************************************************************
 #### [_@后端接口API文档(正在开发)_](http://47.106.11.84)
 *****************************************************************************
  #### _@项目分析_
  
  [项目流程分析介绍](https://zhuanlan.zhihu.com/p/41209351) (点击链接)  
  
  进行了项目结构、项目目录、项目流程的分析

******************************************************************************
### 相关项目：
 #### [LifeCat version1 servlet基础Javaweb服务网站](https://github.com/kevinten10/lifecatweb)
 #### [LifeCat version2 version1相应SSM后台管理系统](https://github.com/kevinten10/SSM-lifecat)
 #### [LifeCat version3 前后端分离springboot后端](https://github.com/kevinten10/springboot-lifecat)
 #### [LifeCat version3 前后端分离vuejs前端](https://github.com/kevinten10/Web-lifecat)
 *****************************************************************************
  #### [LifeCat hadoop 分布式平台进行数据处理](https://github.com/kevinten10/Hadoop-lifecat)
  #### [LifeCat wechat 微信小程序](https://github.com/kevinten10/WeChat-lifecat)
  #### [LifeCat python 机器学习进行图像智能处理](https://github.com/kevinten10/Python-lifecat)

