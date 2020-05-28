package org.company.forward.domain.java;

/**
 * @author wangjian
 * @date 2020/5/28 0028 16:06
 */
 public class CloneAnalizy {

    public static void main(String[] args) throws Exception{
        Clone1 clone1 = new Clone1();
        Integer b = new Integer(140);
        String s = new String("dsafdd");
        clone1.setA(129);
        clone1.setB(b);
        clone1.setC("sadf");
        clone1.setD(s);
        Clone1 clone2 = (Clone1)clone1.clone();
        clone1.setA(130);
        b=new Integer(133);
        clone1.setB(b);
        clone1.setC("sadf11");
        s = new String("dsafdd11");
//        clone1.setD(s);
        System.out.println(clone1.toString());
        System.out.println(clone2.toString());

    }
}

class Clone1 implements Cloneable{

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    int a;
    Integer b;
    String c;
    String d;

    public String toString(){
        return "A:"+a+"B:"+b+"C:"+c+"D:"+d;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }
}
