/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kbs;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Random;

/**
 *
 * @author Bram
 */
public class Scherm extends JFrame implements ActionListener{
    
    private JButton jbConfirm;
    private JButton jbRandom;
    private JLabel jlK1;
    private JLabel jlK2;
    private JLabel jlK3;
    private JLabel jlK4;
    private JLabel jlK5;
    private JLabel jlKA;
    private JSpinner jsK1;
    private JSpinner jsK2;
    private JSpinner jsK3;
    private JSpinner jsK4;
    private JSpinner jsK5;
    private JSpinner jsKA;
    private Samenstelling samenstelling;
    Random rand = new Random();
    SpinnerModel sm1 = new SpinnerNumberModel(0, 0, 9, 1);
    SpinnerModel sm2 = new SpinnerNumberModel(0, 0, 9, 1);
    SpinnerModel sm3 = new SpinnerNumberModel(0, 0, 9, 1);
    SpinnerModel sm4 = new SpinnerNumberModel(0, 0, 9, 1);
    SpinnerModel sm5 = new SpinnerNumberModel(0, 0, 9, 1);
    SpinnerModel smA = new SpinnerNumberModel(0, 0, 9, 1);
    
    public Scherm(Samenstelling samenstelling){
        this.samenstelling = samenstelling;
        
        setTitle("Samenstelling");
	setSize(550, 150);
	setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jlK1 = new JLabel("Kleur 1");
        add(jlK1);
        jsK1 = new JSpinner(sm1);
        add(jsK1);
        jlK2 = new JLabel("Kleur 2");
        add(jlK2);
        jsK2 = new JSpinner(sm2);
        add(jsK2);
        jlK3 = new JLabel("Kleur 3");
        add(jlK3);
        jsK3 = new JSpinner(sm3);
        add(jsK3);
        jlK4 = new JLabel("Kleur 4");
        add(jlK4);
        jsK4 = new JSpinner(sm4);
        add(jsK4);
        jlK5 = new JLabel("Kleur 5");
        add(jlK5);
        jsK5 = new JSpinner(sm5);
        add(jsK5);
        jlKA = new JLabel("Alle kleuren");
        add(jlKA);
        jsKA = new JSpinner(smA);
        add(jsKA);
        jbConfirm = new JButton("Confirm");
        add(jbConfirm);
        jbConfirm.addActionListener(this);
        jbRandom = new JButton("Random");
        add(jbRandom);
        jbRandom.addActionListener(this);
        setVisible(true);
    }

    @Override
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jbConfirm) {
            if((Integer)jsKA.getValue() == 0){
                samenstelling.setK1((Integer)jsK1.getValue());
                samenstelling.setK2((Integer)jsK2.getValue());
                samenstelling.setK3((Integer)jsK3.getValue());
                samenstelling.setK4((Integer)jsK4.getValue());
                samenstelling.setK5((Integer)jsK5.getValue());
              //  if(samenstelling.getTotaal() != 15) {
            //        System.out.println("Totaal is niet gelijk aan 15");
              //  } else {
                    System.out.println(samenstelling);
             //   }
            } else {
                samenstelling.setK1((Integer)jsKA.getValue());
                samenstelling.setK2((Integer)jsKA.getValue());
                samenstelling.setK3((Integer)jsKA.getValue());
                samenstelling.setK4((Integer)jsKA.getValue());
                samenstelling.setK5((Integer)jsKA.getValue());
                System.out.println(samenstelling);
            }
        } else if(e.getSource() == jbRandom) {
            samenstelling.setK1(rand.nextInt(9) + 0);
            samenstelling.setK2(rand.nextInt(9) + 0);
            samenstelling.setK3(rand.nextInt(9) + 0);
            samenstelling.setK4(rand.nextInt(9) + 0);
            samenstelling.setK5(rand.nextInt(9) + 0);
            System.out.println(samenstelling);
        }
    }
}
