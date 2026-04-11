/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;

/**
 *
 * @author Ricky Xu
 */
public class Order
{

    String sizeName;
    public int toppings;
    public String forDelivery;
    public String name;
    public static int numOfInstances = 0;

    public Order(int size, int toppings, boolean forDelivery, String name)
    {
        //add instances
        numOfInstances++;

        //size check
        switch (size)
        {
            case 0:
                sizeName = "Small";
                break;
            case 1:
                sizeName = "Medium";
                break;
            case 2:
                sizeName = "Large";
                break;

        }
        
        //for delivery
        if (forDelivery)
        {
            this.forDelivery = "Yes";
        }
        else
        {
            this.forDelivery = "No";
        }
        
        //assigning name
        this.name = name;
    }
}
