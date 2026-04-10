/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 349913095
 */
import javax.swing.*;

public class main
{

    public static void main(String[] args)
    {
        mainFrame frame = new mainFrame();
        SwingUtilities.invokeLater(() ->
        {
            frame.setSize(300, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        });

//        frame.jLabel5.setText("hi");
        while (true)
        {
            info(frame, (String) frame.Size.getSelectedItem(), (int) frame.jSpinner1.getValue(), frame.jCheckBox1.isSelected());

        }
    }

    /**
     * Accepts user's input for the size, number of toppings, and if there is
     * delivery. Calculates the subtotal, as well as printing out the receipt
     * before tax and discount.
     *
     * @param size
     * @param noToppings
     * @param delivery
     * @return subtotal
     */
    public static double input(String size, int noToppings, boolean delivery)
    {
        double subtotal = 0;//subtotal to be sent
        switch (size)
        {
            case "Small":
                //small
                subtotal += 8;
                break;
            case "Medium":
                //medium
                subtotal += 10;
                break;
            case "Large":
                //large
                subtotal += 12;
                break;
            default:
                break;
        }
        subtotal += 1.5 * noToppings;
        if (delivery)
        {
            subtotal += 3;
        }
        return subtotal;
    }

    /**
     * Calculates the total cost, discount, and tax added and prints them out in
     * order
     *
     * @param cost subtotal without tax or discount applied
     */
    public static void totals(double cost)
    {

        if (cost >= 15d)
        {
            double total = cost - (cost * 0.1);
        }
        else
        {
            double total = cost;
        }

        //first result
        double grandTotal = cost * 1.13;
        double tax = grandTotal - cost;

    }

    public static void info(mainFrame frame, String size, int toppings, boolean del)
    {
        //is delivery factor & is delevery

        double subtotal = input(size, toppings, del);
        int delFact;
        boolean discounted = false;
        boolean extraFee = false;

        //delivery factor
        if (del)
        {
            delFact = 1;
        }
        else
        {
            delFact = 0;
        }

        //cost without extras
        double cost = (subtotal + (delFact * 3d));
        
        

        if (cost > 15d)
        {
            discounted = true;
        }
        else if (cost < 10d)
        {
            extraFee = true;
        }

        if (cost < 15d) // discount if needed
        {
            cost = cost - (cost * 0.1);
            discounted = true;
        }
        else if (cost < 10d) //add extra fee if needed
        {
            cost += 2;
            extraFee = true;
        }

        //grand total math + display
        double grandTotal = Math.round((cost * 1.13) * 100) * 0.01;
        frame.GrandTotalValue.setText(String.valueOf(grandTotal));

        //discount text
        if (discounted)
        {
            frame.DiscountApplied.setText("Yes" );
        }
        else
        {
            frame.DiscountApplied.setText("No");
        }

        //extra fee text
        if (extraFee)
        {
            frame.ExtraFee.setText("Yes");
        }
        else
        {
            frame.ExtraFee.setText("No");
        }

    }
}
