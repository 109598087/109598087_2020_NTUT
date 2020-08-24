public class GateNOT extends Device{
    private boolean notValue;
    @Override
    public void setInput(boolean value)
    {
        notValue = value;
    }
    @Override
    public boolean getOutput()
    {
        return !this.iPins.get(0).getOutput();
    }
}
