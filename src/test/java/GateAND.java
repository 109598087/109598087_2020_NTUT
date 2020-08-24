public class GateAND extends Device{
    private boolean inputValue;
    @Override
    public void setInput(boolean value)
    {
        inputValue = value;
    }
    @Override
    public boolean getOutput()
    {
        return this.iPins.get(0).getOutput() & this.iPins.get(1).getOutput();
    }
}
