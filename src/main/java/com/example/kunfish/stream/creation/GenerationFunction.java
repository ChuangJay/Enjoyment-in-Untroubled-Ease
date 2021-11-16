package com.example.kunfish.stream.creation;

import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class GenerationFunction {
    @Test
    public void demo_infinieGenerate_WithMethodRefence() {
        final int SIZE = 10;
        Stream<Double> randoms = Stream.generate(Math::random);
        List<Double> list = randoms
                .limit(SIZE + 1)
                .collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    public void demo_infiteGenertate_WithLamda() {
        final int SIZE = 10;
        Stream<String> echos = Stream.generate(() -> "Echo");
        List<String> echosLst = echos
                .limit(SIZE + 1)
                .collect(Collectors.toList());
        System.out.println(echosLst);

    }

    @Test
    public void demo_of(){
        final int SIZE =10;
        Stream<String> song = Stream.of("gently", "down", "the", "stream");
    }

    @Test
    public void demo_iterate() {
        final int SIZE = 10;
        var limit = new BigInteger("10000000");
        Stream<BigInteger> integers
                = Stream.iterate(BigInteger.ZERO /*init part*/,
                n -> n.compareTo(limit) < 0 /* condi part*/,
                n -> n.add(BigInteger.ONE) /* incream part*/);
        List<BigInteger> integersList = integers
                .collect(Collectors.toList());
        System.out.println(integersList);
    }
}
