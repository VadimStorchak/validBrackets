import org.example.utils.ValidBracketsUtil;
import org.example.view.ValidateBracketsResult;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ValidateBracketsServiceTest {
    
    @Test
    public void firstExample() {
        String inputString = "(()";
        System.out.println("Input string = " + inputString);

        ValidateBracketsResult result = ValidBracketsUtil.validateString(inputString);

        assertThat(result.getValidBrackets()).isEqualTo("()");
        assertThat(result.getCountOfBrackets()).isEqualTo(2);
    }

    @Test
    public void secondExample() {
        String inputString = ")()())";
        System.out.println("Input string = " + inputString);

        ValidateBracketsResult result = ValidBracketsUtil.validateString(inputString);

        assertThat(result.getValidBrackets()).isEqualTo("()()");
        assertThat(result.getCountOfBrackets()).isEqualTo(4);
    }
    @Test
    public void thirdExample() {
        String inputString = ")(()())";
        System.out.println("Input string = " + inputString);

        ValidateBracketsResult result = ValidBracketsUtil.validateString(inputString);

        assertThat(result.getValidBrackets()).isEqualTo("(()())");
        assertThat(result.getCountOfBrackets()).isEqualTo(6);
    }
    @Test
    public void fourthExample() {
        String inputString = ")(";
        System.out.println("Input string = " + inputString);

        ValidateBracketsResult result = ValidBracketsUtil.validateString(inputString);

        assertThat(result.getValidBrackets()).isEqualTo("");
        assertThat(result.getCountOfBrackets()).isEqualTo(0);
    }
    @Test
    public void fifthExample() {
        String inputString = "())(()())(()";
        System.out.println("Input string = " + inputString);

        ValidateBracketsResult result = ValidBracketsUtil.validateString(inputString);

        assertThat(result.getValidBrackets()).isEqualTo("()(()())()");
        assertThat(result.getCountOfBrackets()).isEqualTo(10);
    }

    @Test
    public void muchLeftBrackets() {
        String inputString = ")(((((";
        System.out.println("Input string = " + inputString);

        ValidateBracketsResult result = ValidBracketsUtil.validateString(inputString);

        assertThat(result.getValidBrackets()).isEqualTo("");
        assertThat(result.getCountOfBrackets()).isEqualTo(0);
    }

    @Test
    public void twoLeftRightLeftTwoRightBrackets() {
        String inputString = "(()())";
        System.out.println("Input string = " + inputString);

        ValidateBracketsResult result = ValidBracketsUtil.validateString(inputString);

        assertThat(result.getValidBrackets()).isEqualTo("(()())");
        assertThat(result.getCountOfBrackets()).isEqualTo(6);
    }
    @Test
    public void emptyImputString() {
        String inputString = "";
        System.out.println("Input string = " + inputString);

        ValidateBracketsResult result = ValidBracketsUtil.validateString(inputString);

        assertThat(result.getValidBrackets()).isEqualTo("");
        assertThat(result.getCountOfBrackets()).isEqualTo(0);
    }

    @Test
    public void oneInnerBrackets() {
        String inputString = ")(())))";
        System.out.println("Input string = " + inputString);

        ValidateBracketsResult result = ValidBracketsUtil.validateString(inputString);

        assertThat(result.getValidBrackets()).isEqualTo("(())");
        assertThat(result.getCountOfBrackets()).isEqualTo(4);
    }

    @Test
    public void tripleInnerBrackets() {
        String inputString = "))))(()(())())(";
        System.out.println("Input string = " + inputString);

        ValidateBracketsResult result = ValidBracketsUtil.validateString(inputString);

        assertThat(result.getValidBrackets()).isEqualTo("(()(())())");
        assertThat(result.getCountOfBrackets()).isEqualTo(10);
    }
}
