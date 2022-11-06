package Homework_Ex_2_DBSchool.Core.MVP;


import Homework_Ex_2_DBSchool.Core.Models.Class;
import Homework_Ex_2_DBSchool.Core.Models.Teacher;

public class Presenter {
    private Model model;
    private View view;

    public Presenter(View view, String classPath, String teacherPath, String studentPath) {
        this.view = view;
        model = new Model(classPath, teacherPath, studentPath);
    }


    public void loadFromFileClass() {
        model.loadClass();

        if (model.currentSchool().countClass() > 0) {
            model.setCurrentClassIndex(0);
            var schoolClass = model.currentClass();
            System.out.printf("%d of %d\n", model.getCurrentClassIndex()+1, model.currentSchool().countClass());
            view.setClassNumber(schoolClass.classNumber);
            view.setClassLetter(schoolClass.classLetter);
        }
    }

    public void loadFromFileTeacher() {
        model.loadTeacher();

        if (model.currentSchool().countTeacher() > 0) {
            model.setCurrentTeacherIndex(0);
            var schoolTeacher = model.currentTeacher();
            System.out.printf("%d of %d\n", model.getCurrentTeacherIndex()+1, model.currentSchool().countTeacher());
            view.setFirstName(schoolTeacher.firstName);
            view.setMiddleName(schoolTeacher.lastName);
            view.setLastName(schoolTeacher.middleName);
            view.setAge(schoolTeacher.age);
        }
    }

    public void nextClass() {
        if (model.currentSchool().countClass() > 0) {
            if (model.getCurrentClassIndex() + 1 < model.currentSchool().countClass()) {
                model.setCurrentClassIndex(model.getCurrentClassIndex() + 1);
                Class schoolclass = model.currentClass();
                System.out.printf("%d of %d\n", model.getCurrentClassIndex()+1, model.currentSchool().countClass());
                view.setClassNumber(schoolclass.classNumber);
                view.setClassLetter(schoolclass.classLetter);
            } else {
                model.setCurrentClassIndex(0);
                Class schoolclass = model.currentClass();
                System.out.printf("%d of %d\n", model.getCurrentClassIndex()+1, model.currentSchool().countClass());
                view.setClassNumber(schoolclass.classNumber);
                view.setClassLetter(schoolclass.classLetter);
            }
        }
    }

    public void prevClass() {
        if (model.currentSchool().countClass() > 0) {
            if (model.getCurrentClassIndex() - 1 > -1) {
                model.setCurrentClassIndex(model.getCurrentClassIndex() - 1);
                Class schoolclass = model.currentClass();
                System.out.printf("%d of %d\n", model.getCurrentClassIndex()+1, model.currentSchool().countClass());
                view.setClassNumber(schoolclass.classNumber);
                view.setClassLetter(schoolclass.classLetter);
            } else {
                model.setCurrentClassIndex(model.currentSchool().countClass()-1);
                Class schoolclass = model.currentClass();
                System.out.printf("%d of %d\n", model.getCurrentClassIndex()+1, model.currentSchool().countClass());
                view.setClassNumber(schoolclass.classNumber);
                view.setClassLetter(schoolclass.classLetter);
            }
        }
    }

    public void nextTeacher() {
        if (model.currentSchool().countTeacher() > 0) {
            if (model.getCurrentTeacherIndex() + 1 < model.currentSchool().countTeacher()) {
                model.setCurrentTeacherIndex(model.getCurrentTeacherIndex() + 1);
                Teacher teacher = model.currentTeacher();
                System.out.printf("%d of %d\n", model.getCurrentTeacherIndex()+1, model.currentSchool().countTeacher());
                view.setFirstName(teacher.firstName);
                view.setLastName(teacher.lastName);
                view.setMiddleName(teacher.middleName);
                view.setAge(teacher.age);
            } else {
                model.setCurrentTeacherIndex(0);
                Teacher teacher = model.currentTeacher();
                view.setFirstName(teacher.firstName);
                view.setLastName(teacher.lastName);
                view.setMiddleName(teacher.middleName);
                view.setAge(teacher.age);
            }
        }
    }

    public void prevTeacher() {
        if (model.currentSchool().countTeacher() > 0) {
            if (model.getCurrentTeacherIndex() - 1 > -1) {
                model.setCurrentTeacherIndex(model.getCurrentTeacherIndex() - 1);
                Teacher teacher = model.currentTeacher();
                System.out.printf("%d of %d\n", model.getCurrentTeacherIndex()+1, model.currentSchool().countTeacher());
                view.setFirstName(teacher.firstName);
                view.setLastName(teacher.lastName);
                view.setMiddleName(teacher.middleName);
                view.setAge(teacher.age);
            } else {
                model.setCurrentTeacherIndex(model.currentSchool().countTeacher()-1);
                Teacher teacher = model.currentTeacher();
                view.setFirstName(teacher.firstName);
                view.setLastName(teacher.lastName);
                view.setMiddleName(teacher.middleName);
                view.setAge(teacher.age);
            }
        }
    }

    public void addTeacher() {
        Teacher t = new Teacher(view.getLastName(), view.getFirstName(), view.getMiddleName(), view.getAge());
        model.saveTeacher(t);
        System.out.printf("%s added\n", t);
    }

    public void addClass() {
        Class cl = new Class(view.getClassNumber(), view.getClassLetter());
        model.saveClass(cl);
        System.out.printf("%s added\n", cl);
    }
}
