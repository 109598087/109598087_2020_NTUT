
import java.io.*;
import java.lang.invoke.SwitchPoint;
import java.util.Vector;

import static org.junit.Assert.assertEquals;


public class LogicSimulator {
    private Vector<Device> circuits;
    private Vector<Device> iPins;
    private Vector<Device> oPins;
    public LogicSimulator()
    {
        circuits = new Vector<>();
        iPins = new Vector<>();
        oPins = new Vector<>();
    }
    public boolean load(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String string_line1 = br.readLine();
        String string_line2 = br.readLine();
        Vector string_line3_v = new Vector();
        while (br.ready()) {
            string_line3_v.add(br.readLine());
        }
        fr.close();
        int input_pins_num = Integer.valueOf(string_line1);
        int gates_num = Integer.valueOf(string_line2);
        String s_test = (String)string_line3_v.get(0);
        String[] s_s_test = s_test.split(" ");

        // 011
        IPin iPin1 = new IPin();
        IPin iPin2 = new IPin();
        IPin iPin3 = new IPin();
        iPin1.setInput(false);
        iPin2.setInput(true);
        iPin3.setInput(true);
//        iPins.add(iPin1);
//        iPins.add(iPin2);
//        iPins.add(iPin3);
        GateAND gateAND = new GateAND();
        GateNOT gateNOT = new GateNOT();
        GateOR gateOR = new GateOR();
        gateNOT.addInputPin(iPin2);

        gateOR.addInputPin(iPin3);

        IPin iPin2_1 = new IPin();
        iPin2_1.setInput(gateNOT.getOutput());
        gateOR.addInputPin(iPin2_1);
        assertEquals(true,gateOR.getOutput());
        IPin iPin3_1 = new IPin();
        iPin3_1.setInput(gateOR.getOutput());

        gateAND.addInputPin(iPin1);
        gateAND.addInputPin(iPin2_1);
        gateAND.addInputPin(iPin3_1);
        assertEquals(false,gateOR.getOutput());









        return false;
    }
//    public String getSimulationResult(Vector<Boolean> inputValues)
//    {
//
//        String simulation_result=
//                "Simulation Result:\n" +
//                "i i i | o\n" +
//                "1 2 3 | 1\n" +
//                "------+--\n" +
//               inputValues.get(0).compareTo(false)+" "+inputValues.get(1).compareTo(false)+" "+inputValues.get(2).compareTo(false)+" | "
//                ;
//
//        return simulation_result;
//    }
}
