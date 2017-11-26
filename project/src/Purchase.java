import java.lang.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Purchase {
    ArrayList<Coupon> couponlist = new ArrayList<Coupon>();


    public Purchase(){
        Coupon coupon = new Coupon();
        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();
        JTextField field3 = new JTextField();
        JTextField field4 = new JTextField();
        JTextField field5 = new JTextField();
        JTextField field6 = new JTextField();
        JComboBox<String> field7 = new JComboBox<String>();
        field7.addItem("Unused");
        field7.addItem("Redeemed");
        Object[] message = {
                "Name of Coupon Provider:", field1,
                "Product Name:", field2,
                "Price of Product:", field3,
                "Discount rate (range between 5% to 80%):", field4,
                "Expiration Period (range between 0 to 365):", field5,
                "Coupon site:", field6,
                "Status:", field7,
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Purchase a new Coupon", JOptionPane.OK_CANCEL_OPTION);

        yes:
        if (option == JOptionPane.OK_OPTION) {
            String value1 = field1.getText();
            String value2 = field2.getText();
            String value3 = field3.getText();
            String value4 = field4.getText();
            String value5 = field5.getText();
            String value6 = field6.getText();
            String value7 = (String) field7.getSelectedItem();
            coupon.coupon_provider = value1;
            coupon.product_name = value2;
            coupon.product_price = value3;
            coupon.discount = value4;
            coupon.expiration = value5;
            coupon.coupon_site = value6;
            coupon.status = value7;

            //check the input value
            if(coupon.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Input Nothing");
                break yes;
            }
            if (value1.matches("[\\s]*")|| value1 == null) {
                value1 = " ";
                coupon.coupon_site = value6;
            }
            else if (!value1.matches("^.{1,20}$")){
                JOptionPane.showMessageDialog(null, "Input error!\nPlease input a valid coupon provider.\nMax field: 20 bytes.");
                break yes;
            }
            if (!value2.matches("^.{1,20}$")|| value1 == null){
                JOptionPane.showMessageDialog(null, "Input error!\nPlease input a valid product name.\nMax field: 20 characters.");
                break yes;
            }
            if (!value3.matches("^\\d+(\\.\\d+)?$")|| value1 == null){
                JOptionPane.showMessageDialog(null, "Input error!\nProduce price should be a valid number.\nPlease input a valid number.");
                break yes;
            }
            if (!value4.matches("^\\d{1,2}$")||
                    Integer.parseInt(value4)<5 ||
                    Integer.parseInt(value4)>80){
                JOptionPane.showMessageDialog(null, "Input error!\nDiscount rate shall between 5% and 80%.\nPlease input a valid number.");
                break yes;
            }
            if (!value5.matches("^\\d{1,3}$")||
                    Integer.parseInt(value5)<0 ||
                    Integer.parseInt(value5)>365){
                JOptionPane.showMessageDialog(null, "Input error!\nExpiration period should between 0 and 365 days.\nPlease input a valid number.");
                break yes;
            }
            if (value6.matches("[\\s]*")|| value1 == null){
                value6 = " ";
                coupon.coupon_site = value6;
            }



            //add new coupon in data collection
            this.readCouponFile();
            this.couponlist.add(coupon);
            Purchase_Coupon.removeDuplicate(couponlist);
            this.writeFile();
            int nextInput = JOptionPane.showConfirmDialog(null, "Input successful!\nDo you want input more data?", "Message", JOptionPane.OK_CANCEL_OPTION);
            if (nextInput == JOptionPane.OK_OPTION) {
                new Purchase();
            }
        }
    }


    void readCouponFile(){
        try{
            File file = new File("systemDataFile");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = reader.readLine()) != null){
                if(line.matches("[\\s]*"))
                    continue;
                addCoupon(line);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    void addCoupon(String lineToParse){
        String[] tokens = lineToParse.split(",");
        Coupon nextCoupon = new Coupon(tokens[0],tokens[1],tokens[6],tokens[2],tokens[3],tokens[4],tokens[5]);
        couponlist.add(nextCoupon);
    }

    void writeFile(){
        String[] output = new String[couponlist.size()];
        for(int i = 0; i < couponlist.size(); i++){
            try{
                    output[i] = couponlist.get(i).toString();
            }
            catch (NullPointerException e){
                e.printStackTrace();
            }
        }

        try{
            File file = new File("systemDataFile");
            FileOutputStream fos = new FileOutputStream(file);

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));

            for(String str: output){
                writer.write(str);
                writer.newLine();
            }
            writer.close();
        }
        catch (Exception a){
            a.printStackTrace();
        }
    }
}
