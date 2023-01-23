package org.example.utils;

import org.example.view.ValidateBracketsResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ValidBracketsUtil {

    private static final Character openBracket = '(';
    private static final Character closeBracket = ')';

    private ValidBracketsUtil() {
        throw new IllegalStateException("Can't init this Class");
    }

    public static ValidateBracketsResult validateString(String inputString) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> forDeleteIndex = new ArrayList<>();
        for (int i = 0; i < inputString.length(); i++) {
            char currBracket = inputString.charAt(i);
            if (currBracket == closeBracket) {
                if (stack.isEmpty()) {
                    forDeleteIndex.add(i);
                } else {
                    stack.pop();
                }
            }
            if (currBracket == openBracket) {
                stack.push(i);
            }
        }
        forDeleteIndex.addAll(stack.stream().toList());
        AtomicInteger counter = new AtomicInteger(0);
        String validString = inputString.chars()
                .mapToObj(c -> (char) c)
                .filter(o -> {
                    Integer index = counter.getAndIncrement();
                    return !forDeleteIndex.contains(index);
                })
                .map(Object::toString)
                .collect(Collectors.joining());
        ValidateBracketsResult result = ValidateBracketsResult.fromValidString(validString);
        System.out.println(result);
        return result;
    }
}
