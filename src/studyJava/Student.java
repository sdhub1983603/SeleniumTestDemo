package studyJava;

public class Student implements Comparable<Student> {
    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student s) {
        int num = this.age - s.age;
        int num2 = num ==0?this.name.compareTo(s.name):num;
        return num2;
    }
}
