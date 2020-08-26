public class GateOR extends Device{

    @Override
    public boolean getOutput()
    {
        boolean temp = false;
        if (iPins.size() <=1){
            return temp;
        }
        for(int i = 0; i < iPins.size(); i++){
            temp = temp | iPins.get(i).getOutput();
        }
        return temp;
    }
}
