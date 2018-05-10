package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class JumpingCharacter extends Character {

    public JumpingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        //super.setArrayImages(new Image(new FileInputStream("src/Assets/Jumping0.png")));
//        super.setArrayImages(new Image(new FileInputStream("src/Assets/Jumping1.png")));
//        super.setArrayImages(new Image(new FileInputStream("src/Assets/Jumping2.png")));
    
        //Movimiento de las imagenes en el rango entre X y Y
        ArrayList<Image> sprite = super.getSprite();
        
        for (int i = 0; i < 3; i++) {
         sprite.add(new Image(new FileInputStream("src/Assets/Jumping"+i+".png")));
       
        super.setSprite(sprite);
        }
        

        
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        super.setImage(sprite.get(0));
        while (true) {
            try {
                for (int i = 270; i <= 400; i += 2) {
                    Thread.sleep(10);
                    this.setY(i);

                    super.setImage(sprite.get(1));

                    if (i == 400) {
                        super.setImage(sprite.get(2));
                        Thread.sleep(200);
                        for (int j = 400; j >= 270; j -= 2) {
                            Thread.sleep(10);
                            this.setY(j);
                            super.setImage(sprite.get(0));
                        }
                    }
                }
            } catch (InterruptedException ex) {
            }
        }
    }
}

