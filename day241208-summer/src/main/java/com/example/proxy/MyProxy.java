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
import java.util.logging.Handler;

public class MyProxy {

    public static Object newProxyInstance(Class i, MyInvocationHandler h) {
        String methodsString = "";
        Method[] methods = i.getMethods();
        for (Method method : methods) {
            methodsString += """
                    @Override
                        public void %s() {
                            try {
                                Method md = %s.class.getMethod("%s");
                                h.invoke(md);
                            }catch (Exception e){
                                throw  new RuntimeException(e);
                            }
                        }
                    """.formatted(method.getName(), i.getName(), method.getName());
        }

        String sourceCode = """
                package com.example.proxy;
                
                import java.lang.reflect.Method;
                
                public class GirlLoggingProxy2 implements %s {
                
                    %s h;
                
                    public GirlLoggingProxy2(%s h) {
                        this.h = h;
                    }
                
                    %s
                
                }
                
                """.formatted(i.getName(), h.getClass().getName(), h.getClass().getName(), methodsString);

        String userDir = System.getProperty("user.dir");
        System.out.println(userDir);

        String fileName = userDir + "/src/main/java/com/example/proxy/GirlLoggingProxy2.java";
        try {
            // 源代码
            File file = new File(fileName);
            try (FileWriter fw = new FileWriter(file)) {
                fw.write(sourceCode);
            }

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
            URL[] urls = new URL[]{new URL("file:/" + userDir + "/src/")};
            URLClassLoader urlClassLoader = new URLClassLoader(urls);
            Thread.sleep(100);
            Class<?> aClass = urlClassLoader.loadClass("com.example.proxy.GirlLoggingProxy2");
            System.out.println(aClass);

            // 实例
            // create an instance
            Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(h.getClass());
            Flyable flyable = (Flyable) declaredConstructor.newInstance(h);

            return flyable;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
