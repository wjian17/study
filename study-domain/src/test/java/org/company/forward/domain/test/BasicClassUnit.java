package org.company.forward.domain.test;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;

/**
 * 基础数据类型及String测试
 */
public class BasicClassUnit {

    @Test
    /**
     * Byte、Short、Integer、Long、Character、Boolean；这5种包装类默认创建了数值 [-128，127]
     */
    public void basicCacheTest(){
        Integer a = 0;
        Integer b = 0;
        Integer c = new Integer(0);
        Integer d = Integer.valueOf(0);//缓存区取数据
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a == d);

        Boolean e = true;
        Boolean f = new Boolean(true);
        System.out.println(e == f);

        System.out.println("=====");
        String s1 = String.valueOf("abc");
        String s2 = new String("abc");
        String s3 = "abc";
        String s4 = "a"+"bc";
        String t1 = "a";
        String t2 = "bc";
        String s5 = t1 + t2;
        System.out.println(s3 == s1);
        System.out.println(s3 == s2);
        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
    }
}
