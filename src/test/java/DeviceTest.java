import org.junit.*;

import java.util.Vector;

import static org.junit.Assert.*;

public class DeviceTest
{
    @Before
    public void setUp(){}
    @Before
    public void tearDown(){}
    @Test
    public void testDevicePolymorphism()
    {
        Device device= new IPin();
        assertEquals(IPin.class.getName(), device.getClass().getName());

        device = new OPin();
        assertEquals(OPin.class.getName(), device.getClass().getName());

        device = new GateNOT();
        assertEquals(GateNOT.class.getName(), device.getClass().getName());

        device = new GateAND();
        assertEquals(GateAND.class.getName(), device.getClass().getName());

        device = new GateOR();
        assertEquals(GateOR.class.getName(), device.getClass().getName());
    }
    @Test
    public void testIPinAndOPin()
    {
        // 0 = 0
        IPin iPin = new IPin();
        iPin.setInput(false);

        OPin oPin = new OPin();
        oPin.addInputPin(iPin);
        assertEquals(false, oPin.getOutput());

        // 1 = 1
        iPin = new IPin();
        iPin.setInput(true);

        oPin = new OPin();
        oPin.addInputPin(iPin);
        assertEquals(true, oPin.getOutput());


    }
    @Test
    public void testGateNOT()
    {
        // NOT 0 = 1
        IPin iPin = new IPin();
        iPin.setInput(false);

        GateNOT gateNOT = new GateNOT();
        gateNOT.addInputPin(iPin);

        assertEquals(true, gateNOT.getOutput());

        /* implement NOT 1 = 0 test */
        iPin = new IPin();
        iPin.setInput(true);

        gateNOT = new GateNOT();
        gateNOT.addInputPin(iPin);

        assertEquals(false, gateNOT.getOutput());
    }
    @Test
    public void testGateAND()
    {
        // 0 AND 0 = 0
        IPin iPin1 = new IPin();
        IPin iPin2 = new IPin();
        iPin1.setInput(false);
        iPin2.setInput(false);

        GateAND gateAND = new GateAND();
        gateAND.addInputPin(iPin1);
        gateAND.addInputPin(iPin2);

        assertEquals(false, gateAND.getOutput());

    /* implement 0 AND 1 = 0,
                 1 AND 0 = 0,
                 1 AND 1 = 1 test */

    }









}
