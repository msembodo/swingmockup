package net.msembodo.swingmockup.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import net.msembodo.swingmockup.model.Student;

@Transactional
public interface StudentDao extends CrudRepository<Student, Long> {

}
