package com.example.kunfish.stream.transformation;

import com.example.kunfish.stream.transformation.model.Employee;
import com.example.kunfish.stream.transformation.model.Manager;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {

    @Test
    public void demo_nestListTransforToList() {

        // initial source
        var data = new String[3];
        data[0] = "A";
        data[1] = "B";
        data[2] = "C";
        var data2 = new String[2];
        data2[0] ="D";
        data2[1] ="E";
        var dataList = Arrays.stream(data).collect(Collectors.toList());
        var data2List = Arrays.stream(data2).collect(Collectors.toList());
        List<List<String>> origin = new ArrayList<>();
        origin.add(dataList);
        origin.add(data2List);

        //  List<List<Employee>> --> List<Employee>
        var expect = origin.stream().flatMap(List::stream).collect(Collectors.toList());

        System.out.println(origin);
        System.out.println(expect);
    }
}

