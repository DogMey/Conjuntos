/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author kerwi
 */
public class Unión implements conjunto{
	
    @Override
    public int[] operacion(int[] x, int[] y, int[] z, int a, int b, int c) {

        for (int i=0; i<a; i++) {
                z[i]=x[i];
        }
        for (int i=0; i<b; i++) {
                z[a+i]=y[i];
        }

        for(int i=0; i<c; i++) {
                System.out.println(z[i]);
        }

        return z;
    }
}
