/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rabbit;

import java.util.Arrays;
import java.util.Collections;

public class Rabbit {

    private Integer[][] r;
    private int n;

    public Rabbit(int n) {
        this.n = n;
        r = new Integer[n][];
    }

    public void init() {
        if (n >= 2) {
            r[0] = new Integer[]{1};
            r[1] = new Integer[]{1, 0};
            for (int i = 2; i < n; i++) {
                r[i] = new Integer[r[i - 2].length + r[i - 1].length];
                for (int x = 0; x < r[i - 2].length; x++) {
                    r[i][x] = r[i - 2][x];
                }
                for (int y = 0; y < r[i - 1].length; y++) {
                    r[i][y + r[i - 2].length] = r[i - 1][y];
                }

            }
        }
 
    }
    public String toString(){
        String sequence = "";
        for(Integer[] i :r){
            sequence += Arrays.toString(i) +"/n" ;
        }
        return sequence;
    }
    public int subsequenceIndex(Integer[] t){
     return  Collections.indexOfSubList(Arrays.asList(r[r.length-1]), Arrays.asList(t));
        
    }

 	public static void main(String[] args) {
            
              Integer[] c = new Integer[]{1,1,0};
              Integer[] d = new Integer[]{1,1,1};
		int a = Integer.parseInt(args[0]);
                if(a>=2){
                Rabbit R = new Rabbit(a);
                R.init();
                System.out.print(R.toString());
                System.out.println(R.subsequenceIndex(c));
                System.out.println(R.subsequenceIndex(d));
                }
    }
       
}
