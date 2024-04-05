import javax.swing.*;

public class MainFrame extends JFrame implements Runnable{
    private Thread windowThread;
    public MainFrame(String display) {
        super(display);
        int frameWidth = 500;
        int frameHeight = 500;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(frameWidth, frameHeight);
        this.setLocation(600, 100);
        this.setVisible(true);
        startThread();
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
