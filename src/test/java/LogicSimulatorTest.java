import org.junit.*;
import static org.junit.Assert.*;
import java.io.IOException;
import java.util.Vector;
public class LogicSimulatorTest
{
    String file1Path;
    String file2Path;

    @Before
    public void setUp()
    {
        file1Path = "src/File1.lcf";
        file2Path = "src/File2.lcf";
    }
    @Test
    public void testGetSimulationResult()  throws IOException
    {
        LogicSimulator logicSimulator = new LogicSimulator();


        //011
        Vector<Boolean> inputValues = new Vector<>();

        inputValues.add(true);
        inputValues.add(true);
        inputValues.add(true);
        logicSimulator.load(file2Path);



        assertEquals("Simulation Result:\n" +
                "i i i | o\n" +
                "1 2 3 | 1\n" +
                "------+--\n" +
                "0 1 1 | 0\n", logicSimulator.getSimulationResult(inputValues));
    }

}
