import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@SuppressWarnings("serial")
public class Purchase_Coupon extends JFrame implements ActionListener
{
    JFileChooser fc = new JFileChooser();
    JButton open_file,manually_input;
    public Purchase_Coupon()
    {
        this.setTitle("Purchase Coupon");
        open_file = new JButton("Input using data file");
        manually_input = new JButton("Input           manually");
        open_file.addActionListener(this);
        manually_input.addActionListener(this);
        Dimension d = new Dimension(150,40);
        open_file.setPreferredSize(d);
        manually_input.setPreferredSize(d);
        Box vertical2 = Box.createVerticalBox();
        vertical2.setPreferredSize(new Dimension(50,30));
        vertical2.add(Box.createVerticalStrut(110));
        vertical2.add(open_file);
        vertical2.add(Box.createVerticalStrut(60));
        vertical2.add(manually_input);
        vertical2.add(Box.createHorizontalStrut(90));

        Container container = this.getContentPane();
        container.add(vertical2);
        this.setVisible(true);
        this.setSize(300,450);
        CouponInventorySystem.setFrameCenter(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        JButton button = (JButton)e.getSource();
        if(button == open_file)
        {
            int select = fc.showOpenDialog(this);
            if(select == JFileChooser.APPROVE_OPTION)
            {
                File file = fc.getSelectedFile();
                //read input file in couponlist
                try{
                    List<Coupon> listCoupons1 = new ArrayList<>();
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line = null;
                    while((line = reader.readLine()) != null){
                        if(line.matches("[\\s]*"))
                            continue;
                        String[] tokens = line.split(",");

                        Coupon nextCoupon = new Coupon(tokens[0],tokens[1],tokens[6],tokens[2],tokens[3],tokens[4],tokens[5]);
                        listCoupons1.add(nextCoupon);
                    }
                    removeDuplicate(listCoupons1);

                    //write new data from couponlist to data_file
                    String[] output = new String[listCoupons1.size()];
                    for(int i = 0; i < listCoupons1.size(); i++){
                        try{
                            output[i] = listCoupons1.get(i).toString();
                        }
                        catch (NullPointerException eee){
                            eee.printStackTrace();
                        }
                    }

                    try{
                        FileWriter writer = new FileWriter("systemDataFile",true);
                        for(String str: output){
                            writer.write(str);
                            writer.write(System.getProperty("line.separator"));
                        }
                        writer.close();
                        JOptionPane.showMessageDialog(null,"input successful");
                    }
                    catch (Exception a){
                        a.printStackTrace();
                    }
                }
                catch(Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Error!");
                }
            }
            else
                System.out.println("Input action was canceled");
        }

        if(button == manually_input)
        {
            new Purchase();
        }
    }

    public static void removeDuplicate(List<Coupon> arlList)
    {
        HashSet h = new HashSet(arlList);
        arlList.clear();
        arlList.addAll(h);
    }


}
