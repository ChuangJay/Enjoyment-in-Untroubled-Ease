package com.example.kunfish.stream.transformation;

import com.example.kunfish.stream.transformation.model.Employee;
import com.example.kunfish.stream.transformation.model.Manager;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Map {

    @Test
    public void demo_concat() {
        var source = Stream.of("莊子", "老子");
        var expect = new String[]{"莊子大師", "老子大師"};
        var actual = source.map(s -> s.concat("大師")).toArray(String[]::new);
    }

    @Test
    public void demo_objectCanMapToOtherObject() {
        var data = new Employee[1];
        data[0] = new Employee("Alice", 100, 2021, 1, 1);

        // key point is here
        var origin = Arrays.stream(data).collect(Collectors.toList());
        var expect = origin.stream().map(
                emp -> {
                    var manager = new Manager();
                    manager.setBonus(1000);
                    return manager;
                }
        ).collect(Collectors.toList());
        System.out.println(origin);
        System.out.println(expect);
    }
}

