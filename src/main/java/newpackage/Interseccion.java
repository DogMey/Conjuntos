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
public class Interseccion implements conjunto{
    @Override
    public int[] operacion(int[] x, int[] y, int[] z, int a, int b, int c) {

            int h=0;
            for (int i=0; i<a; i++) {
                    for (int j=0; j<b; j++) {
                            if(x[i]==y[j]) {
                                    boolean f=false;
                                    int l=0;
                                    do {
                                            if(z[l]==x[i]) {
                                                    f=true;
                                            }
                                            l++;
                                    }while(l<c);
                                    if(f==false) {
                                            z[h]=x[i];
                                            h++;
                                    }
                            }
                    }
            }
            for(int i=0; i<c; i++) {
                    System.out.println(z[i]);
            }
            return z;
    }
}
