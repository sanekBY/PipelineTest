import org.junit.Test;

import java.util.Random;

/**
 * Created by sashqua on 2/9/17.
 */
public class RandomTest {

    @Test
    public void randTest(){
        for (int i = 0; i < 20; ++i) {
        System.out.println(new Random().nextInt(5)+1);
        }
    }
}
