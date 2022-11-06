package Homework_Ex_2_DBSchool.Core.Models;

import java.util.ArrayList;
import java.util.List;

public class Class {
    public String classNumber;
    public String classLetter;
    public Teacher classMaster;

    private List<Schoolchild> schoolChildren;

    public Class(String classNumber, String classLetter) {
        this.classNumber = classNumber;
        this.classLetter = classLetter;
        schoolChildren = new ArrayList<>();
    }

    // add schoolChild
    public boolean addSchoolChild(Schoolchild sc) {
        boolean flag = false;
        if (!schoolChildren.contains(sc)) {
            schoolChildren.add(sc);
            flag = true;
        }
        return flag;
    }

    // add classMaster
    public boolean addClassMaster(Teacher cM) {
        boolean flag = false;
        String status = String.format("ClassMaster has already exist (%s)", classMaster);
        if (classMaster != null) {
            classMaster = cM;
            status = String.format("ClassMaster %s added to Class %s", classMaster, this);
            flag = true;
        }
        System.out.println(status);
        return flag;
    }

    public void getClassList() {
        for (Schoolchild child : schoolChildren) {
            System.out.println(child);
        }
    }

    @Override
    public String toString() {
        return String.format("%s%s", classNumber, classLetter);
    }
}
