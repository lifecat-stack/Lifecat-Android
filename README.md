# Android-Album
Lifecat系统之Android应用--Android网络相册实现

### Android主要功能：

  登录/注册：通过OkHttp发送POST请求到WEB服务器端，服务器端返回响应

  选择并上传图片：Album开源库

  远程通信：使用OkHttp进行远程通信

  展示图片：CardView布局

  电子宠物互动功能：语料库关键词匹配
  
### gradle依赖

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
  
## SHOW
 ![image](https://img-blog.csdn.net/20180510170053798?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
 
 ![image](https://img-blog.csdn.net/20180510170115342?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
 
 ![image](https://img-blog.csdn.net/20180510170246857?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
 
 ![image](https://img-blog.csdn.net/20180510170308303?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
 
 ![image](https://img-blog.csdn.net/2018051017033881?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
 
 ![image](https://img-blog.csdn.net/20180510170406690?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
 
 ![image](https://img-blog.csdn.net/20180510170436135?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
 
 ![image](https://img-blog.csdn.net/2018051017045469?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![image](https://img-blog.csdn.net/20180510170517458?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
