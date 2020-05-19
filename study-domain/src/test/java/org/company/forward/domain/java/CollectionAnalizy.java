package org.company.forward.domain.java;

import org.junit.Test;

import java.util.*;

public class CollectionAnalizy {

    @Test
    /**
     * Byte、Short、Integer、Long、Character、Boolean；这5种包装类默认创建了数值 [-128，127]
     */
    public void basicSetTest(){
        Set<String> hashSet = new HashSet<>();
        Set<String> treeSet = new TreeSet<>();
        Map<String,String> hashMap = new HashMap<>();
        Map<String,String> treeMap = new TreeMap<>();
        Map<String,String> hashTable = new Hashtable<>();
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        List<String> vector = new Vector<>();
        Collections.reverse(arrayList);
        Collections.shuffle(arrayList);
        int[] a = new int[]{1,2,3,4,5,6,7,8,9,10};
//        Arrays.fill(a,3);
//        Arrays.fill(a,3,5,99);
        System.out.println(Arrays.toString(a));
        List list = Arrays.asList(new String[]{"1","2","3"});
        List list2 = Arrays.asList(new int[]{1,2,3,4,5,6,7,8,9,10});
        System.out.println(list2);
        Collections.reverse(list);
        System.out.println(Arrays.toString(list.toArray()));

    }
}
