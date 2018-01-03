/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import com.toedter.calendar.IDateEditor;
import com.toedter.calendar.JDateChooser;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;


/**
 *
 * @author choaib
 */
public class jtest  extends JDateChooser {

    
    public jtest (){
    super();
}
        public jtest (IDateEditor d) {
            super(d);
            init();
        }

     

        protected void init() {
            setOpaque(false);
            
        }

        @Override
        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
            super.paint(g2d);
            g2d.dispose();
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
          
            super.paintComponent(g2d);
        setBackground( new Color(255,255,255,0) );
        }

    }



