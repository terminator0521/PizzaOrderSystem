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
    static int sleepTime = 20; //delay time for resource management
    
    public static void main(String[] args)
    {
        mainFrame frame = new mainFrame();
        SwingUtilities.invokeLater(() ->
        {
            frame.setSize(300, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        });

        while (true)
        {
            //logic
            info(frame, frame.Size.getSelectedIndex(), (int) frame.jSpinner1.getValue(), frame.jCheckBox1.isSelected());

            
            //prevent wasted resources
            try
            {
                Thread.sleep(sleepTime);
            }
            catch (InterruptedException e)
            {
            }
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
    public static double input(int size, int noToppings, boolean delivery)
    {
        double subtotal = 0;//subtotal to be sent
        switch (size)
        {
            case 0:
                //small
                subtotal += 8;
                break;
            case 1:
                //medium
                subtotal += 10;
                break;
            case 2:
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

    

    public static void info(mainFrame frame, int size, int toppings, boolean del)
    {
        //is delivery factor & is delevery
        double subtotal = input(size, toppings, del);
        double cost = subtotal;
        int delFact;
        boolean discounted = false;
        boolean extraFee = false;

//        //delivery factor
//        if (del)
//        {
//            delFact = 1;
//        }
//        else
//        {
//            delFact = 0;
//        }
//
//        //cost without extras or tax
//        double cost = (subtotal + (delFact * 3d));
        if (cost > 15d) // discount if needed
        {
            cost = cost - (cost * 0.1);
            discounted = true;
        }
        else if (cost < 10d) //add extra fee if needed
        {
            cost += 2;
            extraFee = true;
        }
        

        //discount text
        if (discounted)
        {
            frame.DiscountApplied.setText("Yes");
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

        //grand total math + display
        double grandTotal = (double) Math.round((cost * 1.13) * 100) / 100;
        frame.GrandTotalValue.setText(String.valueOf(grandTotal));
    }
}
