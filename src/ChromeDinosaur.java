import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class ChromeDinosaur extends JPanel implements ActionListener,KeyListener{
    int boardWidth = 750;
    int boardHeight = 250;

    //Images
    Image dinosaurImg;
    Image dinosaurDeadImg;
    Image dinosaurJumpImg;
    Image cactus1Img;
    Image cactus2Img;
    Image cactus3Img;

    class Block{
        int x;
        int y;
        int width;
        int height;
        Image img;

        Block(int x, int y,int width,int height,Image img){
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.img = img;
        }
    }

    //dinosaur
    int dinosaurWidth = 88;
    int dinosaurHeight = 94; 
    int dinosaurX = 50;
    int dinosaurY = boardHeight - dinosaurHeight;

    //physics
    int velocityY = 0; // dino jump speed
    int gravity = 1;

    Block dinosaur;

    Timer gameLoop;


    public ChromeDinosaur(){
        setPreferredSize(new Dimension(boardWidth,boardHeight));
        setBackground(Color.LIGHT_GRAY);
        setFocusable(true);
        addKeyListener(this);
        
        dinosaurImg = new ImageIcon(getClass().getResource("./img/dino-run.gif")).getImage();
        dinosaurDeadImg = new ImageIcon(getClass().getResource("./img/dino-dead.png")).getImage();
        dinosaurJumpImg = new ImageIcon(getClass().getResource("./img/dino-jump.png")).getImage();
        cactus1Img = new ImageIcon(getClass().getResource("./img/cactus1.png")).getImage();
        cactus2Img = new ImageIcon(getClass().getResource("./img/cactus2.png")).getImage();
        cactus3Img = new ImageIcon(getClass().getResource("./img/cactus3.png")).getImage();

        //dinosaur
        dinosaur = new Block(dinosaurX,dinosaurY, dinosaurWidth, dinosaurHeight, dinosaurImg);

        //game timer
        gameLoop = new Timer(1000/60, this);
        gameLoop.start();

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        g.drawImage(dinosaur.img, dinosaur.x, dinosaur.y, dinosaur.width, dinosaur.height, null );
    }

    public void move(){
        //dinosaur
        velocityY += gravity;
        dinosaur.y += velocityY;

        if(dinosaur.y > dinosaurY){
            dinosaur.y = dinosaurY;
            velocityY = 0;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(dinosaur.y == dinosaurY){
            // System.out.println("J");
            velocityY = -17;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {}

}
