package studyJava;

import java.util.*;

public class testdemo1 {
    public void ArrayDemo1() {


    List<Student> list = new ArrayList<Student>();
    Student s1 = new Student("a1", 12);
    Student s2 = new Student("a1", 23);
    Student s3 = new Student("a1", 45);
    Student s4 = new Student("a1", 67);

    list.add(s1);
    list.add(s2);
    list.add(s3);
    list.add(s4);
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int num = s1.getAge()-s2.getAge();
                int num2=num==0?s1.getName().compareTo(s2.getName()):num;
                return num2;
            }
        });
        for(Student s:list){
            System.out.println(s.getName()+":"+s.getAge());
        }
    }
//    public void TestDemo2(){
//        TreeSet<Student2> ts = new TreeSet<Student>(new Comparator<Student2>() {
//            @Override
//            public int compare(Student2 s1, Student2 s2) {
//                int num = s1.GetSum()-s2.GetSum();
//                int num2 = num == 0 ? s1.getChinese()-s2.getChinese():num;
//                int num3 = num2 == 0 ? s1.getEnglish()-s2.getEnglish():num2;
//                int num4 = num3 == 0 ? s1.getMath()-s2.getMath():num3;
//                int num5 = num4 == 0 ? s1.getName().compareTo(s2.getName()):num4;
//                return num5;
//            }
//        });
//        for(){
//
//        }
//    }
    public static void testDemo3(){
        int f1=1,f2=1,f;
        int m=30;
        System.out.println(2);
        System.out.println(2);
        for(int i=3;i<m;i++){
            f=f2;
            f2=f1+f2;
            f1=f;
            System.out.println(f2);
        }
    }

    public static void main(String[] args) {
        testdemo1 td = new testdemo1();
        //td.ArrayDemo1();
        testDemo3();
    }
}
