package com.riwi.Multimedia.content.management.infrastructure.services;

import com.riwi.Multimedia.content.management.api.dto.request.StudentReq;
import com.riwi.Multimedia.content.management.api.dto.response.StudentResp;
import com.riwi.Multimedia.content.management.domain.entities.Clss;
import com.riwi.Multimedia.content.management.domain.entities.Student;
import com.riwi.Multimedia.content.management.domain.repositories.ClssRepository;
import com.riwi.Multimedia.content.management.domain.repositories.StudentRepository;
import com.riwi.Multimedia.content.management.infrastructure.abstrac_services.IStudentService;
import com.riwi.Multimedia.content.management.util.exeptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class StudentService implements IStudentService {

    @Autowired
    private final StudentRepository studentRepository;

    private final ClssRepository clssRepository;

    @Override
    public StudentResp create(StudentReq request) {
        Student student = this.requestToStudent(request, new Student());
        Clss clss = this.clssRepository.findById(request.getClass_id()).orElseThrow(()-> new IdNotFoundException("class"));
        student.setClass_id(clss);
        student.setActive(true);
        student.setCreated_at(LocalDateTime.now());

        return this.entityResponse(this.studentRepository.save(student));
    }

    @Override
    public Page<StudentResp> getAll(Pageable pageable) {
        Page<Student> studentPage = studentRepository.findAll(pageable);
        return studentPage.map(student->this.entityResponse(student));
    }

    @Override
    public StudentResp update(Long aLong, StudentReq request) {
        Student student = this.find(aLong);
        Student studentUpdate = this.requestToStudent(request, student);
        return this.entityResponse(this.studentRepository.save(studentUpdate));
    }

    @Override
    public StudentResp disable(Long id) {
        Student student = this.find(id);
        student.setActive(false);

        return this.entityResponse(this.studentRepository.save(student));
    }

    @Override
    public StudentResp get(Long aLong) {
        return this.entityResponse(this.find(aLong));
    }

    /*private Student findByName(String name){
        return this.s
    }*/

    private Student find(Long id){
        return this.studentRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Student"));
    }

    public static StudentResp entityResponse(Student entity){
        StudentResp response = new StudentResp();
        BeanUtils.copyProperties(entity,response);
        return response;
    }


    private Student requestToStudent (StudentReq request, Student student){
        BeanUtils.copyProperties(request, student);

        return student;

    }
}
