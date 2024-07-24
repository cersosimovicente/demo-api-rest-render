package net.laboratorio.demo_api_rest.servicio;

import net.laboratorio.demo_api_rest.entity.Student;
import net.laboratorio.demo_api_rest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    //findAll
    public List<Student> findAll(){
        return  studentRepository.findAll();
    }

    //findById
    public Student findById(Long id){
        return studentRepository.findById(id).orElse(null);
    }

    //save
    public Student save(Student student){
        return studentRepository.save(student);
    }

    //update
    public Student studentUpdate(Long id, Student student){
        Student studentToUpdate = findById(id);
        if (studentToUpdate == null) {
            return null;

        }else {
            studentToUpdate.setName(student.getName());
            studentToUpdate.setCourse(student.getCourse());
            studentRepository.save(studentToUpdate);
            return  studentToUpdate;
        }
    }

    //delete
    public void studentDelete(Long id){
        Student studentToDelete = findById(id);
        if (studentToDelete != null) {
          studentRepository.deleteById(id);
        }
    }

}
