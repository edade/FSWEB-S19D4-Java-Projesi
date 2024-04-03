package com.workintech.demo.repository;
import com.workintech.demo.entity.Employee;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class EmployeeRepositoryTest {

    private final EmployeeRepository employeeRepository;

    @Autowired
    EmployeeRepositoryTest(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @BeforeEach
    void setUp() {
        Employee employee1 = new Employee();
        employee1.setFirstName("eda");
        employee1.setLastName("eda1");
        employee1.setEmail("eda1@gmail.com");
        employee1.setSalary(1000d);

        Employee employee2 = new Employee();
        employee2.setFirstName("yavuz");
        employee2.setLastName("yavuz1");
        employee2.setEmail("yavuz1@gmail.com");
        employee2.setSalary(2000d);

        Employee employee3 = new Employee();
        employee3.setFirstName("kerem");
        employee3.setLastName("kerem1");
        employee3.setEmail("kerem1@gmail.com");
        employee3.setSalary(3000d);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        employeeRepository.saveAll(employees);
    }

    @AfterEach
    void tearDown() {
        employeeRepository.deleteAll();
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("before All");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("AFTER All");
    }

    @Test
    @DisplayName(value = "find employee by email user tests")
    void findByEmail() {
        String nonExistEmail = "eda1@gmail.com";
        Optional<Employee> employeeOptional = employeeRepository.findByEmail(nonExistEmail);
        assertEquals(Optional.empty(), employeeOptional);

        String existEmail = "yavuz1@gmail.com";
        Optional<Employee> employeeOptionalExist = employeeRepository.findByEmail(existEmail);
        assertNotNull(employeeOptionalExist.get());
        assertEquals("yavuz", employeeOptionalExist.get().getFirstName());
        assertEquals(3000d, employeeOptionalExist.get().getSalary());
    }

    @Test
    void findBySalary() {
        List<Employee> employees = employeeRepository.findBySalary(1800);
        assertEquals(2, employees.size());
    }

    @Test
    void findByOrder() {
        List<Employee> employees = employeeRepository.findByOrder();
        assertEquals(3,employees.size());
        assertEquals("yavuz",employees.get(0).getFirstName());
        assertEquals("eda",employees.get(1).getFirstName());
    }
}