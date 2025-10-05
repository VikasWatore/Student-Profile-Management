package com.dailycodework.demo.service;

import com.dailycodework.demo.exception.StudentAlreadyExistsException;
import com.dailycodework.demo.exception.StudentNotFoundException;
import com.dailycodework.demo.model.Student;
import com.dailycodework.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService{

    private final StudentRepository studentRepository;

    @Override
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student addStudent(Student student) {
        if(studentAlreadyExist(student.getEmail())){
            throw new StudentAlreadyExistsException(student.getEmail()+" Already Exists!");
        }
        return studentRepository.save(student);
    }


    @Override
    public Student updateStudent(Student student, Long id) {
        return studentRepository.findById(id).map(std -> {
            std.setFirstName(student.getFirstName());
            std.setLastName(student.getLastName());
            std.setEmail(student.getEmail());
            std.setDepartment(student.getDepartment());
            return studentRepository.save(std);

        }).orElseThrow(()-> new StudentNotFoundException("Sorry ,this student could not be Found!!") );
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).
                orElseThrow(()-> new StudentNotFoundException("Sorry, No Student Found  with this ID: "+id));
    }

    @Override
    public void deleteStudent(Long id) {
        if(!studentRepository.existsById(id)){
            throw new StudentNotFoundException("Sorry ,student not found");
        }else{
        studentRepository.deleteById(id);
        }
    }
    private boolean studentAlreadyExist(String email) {
   return studentRepository.findByEmail(email).isPresent();
    }
}
