/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kbs;

/**
 *
 * @author Bram
 */
public class Samenstelling {
    private int k1;
    private int k2;
    private int k3;
    private int k4;
    private int k5;
    private int totaal = k1 + k2 + k3 + k4 + k5;

    public Samenstelling(int k){
        this.k1 = k;
        this.k2 = k;
        this.k3 = k;
        this.k4 = k;
        this.k5 = k;
    }
    
    public Samenstelling(int k1, int k2, int k3, int k4, int k5) {
        this.k1 = k1;
        this.k2 = k2;
        this.k3 = k3;
        this.k4 = k4;
        this.k5 = k5;
    }

    public int getK1() {
        return k1;
    }

    public int getK2() {
        return k2;
    }

    public int getK3() {
        return k3;
    }

    public int getK4() {
        return k4;
    }

    public int getK5() {
        return k5;
    }
    
    public int getTotaal() {
        return totaal;
    }

    public void setK1(int k1) {
        this.k1 = k1;
    }

    public void setK2(int k2) {
        this.k2 = k2;
    }

    public void setK3(int k3) {
        this.k3 = k3;
    }

    public void setK4(int k4) {
        this.k4 = k4;
    }

    public void setK5(int k5) {
        this.k5 = k5;
    }

    @Override
    public String toString() {
        return "Samenstelling{" + "k1=" + k1 + ", k2=" + k2 + ", k3=" + k3 + ", k4=" + k4 + ", k5=" + k5 + '}';
    }
    
    
}
