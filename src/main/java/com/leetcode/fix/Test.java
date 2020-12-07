package com.leetcode.fix;


//四个集合（元素类型随意），实现一个分配函数，入参是一个元素。
//该函数将该元素放入其中一个集合，要求该函数无论被调用多少次，
//四个集合中的元素数量之比都尽量接近 1:2:3:4。
//这个是模拟一个按权重分配的真实场景，权重最高的集合优先分配。
//打印出调用N次后的各集合的大小。例如调用3次，调用10次，调用100次等。



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {

    static List<Integer>  l1 = new ArrayList<>(); //1
    static List<Integer>  l2 = new ArrayList<>(); //2
    static List<Integer>  l3 = new ArrayList<>(); //3
    static List<Integer>  l4 = new ArrayList<>(); //4


    public static void main(String[] args) {
        for (int i=0;i<3;i++) {
            put(i);
        }
        System.out.println(l1.size()+":" + l2.size()+":" + l3.size()+":" + l4.size());
        l1.clear();
        l2.clear();
        l3.clear();
        l4.clear();
        for (int i=0;i<10;i++) {
            put(i);
        }
        System.out.println(l1.size()+":" + l2.size()+":" + l3.size()+":" + l4.size());
        l1.clear();
        l2.clear();
        l3.clear();
        l4.clear();
        for (int i=0;i<100;i++) {
            put(i);
        }
        System.out.println(l1.size()+":" + l2.size()+":" + l3.size()+":" + l4.size());
    }

    public static void put(int i){
        //i 为其他类型可以获取hash值取模。。
        Random random = new Random();
        int weight = random.nextInt(10);
        switch (weight) {
            case 0: l1.add(i);break;
            case 1:;
            case 2:l2.add(i);break;
            case 3:;
            case 4:;
            case 5:l3.add(i);break;
            default:l4.add(i);break;
        }
    }
}
