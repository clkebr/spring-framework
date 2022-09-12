package com.spring.bootstrap;

import com.github.javafaker.Faker;
import com.spring.model.Student;

import java.util.Arrays;
import java.util.List;

public class DataGenerator {
    public static List<Student> createStudent(){

        List<Student> students= Arrays.asList(
                new Student(new Faker().name().firstName(), new Faker().name().lastName(),new Faker().address().state(),new Faker().number().numberBetween(20,50) ),
                new Student(new Faker().name().firstName(), new Faker().name().lastName(),new Faker().address().state(),new Faker().number().numberBetween(20,50) ),
                new Student(new Faker().name().firstName(), new Faker().name().lastName(),new Faker().address().state(),new Faker().number().numberBetween(20,50) ),
                new Student(new Faker().name().firstName(), new Faker().name().lastName(),new Faker().address().state(),new Faker().number().numberBetween(20,50) )
    );
        return students;
    }
}
