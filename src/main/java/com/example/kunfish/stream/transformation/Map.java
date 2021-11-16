package com.example.kunfish.stream.transformation;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class Map {

    @Test
    public void demo_concat(){
        var source = Stream.of("莊子","老子");
        var expect = new String[]{"莊子大師","老子大師"} ;
        var actual = source.map(s -> s.concat("大師")).toArray(String[]::new);
    }

}

