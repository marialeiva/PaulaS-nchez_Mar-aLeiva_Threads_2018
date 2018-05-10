package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

public class StandingCharacter extends Character {
//SI está corriendo y consumiento recursos
    public StandingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite(0);
    }
    
    public void setSprite(int num) throws FileNotFoundException{
        ArrayList<Image> sprite = super.getSprite();
        //for(int i = 0; i < 4; i++){
            sprite.add(new Image(new FileInputStream("src/Assets/Standing"+num+".png")));
        //}
        super.setSprite(sprite);
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        int num=0;
        while (true) {
            try {
                //Establece un rango de imagenes
                if(num==4)
                    num=0;
                
                //Movimiento del parpadeo a 200 ms
                super.setImage(sprite.get(num));
                Thread.sleep(200);
                setSprite(num);
                num++;
            } 
            catch (InterruptedException ex) { } catch (FileNotFoundException ex) {
                Logger.getLogger(StandingCharacter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
