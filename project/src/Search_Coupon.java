import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Search_Coupon {

    Search_Coupon(){
        List<Coupon> couponlist = new ArrayList<>();
        List<Coupon> result = new ArrayList<>();
        try{
            File file = new File("systemDataFile");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = reader.readLine()) != null){
                if(line.matches("[\\s]*"))
                    continue;
                String[] tokens = line.split(",");
                Coupon nextCoupon = new Coupon(tokens[0],tokens[1],tokens[6],tokens[2],tokens[3],tokens[4],tokens[5]);
                couponlist.add(nextCoupon);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        Collections.sort(couponlist);

        String search_value = JOptionPane.showInputDialog("Please input the product name");
        if (search_value != null) {
            //linear search
            int linear_found = 0, linear_times = 0;
            for (Coupon a : couponlist) {
                linear_times++;
                if (a.getProduct_name().equals(search_value)) {
                    result.add(a);
                    if (linear_found == 0)
                        linear_found = linear_times;
                }
            }
            Purchase_Coupon.removeDuplicate(result);

            //bienary search
            int BST_times = 0;
            BST_times = (int) (Math.log((double) linear_times) / Math.log((double) 2) + 1);
            List product_name_list = new ArrayList();
            for (Coupon a : couponlist) {
                product_name_list.add(a.product_name);
            }
            int index = Collections.binarySearch(product_name_list, search_value);
            int[] arr = new int[linear_times];
            Arrays.setAll(arr, i -> i + 1);
            BST_found = 0;
            binarySearch(arr, 1, arr.length, index);

            //result print
            if (linear_found == 0) {
                System.out.println("No Coupon is found - " + BST_times + " times by BST and " + linear_times + " times by Linear Search.");
                JOptionPane.showMessageDialog(null, "No Coupon is found - " + BST_times + " times by BST and " + linear_times + " times by Linear Search.");
            } else {
                System.out.println("Found in " + BST_found + " times by BST and " + linear_found + " times by Linear Search.");
                JOptionPane.showMessageDialog(null, "Found in " + BST_found + " times by BST and " + linear_found + " times by Linear Search.");
                for (Coupon accc : result)
                    System.out.println(accc.toString());

                //print result list
                JFrame frame = new JFrame("Search Result");
                String columns[] =
                        {"provider", "product", "price", "discount", "expiration", "status", "website"};

                TableModel model = new CouponTableModel(result) {
                    public Class getColumnClass(int column) {
                        Class returnValue;
                        if ((column >= 0) && (column < getColumnCount())) {
                            returnValue = getValueAt(0, column).getClass();
                        } else {
                            returnValue = Object.class;
                        }
                        return returnValue;
                    }
                };
                final JTable table = new JTable(model);
                final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
                table.setRowSorter(sorter);
                JScrollPane pane = new JScrollPane(table);
                frame.add(pane, BorderLayout.CENTER);
                frame.setSize(600, 500);
                frame.setVisible(true);
                CouponInventorySystem.setFrameCenter(frame);
            }
        }



    }

    //binary search method
    int BST_found;
    int binarySearch(int arr[], int l, int r, int x)
    {
        BST_found++;
        if (r>=l)
        {
            int mid = l + (r - l)/2;
            if (arr[mid] == x)
                return mid;

            if (arr[mid] > x)
                return binarySearch(arr, l, mid-1, x);

            return binarySearch(arr, mid+1, r, x);
        }
        return -1;
    }

}
