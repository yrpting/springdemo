package com.springmvc.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;

public class CustomClassLoader extends ClassLoader {
    public static void main(String[] args) {
        String clsName = "jav.lan.String";
        //CustomClassLoader ccl = new CustomClassLoader("http://localhost:8080");
        CustomClassLoader ccl = new CustomClassLoader("E:/software/apache-tomcat-8.0.26/webapps/ROOT");
        try {
            Class<?> cls = ccl.loadClass(clsName);
//                        for (Method m : cls.getMethods()) {
//                            System.out.println(m.getName());
//                        }
            System.out.println(cls.getClassLoader());
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private String rootUrl;

    CustomClassLoader(String rootUrl) {
        this.rootUrl = rootUrl;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> cls = this.findLoadedClass(name);
        if (cls == null) {
            byte[] classData = getClassData(name);
            if (classData == null) {
                throw new ClassNotFoundException();
            }
            cls = defineClass(name, classData, 0, classData.length);
        }
        return cls;
    }

    private byte[] getClassData(String name) {
        String path = classNameToPath(name);
        FileInputStream fis = null;
        try {
//                        URL url = new URL(path);
//                        InputStream is = url.openStream();
//                        byte[] bytes = new byte[1024 * 4];
//                        int len = -1;
//                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                        while ((len = is.read(bytes)) != -1) {
//                            baos.write(bytes, 0, len);
//                        }
//                        return baos.toByteArray();
            File file = new File(path);
            byte[] bytes = new byte[1024*4];
            fis = new FileInputStream(file);
            int len = -1;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((len = fis.read(bytes)) != -1) {
                baos.write(bytes, 0, len);
            }
            return baos.toByteArray();
        } catch (Exception e) {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }

    private String classNameToPath(String name) {
        return rootUrl + "/" + name.replace(".", "/") + ".class";
    }
}
