package org.wintrisstech;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * This project is designed as a starting point for students learning about
 * arrays. <p> Images in this project are public domain from
 * http://openclipart.org
 *
 * @author aaron@wintrisstech.org (Aaron VonderHaar)
 * @author http://wintrisstech.org
 */
public class AppleTree extends JComponent implements MouseListener, ActionListener
{

    private Image tree;
    private Image background;
    private Image weather;
    private Image apple;
    private Image basket;
    private int[] applex = new int [10];
    private int[] appley = new int [10];
    private int appleNumber = 0;
    private boolean[] appleFalling = new boolean [10];
    
    
    
    private int weatherX = 530;

    public static void main(String[] args) throws IOException
    {
        JFrame window = new JFrame("Apple Tree");
        AppleTree game = new AppleTree();
        window.add(game);
        window.addMouseListener(game);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        Timer t = new Timer(100, game);
        t.start();
    }

    public AppleTree() throws IOException
    {
        tree = ImageIO.read(getClass().getResource("PeterM_Tree.png"));
        background = ImageIO.read(getClass().getResource("ryanlerch_grassy_horizon_(gradient).png"));
        weather = ImageIO.read(getClass().getResource("Weather.png"));
        apple = ImageIO.read(getClass().getResource("johnny_automatic_apple.png"));
        basket = ImageIO.read(getClass().getResource("johnny_automatic_5_8_bushel_basket.png"));
        applex[0] = 70;
        appley[0] = 110;
        applex[1] = 110;
        appley[1] = 160;
        applex[2] = 140;
        appley[2] = 60;
        applex[3] = 180;
        appley[3] = 210;
        applex[4] = 220;
        appley[4] = 100;
        applex[5] = 260;
        appley[5] = 190;
        applex[6] = 300;
        appley[6] = 130;
        applex[7] = 340;
        appley[7] = 250;
        applex[8] = 380;
        appley[8] = 140;
        applex[9] = 370;
        appley[9] = 300;
        
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(800, 600);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        g.drawImage(background, 0, 0, 800, 600, null);
        g.drawImage(weather, weatherX, -50, 350, 437 * 350 / 800, null);
        g.drawImage(tree, 40, 30, 712 * 550 / 800, 550, null);
        for(int i = 0; i < 10; i ++)
        {
            g.drawImage(apple,applex[i],appley[i],50,50,null);
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent me)
    {
        appleFalling[appleNumber] = true;
        appleNumber ++;
        
    }

    @Override
    public void mousePressed(MouseEvent me)
    {
    }

    @Override
    public void mouseReleased(MouseEvent me)
    {
    }

    @Override
    public void mouseEntered(MouseEvent me)
    {
    }

    @Override
    public void mouseExited(MouseEvent me)
    {
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        weatherX -= 1;
       for(int i = 0; i < 10; i++)
       {
         if(appley[i] < 531 && appleFalling [i] == true)
        {
                appley[i]+= 10;  
        }   
       }
       
        
  
        repaint();
    }
}
