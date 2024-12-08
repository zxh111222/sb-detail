package com.example.proxy;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class MyProxy {

    public static Object newProxyInstance(Class i) {
        String methodsString = "";
        Method[] methods = i.getMethods();
        for (Method method : methods) {
            methodsString += """
                    @Override
                        public void %s() {
                            System.out.println("用户 admin 开始访问该方法，地点：xm，时间：" + LocalDateTime.now());
                    
                            flyable.%s();
                    
                            System.out.println("用户 admin 结束访问该方法，地点：xm，时间：" + LocalDateTime.now());
                        }
                    """.formatted(method.getName(), method.getName());
        }

        String sourceCode = """
                package com.example.proxy;
                
                import java.time.LocalDateTime;
                
                public class GirlLoggingProxy2 implements %s {
                
                    %s flyable;
                
                    public GirlLoggingProxy2(%s flyable) {
                        this.flyable = flyable;
                    }
                
                    %s
                
                }
                
                """.formatted(i.getName(), i.getName(), i.getName(), methodsString);

        String userDir = System.getProperty("user.dir");
        System.out.println(userDir);

        String fileName = userDir + "/src/main/java/com/example/proxy/GirlLoggingProxy2.java";
        try {
            // 源代码
            File file = new File(fileName);
            FileWriter fw = new FileWriter(file);
            fw.write(sourceCode);
            fw.flush();

            // 编译
            // compile
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager standardFileManager = compiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> javaFileObjects = standardFileManager.getJavaFileObjects(fileName);
            JavaCompiler.CompilationTask task = compiler.getTask(null, standardFileManager, null, null, null, javaFileObjects);
            task.call();
            standardFileManager.close();

            // 加载出对象
            // load to memory
            URL[] urls = new URL[] {new URL("file:/" + userDir + "/src/")};
            URLClassLoader urlClassLoader = new URLClassLoader(urls);
            Class<?> aClass = urlClassLoader.loadClass("com.example.proxy.GirlLoggingProxy2");
            System.out.println(aClass);

            // 实例
            // create an instance
            Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(Flyable.class);
            Flyable flyable = (Flyable) declaredConstructor.newInstance(new Girl());

            return flyable;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
