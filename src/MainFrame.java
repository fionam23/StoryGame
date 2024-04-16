import javax.swing.*;

public class MainFrame extends JFrame implements Runnable{
    private Thread windowThread;
    private GameRunner panel;
    public MainFrame(String display) {
        super(display);
        int frameWidth = 300;
        int frameHeight = 300;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(frameWidth,frameHeight);
        this.setVisible(true);
        panel = new GameRunner();
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
