import java.util.Vector;

public class Device {
    protected Vector<Device> iPins;

    public Device()
    {
        iPins = new Vector<>();
    }

    public void addInputPin(Device iPin)
    {

        this.iPins.add(iPin);
    }

    public void setInput(boolean value)
    {
        throw new RuntimeException("no setInput"); // complete this method by yourself
    }

    public boolean getOutput()
    {
        throw new RuntimeException("no getOutput");
    }

}
