import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    @Test
    public void testMain1() {
        //Arrange
        String input = "X*X";
        String expected = "C";

        //Act
        String result = Main.calc(input);

        //Assert
        Assert.assertEquals(expected,result);
    }


    @Test
    public void testMain2() {
        //Arrange
        String input = "             10    *   10  ";
        String expected = "100";

        //Act
        String result = Main.calc(input);

        //Assert
        Assert.assertEquals(expected,result);
    }

    @Test(expected = RuntimeException.class)
    public void testMain3() {
        //Arrange
        String input = "10*X";

        //Act
        String result = Main.calc(input);
    }

    @Test
    public void testMain4() {
        //Arrange
        String input = "6-10";
        String expected = "-4";

        //Act
        String result = Main.calc(input);

        //Assert
        Assert.assertEquals(expected,result);
    }

    @Test(expected = RuntimeException.class)
    public void testMain5() {
        //Arrange
        String input = "VI-X";

        //Act
        String result = Main.calc(input);

    }


}
