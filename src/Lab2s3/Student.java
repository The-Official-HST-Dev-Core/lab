package Lab2s3;

public class Student implements Comparable<Student>{
    private final String name;
    private final int age;

    @Override
    public int compareTo(Student otherStudent){
        if (otherStudent == null){
            return 1;
        }
        return this.name.compareTo(otherStudent.name);
    }

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
}
