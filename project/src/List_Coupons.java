import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class List_Coupons
{

    public List_Coupons() {
        JFrame frame = new JFrame("List Coupons");
        String columns[] =
                { "provider", "product", "price","discount","expiration","status","website" };
        List<Coupon> listCoupons = createListCoupons();
        Purchase_Coupon.removeDuplicate(listCoupons);
        Collections.sort(listCoupons);

        TableModel model = new CouponTableModel(listCoupons)
        {
            public Class getColumnClass(int column)
            {
                Class returnValue;
                if ((column >= 0) && (column < getColumnCount()))
                {
                    returnValue = getValueAt(0, column).getClass();
                }
                else
                {
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
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Value: ");
        panel.add(label, BorderLayout.WEST);
        final JTextField filterText = new JTextField("");
        panel.add(filterText, BorderLayout.CENTER);
        JButton button = new JButton("Filter");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String text = filterText.getText();
                if (text.length() == 0)
                {
                    sorter.setRowFilter(null);
                }
                else
                {
                    sorter.setRowFilter(RowFilter.regexFilter(text));
                }
            }
        });
        panel.add(button, BorderLayout.EAST);
        frame.add(panel, BorderLayout.NORTH);
        frame.setSize(600, 500);
        frame.setVisible(true);
        CouponInventorySystem.setFrameCenter(frame);
    }

    public static List<Coupon> createListCoupons() {
        List<Coupon> listCoupons = new ArrayList<>();

        //  add data into collection from systemDataFile.
        try{
            File file = new File("systemDataFile");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = reader.readLine()) != null){
                if(line.matches("[\\s]*"))
                    continue;
                String[] tokens = line.split(",");
                Coupon nextCoupon = new Coupon(tokens[0],tokens[1],tokens[6],tokens[2],tokens[3],tokens[4],tokens[5]);
                listCoupons.add(nextCoupon);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return listCoupons;
    }


}
