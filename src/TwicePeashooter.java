import javax.swing.*;
import java.awt.event.ActionEvent;


public class TwicePeashooter extends Plant {
    public Timer shootTimer;


    public TwicePeashooter(GamePanel parent, int x, int y) {
        super(parent, x, y);
        setImage(new ImageIcon(this.getClass().getResource("images/plants/twicepeashooter.gif")).getImage());
        shootTimer = new Timer(2000, (ActionEvent e) -> {
            boolean has=false;
            for(int i=0;i<getGp().getLaneZombies().get(y).size();++i){
                if(getGp().getLaneZombies().get(y).get(i).getX()>this.getX() * 100){
                    has=true;
                    break;
                }
            }
            if (has) {
                getGp().getLanePeas().get(y).add(new Pea(getGp(), y, 110 + this.getX() * 100));
                getGp().getLanePeas().get(y).add(new Pea(getGp(), y, 80 + this.getX() * 100));
            }
        });
        shootTimer.start();
    }

    @Override
    public void stop() {
        super.stop();
        shootTimer.stop();
    }
}