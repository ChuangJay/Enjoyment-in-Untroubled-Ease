package com.example.kunfish.stream.transformation;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class Filter {

    @Test
    public void demo_lambdaExpression (){

        var expect = new String[]{"韓非子","鬼谷子"} ;
        var source = Stream.of("莊子","老子","韓非子","鬼谷子","孫子");
        var result = source.filter(w -> w.length() > 2).toArray(String[]::new);

    }


}
