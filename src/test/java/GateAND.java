public class GateAND extends Device {
    private boolean ANDValue;

    @Override
    public void setInput(boolean value) {
        ANDValue = value;
    }

    @Override
    public boolean getOutput()
    {
        boolean temp = this.iPins.get(0).getOutput();
        for(int i = 0; i < iPins.size(); i++){
            temp = temp & iPins.get(i).getOutput();
        }
            return temp;
    }
}
