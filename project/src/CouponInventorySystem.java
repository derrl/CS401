import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CouponInventorySystem extends JFrame implements ActionListener {
    JButton purchase,search,list_all;
    public CouponInventorySystem(){
        this.setLayout(null);
        purchase = new JButton("Purchase Coupon");
        search = new JButton(  "Search     Coupon");
        list_all = new JButton("List   All   Coupons");
        Dimension d = new Dimension(150,40);
        purchase.setPreferredSize(d);
        search.setPreferredSize(d);
        list_all.setPreferredSize(d);
        purchase.addActionListener(this);
        search.addActionListener(this);
        list_all.addActionListener(this);
        Box vertical1 = Box.createVerticalBox();
        vertical1.setPreferredSize(new Dimension(250,290));
        vertical1.add(Box.createHorizontalStrut(90));
        vertical1.add(purchase);
        vertical1.add(Box.createVerticalStrut(40));
        vertical1.add(search);
        vertical1.add(Box.createVerticalStrut(40));
        vertical1.add(list_all);

        Container c = this.getContentPane();
        c.add(vertical1);
        c.setLayout(new FlowLayout());
        this.setTitle("Coupon Inventory System");
        setSize(300,450);
        setVisible(true);
    }

    public static void main(String args[]){
        CouponInventorySystem cis=new CouponInventorySystem();
        cis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cis.setLocation(800,500);
        setFrameCenter(cis);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        if(button == purchase)
        {
            new Purchase_Coupon();
        }
        if(button == search){
            new Search_Coupon();
        }
        if(button == list_all){
            new List_Coupons();
        }
    }

    //set the window in the center of screen in start.
    public static void setFrameCenter(JFrame jf){
        Toolkit tk = Toolkit.getDefaultToolkit();

        Dimension d = tk.getScreenSize();
        double screenWidth = d.getWidth();
        double screenHeight = d.getHeight();

        int frameWitdth = jf.getWidth();
        int frameHeight = jf.getHeight();

        int width = (int) (screenWidth - frameWitdth) / 2;
        int height = (int) (screenHeight - frameHeight) / 2;
        jf.setLocation(width, height);
    }
}
