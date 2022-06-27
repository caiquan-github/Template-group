import com.google.common.base.Preconditions;
import org.junit.Test;

/**
 * @author Kwon
 */
public class PreconditionsTest {


    @Test
    public void simple(){
        Preconditions.checkArgument(false);
    }

    @Test
    public void test1(){
        int i =-1;
        Preconditions.checkArgument(i>=0, "Argument was %s but expected nonnegative", i);
    }

    @Test
    public void checkState(){
        Preconditions.checkState(true);
    }

}
