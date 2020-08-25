
import java.io.*;
import java.lang.invoke.SwitchPoint;
import java.util.Vector;
import java.util.*;

import static org.junit.Assert.assertEquals;


public class LogicSimulator {
    private Vector<Device> circuits;
    private Vector<Device> iPins;
    private Vector<Device> oPins;

    public LogicSimulator() {
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
        String[] string_line3_s = new String[string_line3_v.size()];
        for(int i=0;i<string_line3_v.size();i++){
            string_line3_s[i] = (String)string_line3_v.get(i);
        }
        String[] string_line3_copy = string_line3_s.clone();



        int input_pins_num = Integer.valueOf(string_line1);
        int gates_num = Integer.valueOf(string_line2);


        List<Integer> input_ok_list = new ArrayList<Integer>(); //順序

        for(int ok=0;ok<gates_num;ok++){
            // one_row 判斷input都有出來(用負號)
            for(int i=0;i<string_line3_s.length;i++){
                String[] s_split = string_line3_copy[i].split(" ");
                int count_m = 0;
                for(int j=1; j< s_split.length-1 ;j++){
                    if (s_split[j].contains("-")){
                        count_m += 1;
                    }
                }
                if(count_m == s_split.length-2){
                    input_ok_list.add(i);
                }
            }

            // replace
            int[] want_replace = new int[string_line3_copy.length];
            for(int k =0;k<input_ok_list.size();k++){
                int num = input_ok_list.get(k) + 1;
                for(int i = 0;i<string_line3_copy.length;i++){
                    String[] s_split = string_line3_s[i].split(" ");

                    for(int j = 0;j<s_split.length;j++){
                        if(s_split[j].charAt(0) == '-'){
                            continue;
                        }
                        if(Integer.parseInt(String.valueOf(s_split[j].charAt(0))) == num){
                            want_replace[i] = j;
                        }

                    }
                }
            }
            for(int i = 0;i<string_line3_copy.length;i++){
                String[] s_split = string_line3_copy[i].split(" ");
                if(want_replace[i] == 0){
                    continue;
                }
                String temp_str = new String();
                s_split[want_replace[i]] = s_split[want_replace[i]].replace(s_split[want_replace[i]].charAt(0), '-');
                string_line3_copy[i] = "";
                for(int j = 0;j<s_split.length;j++){
                    string_line3_copy[i] += s_split[j];
                    string_line3_copy[i] += " ";
                }
            }

            for(int i = 0;i<string_line3_copy.length;i++){
                System.out.println(string_line3_copy[i]);
            }
            for(int i = 0;i<input_ok_list.size();i++){
                System.out.print(input_ok_list.get(i));
            }
            System.out.println();
        }


        // 挑出input_ok的出來做







//        // 011
//        IPin iPin1 = new IPin();
//        IPin iPin2 = new IPin();
//        IPin iPin3 = new IPin();
//        iPin1.setInput(true);
//        iPin2.setInput(true);
//        iPin3.setInput(true);
////        iPins.add(iPin1);
////        iPins.add(iPin2);
////        iPins.add(iPin3);
//        GateAND gateAND = new GateAND();
//        GateNOT gateNOT = new GateNOT();
//        GateOR gateOR = new GateOR();
//        gateNOT.addInputPin(iPin2);
//
//        gateOR.addInputPin(iPin3);
//
//        IPin iPin2_1 = new IPin();
//        iPin2_1.setInput(gateNOT.getOutput());
//        gateOR.addInputPin(iPin2_1);
//
//        IPin iPin3_1 = new IPin();
//        iPin3_1.setInput(gateOR.getOutput());
//
//        gateAND.addInputPin(iPin1);
//        gateAND.addInputPin(iPin2_1);
//        gateAND.addInputPin(iPin3_1);
//        assertEquals(false, gateAND.getOutput());


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
