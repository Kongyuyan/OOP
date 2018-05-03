/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
import java.util.HashMap;

public class BonusSeller extends Seller {

    
    private HashMap<String, Double> sales = new HashMap(10);

    public BonusSeller(String n) {
        super(n);

    }

    public void sale(String n, double y) {
        super.sale(y);

        sales.put(n, super.getWeightSold());
    }

    public String toString() {
        
        String output = "";
        output += super.toString() + "\n";
        output += "Sales per customer:\n";
        for (String str : sales.keySet()) {
            output += str + ":" + (int) Math.round(sales.get(str)) + "kg" + "\n";
        }
        return output;
    }

    public int calculateBonus() {
        int t = 0;
        for (String str : sales.keySet()) {
            if (sales.get(str) >= 20.0) {
                t++;

            }
        }
        if (t < 5) {
            return 0;
        } else if (t >= 5 && t < 10) {
            return 5;
        }
        return 7;
    }
}
