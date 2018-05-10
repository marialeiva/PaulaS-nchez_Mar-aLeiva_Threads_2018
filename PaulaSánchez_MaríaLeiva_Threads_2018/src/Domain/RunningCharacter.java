package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

public class RunningCharacter extends Character {

    public RunningCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite(0);
    }
    
    public void setSprite(int num) throws FileNotFoundException{
        ArrayList<Image> sprite = super.getSprite();
        
        sprite.add(new Image(new FileInputStream("src/Assets/Running"+num+".png")));
       
        super.setSprite(sprite);
    }
    
    

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        int num=0;
        int moveInX=100;
        while (true) {
            try {
                //Establece rango de movimientos
                if (moveInX==700) 
                    moveInX=100;
                //Establece un rango de imagenes
                if(num==7)
                    num=0;
                
                super.setImage(sprite.get(num));
                super.setX(moveInX);
                Thread.sleep(100);
                
                //super.setX(700);
                Thread.sleep(100);
                setSprite(num);
                num++;
                moveInX+=15;
            } 
            catch (InterruptedException ex) {} catch (FileNotFoundException ex) {
                Logger.getLogger(RunningCharacter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
