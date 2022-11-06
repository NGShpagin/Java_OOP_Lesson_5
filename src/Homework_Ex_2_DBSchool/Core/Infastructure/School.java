package Homework_Ex_2_DBSchool.Core.Infastructure;

import Homework_Ex_2_DBSchool.Core.Models.Class;
import Homework_Ex_2_DBSchool.Core.Models.Teacher;

import java.util.ArrayList;
import java.util.List;

public class School {
    private List<Class> classes;
    private List<Teacher> teachers;
    String schoolNum;

    public School(String schoolNum){
        this.schoolNum = schoolNum;
        classes = new ArrayList<>();
        teachers = new ArrayList<>();
    }

    // create schoolClass
    public boolean addClass(String classNumber, String classLetter) {
        Class schoolClass = new Class(classNumber, classLetter);
        boolean flag = false;
//        String status = String.format("Class %s has already exist in School", schoolClass);
        if (!classes.contains(schoolClass)) {
            classes.add(schoolClass);
//            status = String.format("Class %s added in School", schoolClass);
            flag = true;
        }
//        System.out.println(status);
        return flag;
    }

    // add Teacher
    public boolean addTeacher(String lastName, String firstName, String middleName, String age) {
        Teacher teacher = new Teacher(lastName, firstName, middleName, age);
        boolean flag = false;
//        String status = String.format("Class %s has already exist in School", teacher);
        if (!teachers.contains(teacher)) {
            teachers.add(teacher);
//            status = String.format("Class %s added in School", teacher);
            flag = true;
        }
//        System.out.println(status);
        return flag;
    }

    public Class getClass(int index) {
        return containsClass(index) ? classes.get(index) : null;
    }

    public Teacher getTeacher(int index) {
        return containsTeacher(index) ? teachers.get(index) : null;
    }

    private boolean containsClass(int index) {
        return classes != null && classes.size() > index;
    }

    private boolean containsTeacher(int index) {
        return teachers != null && teachers.size() > index;
    }

    public int countClass() {
        return classes.size();
    }

    public int countTeacher() {
        return teachers.size();
    }
}
