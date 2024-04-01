package src.main.java.topicwise.stream.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsProblems {

    public static void main(String[] args) {
        List<String> nameListOne = Arrays.asList("Vidit", "Divanshu", "Yashik", "Vijay", "Abhijatya");
        List<String> nameListTwo = Arrays.asList("Deep", "Sunaina", "Puneet", "Shubham");

        // get name starts with V
        List<String> filteredName =
                nameListOne.stream().filter(name -> name.startsWith("V")).collect(Collectors.toList());
        System.out.println(filteredName);

        // merge two lists
        List<String> mergedNameList =
                Stream.concat(nameListOne.stream(), nameListTwo.stream())
                        .sorted((nameOne, nameTwo) -> nameTwo.compareTo(nameOne))
                        .collect(Collectors.toList());
        System.out.println(mergedNameList);

        // get sum of even numbers of array
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sumOfEvenNumbers = numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer :: intValue)
                .sum();
        System.out.println(sumOfEvenNumbers);

        // Sort employee by name and salary using java 8 stream API
        List<Employee> employees = new ArrayList<>();
        Employee e1 = new Employee("Ajay",35, 1000);
        Employee e2 = new Employee("Vijay",5, 2000);
        Employee e3 = new Employee("Zack",30, 3000);
        Employee e4 = new Employee("David",51, 4000);
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);

        //below print employees with highest age first
        List<Employee> sortedEmployee =
                employees.stream()
                        .sorted(Comparator.comparing(Employee ::getAge).reversed())
                        .collect(Collectors.toList());
        System.out.println(sortedEmployee);

        //below print employees with lowest age first
        sortedEmployee =
                employees.stream()
                        .sorted(Comparator.comparing(Employee ::getAge))
                        .collect(Collectors.toList());
        System.out.println(sortedEmployee);

        //below print employees by sorting with name first and then with age
        sortedEmployee =
                employees.stream()
                        .sorted(Comparator.comparing(Employee :: getName).thenComparing(Employee::getAge))
                        .collect(Collectors.toList());
        System.out.println(sortedEmployee);

        //below print employees by sorting with age first and then with name
        sortedEmployee =
                employees.stream()
                        .sorted(Comparator.comparing(Employee ::getAge).thenComparing(Employee::getName))
                        .collect(Collectors.toList());
        System.out.println(sortedEmployee);

        //below print employees having salary greater then 2000
        sortedEmployee =
                employees.stream()
                        .filter(emp -> emp.getSalary() > 2000)
                        .collect(Collectors.toList());
        System.out.println(sortedEmployee);
    }

}
