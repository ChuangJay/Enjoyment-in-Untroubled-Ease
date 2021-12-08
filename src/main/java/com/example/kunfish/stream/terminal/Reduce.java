package com.example.kunfish.stream.terminal;

import com.example.kunfish.stream.terminal.model.Product;
import com.example.kunfish.stream.terminal.model.Rating;
import com.example.kunfish.stream.terminal.model.Review;
import com.example.kunfish.stream.terminal.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Reduce {

    @Test
    public void demo_primitiveStream() {

        // initial source
        var data = new Integer[]{1, 2, 3};
        var origin = Arrays.stream(data).collect(Collectors.toList());

        // =========
        var expect = origin.stream().reduce(0, (x, y) -> x + y);
        // >>>>>====

        System.out.println(origin);
        System.out.println(expect);
        Assertions.assertEquals(6, expect);
    }

    @Test
    public void demo_objStreamReturnNumber() {

        // initial source
        var data = new Product[3];
        data[0] = new Product("apple", 1);
        data[1] = new Product("book", 2);
        data[2] = new Product("card", 3);
        var boxContent = Arrays.stream(data).collect(Collectors.toList());

        // <<<<<==== compiler error
        // var expect = origin.stream().reduce(0,(x,y) -> x + y.getPrice() );
        // =========
        var totalPrice = boxContent.stream().reduce(0, (x, y) -> x + y.getPrice(), Integer::sum);
        // >>>>>====

        System.out.println(boxContent);
        System.out.println(totalPrice);
        Assertions.assertEquals(6, totalPrice);
    }

    @Test
    public void demo_returnCusomObjReturnObj() {

        // initial source
        User alice = new User("Alice", 40);
        alice.getRating().add(new Review(5, ""));
        alice.getRating().add(new Review(3, "cool!"));
        User bob = new User("Bob", 50);
        bob.getRating().add(new Review(4, "great!"));
        bob.getRating().add(new Review(2, "no surprise..."));
        bob.getRating().add(new Review(4, ""));
        List<User> users = Arrays.asList(alice, bob);

        // =========
        Rating averageRating = users.stream()
                .reduce(new Rating(),
                        (rating, user) -> Rating.average(rating, user.getRating()),
                        Rating::average);
        // >>>>>====

        Assertions.assertEquals(3.6, averageRating.getPoints());

    }

    @Test
    public void demo_throwsException() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int divider = 0;

        Assertions.assertThrows(ArithmeticException.class, () ->{
            int resultCatch = numbers.stream().reduce(0, (x, y)  -> {
                    return x/divider + y/divider;
            } );
        } );
    }

    @Test
    public void demo_catchExceptionAndRetunNumber() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int divider = 0;

            int actual = numbers.stream().reduce(0, (x, y)  -> {
                try {
                    // =========
                    return x/divider + y/divider;
                    // >>>>>====
                } catch (ArithmeticException  e) {
                    e.printStackTrace();
                    return 0;
                }
            } );
        Assertions.assertEquals(0,actual);
    }

}