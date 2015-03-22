/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ga_swing;

/**
 *
 * @author Orley
 */
public class Coding {
    public static int indivLength = 16;
    
    public static int adjust(double input) {
        return 0;
    }

    public static double deAdjust(double input) {
        return 0.0;
    }

    public static double binDecode(String input) {
        return ((double) Integer.parseInt(input, 2) / 1000) - 10;
    }

    public static int binEncode(String input) {
        return 0;
    }

    public static double evalY(double x) {
        return Math.pow(x, 2) + 2 * (Math.pow(x + 5, 4));
    }

    public static double evalY(double x1, double x2) {
        if (main.functNo == 1) {
            return Math.pow((x1 + 2 * x2 - 7), 2) + Math.pow((2 * x1 + x2 - 5), 2);
        } else if (main.functNo == 2) {
            return 0.26 * (Math.pow(x1, 2) + Math.pow(x2, 2)) - 0.48 * x1 * x2;
        } else if (main.functNo == 3) {
            return 2 * Math.pow(x1, 2) - 1.05 * Math.pow(x1, 4) + Math.pow(x1, 6) / 6 + x1 * x2 + Math.pow(x2, 2);
        } else if (main.functNo == 4) {
            double powerTerm1 = -((x1 - Math.PI) * (x1 - Math.PI));
            double powerTerm2 = -((x2 - Math.PI) * (x2 - Math.PI));
            double power = powerTerm1 + powerTerm2;
            return -Math.cos(x1) * Math.cos(x2) * Math.exp(power);
        } else {
            return 0;
        }
    }
}
