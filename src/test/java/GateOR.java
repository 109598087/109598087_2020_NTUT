public class GateOR extends Device{
    private boolean ORValue;

    @Override
    public void setInput(boolean value) {
        ORValue = value;
    }

    @Override
    public boolean getOutput()
    {
        boolean temp = this.iPins.get(0).getOutput();
        for(int i = 0; i < iPins.size(); i++){
            temp = temp | iPins.get(i).getOutput();
        }
        return temp;
    }
}
