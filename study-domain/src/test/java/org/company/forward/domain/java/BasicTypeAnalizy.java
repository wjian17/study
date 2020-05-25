package org.company.forward.domain.java;

import org.junit.Test;

public class BasicTypeAnalizy {

    @Test
    /**
     * Byte、Short、Integer、Long、Character、Boolean；这5种包装类默认创建了数值 [-128，127]
     */
    public void basicCacheTest(){
//        int k = new Integer(null);
        System.out.println(0.1*4);
        System.out.println(3*0.1);
        System.out.println(3*0.1==0.3);//false
        System.out.println(0.3*1==0.3);//true
        System.out.println(0.1*4==0.4);
//      float是8位有效数字，第7位数字将会四舍五入
        float a1 =1.32344435f;
        System.out.println(a1);

        Integer a = 0;
        Integer b = 0;
        Integer c = new Integer(0);
        Integer d = Integer.valueOf(0);//缓存区取数据
        System.out.println(a == b);//true
        System.out.println(a == c);//false
        System.out.println(a == d);//true

        int i1 = 300;
        int i2 = 300;
        long l1 = 129;
        long l2 = 129;
        System.out.println("i1==i2:"+(i1==i2));
        System.out.println("l1==l2:"+(l1==l2));
        Boolean e = true;
        Boolean f = new Boolean(true);
        System.out.println(e == f);//false

        System.out.println("=====");
        String s1 = String.valueOf("abc");
        String s2 = new String("abc");
        String s3 = "abc";
        String s4 = "a"+"bc";
        String t1 = "a";
        String t2 = "bc";
        String s5 = t1 + t2;
//        String s6 = t1 += t2;
//        System.out.println(t1);

        System.out.println(s3 == s1);//true
        System.out.println(s3 == s2);//false
        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
//        System.out.println(s3 == s6);//false

    }

    @Test
    /**
     * Byte、Short、Integer、Long、Character、Boolean；这5种包装类默认创建了数值 [-128，127]
     */
    public void bitTest() throws Exception{
        System.out.println(1<<4);//10000
        System.out.println(Integer.toBinaryString(16));
        System.out.println(-1<<4);//
        System.out.println(-1>>4);//
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(-1>>4));
        System.out.println(-1>>>3);
        System.out.println(Integer.toBinaryString(-1>>>3));
        System.out.println(1>>>3);
        System.out.println(Integer.toBinaryString(1>>>3));
        System.out.println(Integer.parseInt(Double.toString(Math.pow(2d,32d)),2));

    }
}
