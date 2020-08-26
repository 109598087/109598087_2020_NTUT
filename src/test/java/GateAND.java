public class GateAND extends Device {

    @Override
    public boolean getOutput()
    {
        boolean temp = true;
        if(iPins.size()<=1){
            return temp;
        }
        for(int i = 0; i < iPins.size(); i++){
            temp = temp && iPins.get(i).getOutput();
        }
            return temp;
    }
}
