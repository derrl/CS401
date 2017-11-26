import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CouponTableModel extends AbstractTableModel {
    private static final int COLUMN_coupon_provider    = 0;
    private static final int COLUMN_PRODUCT     = 1;
    private static final int COLUMN_PRICE     = 2;
    private static final int COLUMN_DISCOUNT = 3;
    private static final int COLUMN_EXPIRATION = 4;
    private static final int COLUMN_STATUS = 5;
    private static final int COLUMN_WEBSITE = 7;
    private static final int COLUMN_discount_price = 6;

    private String[] columnNames = { "provider", "product", "price","discount","expiration","status","final price","website" };
    private List<Coupon> listCoupons;

    public CouponTableModel(List<Coupon> listCoupons) {
        this.listCoupons = listCoupons;

        int indexCount = 1;
        for (Coupon coupon : listCoupons) {
            indexCount++;
        }
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return listCoupons.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (listCoupons.isEmpty()) {
            return Object.class;
        }
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Coupon coupon = listCoupons.get(rowIndex);
        Object returnValue = null;

        switch (columnIndex) {
            case COLUMN_discount_price:
                //if the price is not a valid number set it null.
                if (!coupon.getProduct_price().matches("^[+-]?([0-9]*\\.?[0-9]+|[0-9]+\\.?[0-9]*)([eE][+-]?[0-9]+)?$"))
                    returnValue = "null";
                else
                    returnValue = "$"+Float.toString(Float.parseFloat(coupon.product_price) * (1 - Float.parseFloat(coupon.discount) / 100));
                break;
            case COLUMN_coupon_provider:
                returnValue = coupon.getCoupon_provider();
                break;
            case COLUMN_PRODUCT:
                returnValue = coupon.getProduct_name();
                break;
            case COLUMN_PRICE:
                //if the price is not a valid number set it null.
                if (!coupon.getProduct_price().matches("^[+-]?([0-9]*\\.?[0-9]+|[0-9]+\\.?[0-9]*)([eE][+-]?[0-9]+)?$") || coupon.getProduct_price().equals(null))
                    returnValue = coupon.getProduct_price();
                else
                    returnValue = "$"+coupon.getProduct_price();
                break;
            case COLUMN_DISCOUNT:
                //if the discount rate is not a valid number set it null.
                if (!coupon.getDiscount().matches("^[0-9]*$") || coupon.getDiscount().equals(null))
                    returnValue = coupon.getDiscount();
                else
                    returnValue = coupon.getDiscount() + "%";
                break;
            case COLUMN_EXPIRATION:
                returnValue = coupon.getExpiration();
                break;
            case COLUMN_STATUS:
                returnValue = coupon.getStatus();
                break;
            case COLUMN_WEBSITE:
                returnValue = coupon.getCoupon_site();
                break;
            default:
                throw new IllegalArgumentException("Invalid column index");
        }

        return returnValue;
    }

}
