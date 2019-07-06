package com.zl.loader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 利用类加载器加载资源文件
 * InputStream inputStream = LoadResources.class.getResourceAsStream("/application.properties");
 * InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");
 * 注意有/和没有/的区别
 *
 *
 * 用maven打成jar包后，Main.class.getClassLoader().getResource("")为null。
 * 原因：
 *  一旦被打入jar包，path就变为了xxx.jar!/aa/bb/test.txt.无法通过jar文件生成File。
 *  在jar文件中查找资源和在文件系统中查找资源的方式是不一样的。尽量使用Stream流的方式操作资源文件。
 *
 *  import java.io.IOException;
 *  public class TEST {
 *     public static void main(String[] args) throws IOException {
 *         Resource res=new Resource();
 *         res.getResource();
 *     }
 *  }
 *
 *  这时的运行结果是：file:/C:/ResourceJar.jar!/resource/res.txt
 *  我们成功的在运行时动态获得了res.txt的位置。然而，问题来了，你是否可以通过下面这样的代码来得到res.txt文件？
 *  File f=new File("C:/ResourceJar.jar!/resource/res.txt");
 *  当然不可能，因为".../ResourceJar.jar!/resource/...."并不是文件资源定位符的格式 (jar中资源有其专门的URL形式：jar:<url>!/{entry} )。所以，如果jar包中的类源代码用File f=new File(相对路径);的形式，是不可能定位到文件资源的。这也是为什么源代码1打包成jar文件后，调用jar包时会报出FileNotFoundException的症结所在了。
 */
public class LoadResources {

    public static void main(String[] args) throws IOException {

        LoadResources loaderOne = new LoadResources();
        Properties properties = new Properties();
        InputStream inputStream = loaderOne.getClass().getResourceAsStream("/application.properties");
        properties.load(inputStream);
        System.out.println(properties.getProperty("multipart.maxFileSize"));
        System.out.println(System.getProperty("java.class.path"));

        System.out.println(LoadResources.class.getClassLoader().getResource("/"));
        System.out.println(LoadResources.class.getClassLoader().getResource(""));
        System.out.println(LoadResources.class.getResource("/application.properties"));
        System.out.println(LoadResources.class.getResource(""));
    }
}
