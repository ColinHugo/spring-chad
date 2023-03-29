package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements IStudentDAO{

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl( EntityManager entityManager ) {
        this.entityManager = entityManager;
    }

    // implements save method

    @Override
    @Transactional
    public void save( Student student ) {
        entityManager.persist( student );
    }

    @Override
    public Student findById( Integer id ) {
        return entityManager.find( Student.class, id );
    }

    @Override
    public List< Student > findAll() {

        // create query
        TypedQuery< Student > theQuery = entityManager.createQuery( "FROM Student", Student.class );

        // return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName( String lastName ) {

        // create query
        TypedQuery< Student > theQuery = entityManager.createQuery( "FROM Student WHERE lastName=:theData", Student.class );

        // set query parameters
        theQuery.setParameter( "theData", lastName );

        // return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update( Student student ) {
        entityManager.merge( student );
    }

    @Override
    @Transactional
    public void delete( Integer id ) {

        // retrieve the student
        Student student = entityManager.find( Student.class, id );

        // delete the student
        entityManager.remove( student );
    }

    @Override
    @Transactional
    public int deleteAll() {

        int numRowsDeleted = entityManager.createQuery( "DELETE from Student" ).executeUpdate();
        return numRowsDeleted;
    }
}