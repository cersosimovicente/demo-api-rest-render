package net.laboratorio.demo_api_rest.repository;


import net.laboratorio.demo_api_rest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Long> {
}
