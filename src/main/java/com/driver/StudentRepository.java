package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    HashMap <String, Student> studentHashMap = new HashMap<>();
    HashMap <String, Teacher> teacherHashMap = new HashMap<>();
    HashMap <String, List<String>> pairHashMap = new HashMap<>();


    public void addAStudent(Student student){
        studentHashMap.put(student.getName(), student);
    }

    public void addATeacher(Teacher teacher){
        teacherHashMap.put(teacher.getName(), teacher);
    }

    public void createPair(String studentName, String teacherName){
        if(!pairHashMap.containsKey(teacherName)){
            List <String> studentList = new ArrayList<>();
            studentList.add(studentName);
            pairHashMap.put(teacherName, studentList);
        }
        else{
            List <String> studentList = pairHashMap.get(teacherName);
            studentList.add(studentName);
            pairHashMap.put(teacherName, studentList);
        }
    }

    public Student findStudent(String studentName){
        return studentHashMap.get(studentName);
    }

    public Teacher findTeacher(String teacherName){
        return teacherHashMap.get(teacherName);
    }

    public List<String> getStudentsOfATeacher(String teacherName){
        return pairHashMap.get(teacherName);
    }

    public List <String> getAllStudents(){
        List <String> students = new ArrayList<>();
        for(String stName: studentHashMap.keySet()){
            students.add(stName);
        }
        return students;
    }

    public void deleteATeacherAndItsStudents(String teacherName){
        teacherHashMap.remove(teacherName);
        List <String> stList = pairHashMap.get(teacherName);
        for(String st: stList){
            studentHashMap.remove(st);
        }
        pairHashMap.remove(teacherName);
    }

    public void deleteAllTeachersAndItsStudents(){
        for(String t: pairHashMap.keySet()){
            List <String> stList = pairHashMap.get(t);
            for(String st: stList){
                studentHashMap.remove(st);
            }
            teacherHashMap.remove(t);
        }
        pairHashMap.clear();
    }
}
