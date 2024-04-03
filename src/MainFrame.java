import javax.swing.*;

public class MainFrame extends JFrame implements Runnable{
    private Thread windowThread;
    private Dr
    public MainFrame(String display) {
        super(display);
        int frameWidth;
        int frameHeight;
        panel = new DrawPanel();
    }
    public void startThread(){
        windowThread = new Thread(this);
        windowThread.start();
    }
    @Override
    public void run() {
        while (true) {

        }
    }
}
