package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.addAStudent(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.addATeacher(teacher);
    }

    public void createStudentTeacherPair(String student, String teacher){
        studentRepository.createPair(student, teacher);
    }

    public Student getStudent(String student){
        return studentRepository.findStudent(student);
    }

    public Teacher getTeacher(String teacher){
        return studentRepository.findTeacher(teacher);
    }

    public List<String> getStudentsByTeacher(String teacher){
        return studentRepository.getStudentsOfATeacher(teacher);
    }

    public List <String> getAllStudents(){
        return studentRepository.getAllStudents();
    }

    public void deleteTeacher(String teacher){
        studentRepository.deleteATeacherAndItsStudents(teacher);
    }

    public void deleteAllTeachers(){
        studentRepository.deleteAllTeachersAndItsStudents();
    }
}
