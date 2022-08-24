package org.example;

import org.assertj.core.util.Streams;
import org.example.calculate.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * 요구사항
 * 간단한 사칙연산을 할 수 있다.
 * 양수로만 계산할 수 있다.
 * 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.
 * MVC패턴(Model-View-Controller) 기반으로 구현한다.
 */

public class CalculatorTest {

    @DisplayName("덧셈 연산을 수행한다.")
    @Test
    void additionTest() {
        int result = Calculator.calculate(new PositiveNumber(1), "+", new PositiveNumber(2));
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("뺄셈 연산을 수행한다.")
    @Test
    void subtractionTest() {
        int result = Calculator.calculate(new PositiveNumber(1), "-", new PositiveNumber(2));
        assertThat(result).isEqualTo(-1);
    }

    @DisplayName("테스트 리팩토링 버전")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void calculateTest(PositiveNumber operand1, String operator, PositiveNumber operand2, int result){
        int calculateResult = Calculator.calculate(operand1, operator, operand2);
        assertThat(calculateResult).isEqualTo(result);
    }

    private static Stream<Arguments> formulaAndResult(){
        return Stream.of(
                arguments(new PositiveNumber(1), "+", new PositiveNumber(2), 3),
                arguments(new PositiveNumber(1), "-", new PositiveNumber(2), -1),
                arguments(new PositiveNumber(4), "*", new PositiveNumber(2), 8),
                arguments(new PositiveNumber(4), "/", new PositiveNumber(2), 2)
        );
    }

    // operand가 모두 양수임이 보장되므로 아래 테스트는 여기서 불필요, 별도의 테스트 파일을 만들어 ExceptionTest 하는 것을 권장
//    @DisplayName("나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.")
//    @Test
//    void calculateExceptionTest() {
//        assertThatCode(()-> Calculator.calculate(new PositiveNumber(10), "/", new PositiveNumber(0)))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("0으로는 나눌 수 없습니다.");
//    }
}
