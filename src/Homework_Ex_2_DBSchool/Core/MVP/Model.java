package Homework_Ex_2_DBSchool.Core.MVP;

import Homework_Ex_2_DBSchool.Config;
import Homework_Ex_2_DBSchool.Core.Infastructure.School;
import Homework_Ex_2_DBSchool.Core.Models.Class;
import Homework_Ex_2_DBSchool.Core.Models.Teacher;

import java.io.*;

public class Model {
    School currentSchool;
    private int currentClassIndex;
    private int currentTeacherIndex;
    private String classPath;
    private String teacherPath;
    private String studentPath;

    public  Model(String classPath, String teacherPath, String studentPath) {
        currentSchool = new School("17");
        currentClassIndex = 0;
        currentTeacherIndex = 0;
        this.classPath = classPath;
        this.teacherPath = teacherPath;
        this.studentPath = studentPath;
    }

    public School currentSchool() {
        return this.currentSchool;
    }

    public Class currentClass() {
        if (currentClassIndex >= 0) {
            return currentSchool.getClass(currentClassIndex);
        } else {
            // ToDo
            return null;
        }
    }

    public Teacher currentTeacher() {
        if (currentTeacherIndex >= 0) {
            return currentSchool.getTeacher(currentTeacherIndex);
        } else {
            // ToDo
            return null;
        }
    }

    public void setCurrentClassIndex(int value) {
        this.currentClassIndex = value;
    }

    public int getCurrentClassIndex() {
        return this.currentClassIndex;
    }

    public void setCurrentTeacherIndex(int value) {
        this.currentTeacherIndex = value;
    }

    public int getCurrentTeacherIndex() {
        return this.currentTeacherIndex;
    }

    public void loadClass() {
        try {
            File file = new File(classPath);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String classNumber = reader.readLine();
            while (classNumber != null) {
                String classLetter = reader.readLine();
                this.currentSchool.addClass(classNumber, classLetter);
                classNumber = reader.readLine();
            }
            reader.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadTeacher() {
        try {
            File file = new File(teacherPath);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String firstName = reader.readLine();
            while (firstName != null) {
                String middleName = reader.readLine();
                String lastName = reader.readLine();
                String age = reader.readLine();
                this.currentSchool.addTeacher(firstName, middleName, lastName, age);
                firstName = reader.readLine();
            }
            reader.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveClass(Class schoolclass) {
        try (FileWriter fw = new FileWriter(Config.classPath, true)) {
            fw.append(schoolclass.classNumber).append("\n");
            fw.append(schoolclass.classLetter).append("\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveTeacher(Teacher teacher) {
        try (FileWriter fw = new FileWriter(Config.teacherPath, true)) {
            fw.append(teacher.firstName).append("\n");
            fw.append(teacher.middleName).append("\n");
            fw.append(teacher.lastName).append("\n");
            fw.append(teacher.age).append("\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
