/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TextField;
import javax.swing.JTextField;

/**
 *
 * @author choaib
 */
public class Customjtextfield extends JTextField {

    
    public Customjtextfield(){
    super();
}
        public Customjtextfield(String text) {
            super(text);
            init();
        }

        public Customjtextfield(int columns) {
            super(columns);
            init();
        }

        public Customjtextfield(String text, int columns) {
            super(text, columns);
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

