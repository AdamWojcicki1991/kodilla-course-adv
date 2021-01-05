package com.kodilla.bytecode.reflection;

import java.lang.reflect.Field;

public class ReflectionStudentTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Student student = new Student();
        Field indexNumberField = Student.class.getDeclaredField("indexNumber");
        indexNumberField.setAccessible(true);

        String indexNumberFieldValue = (String) indexNumberField.get(student);
        System.out.println(indexNumberFieldValue);
    }
}
