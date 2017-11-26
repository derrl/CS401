public class Coupon implements Comparable<Coupon> {
    String coupon_provider;
    String product_name;
    String coupon_site;
    String product_price;
    String discount;
    String expiration;
    String status;

    public int compareTo(Coupon s){
        return this.product_name.compareTo(s.getProduct_name());
    }

    Coupon(){
        coupon_provider = null;
        product_name = null;
        coupon_site = null;
        product_price = null;
        discount = null;
        expiration = null;
        status = null;
    }

    Coupon(String coupon_provider, String product_name, String coupon_site, String product_price, String discount, String expiration, String status)
    {
        this.coupon_provider = coupon_provider;
        this.product_name = product_name;
        this.coupon_site = coupon_site;
        this.product_price = product_price;
        this.discount = discount;
        this.expiration = expiration;
        this.status = status;
    }

    void setCoupon_provider(String coupon_provider){
        this.coupon_provider = coupon_provider;
    }

    void setProduct_name(String product_name){
        this.product_name = product_name;
    }

    void setCoupon_site(String coupon_site){
        this.coupon_site = coupon_site;
    }

    void setProduct_price(String product_price){
        this.product_price = product_price;
    }

    void setDiscount(String discount){
        this.discount = discount;
    }

    void setExpiration(String expiration){
        this.expiration = expiration;
    }

    void setStatus(String status){
        this.status = status;
    }

    String getCoupon_provider(){
        return coupon_provider;
    }

    String getProduct_name(){
        return product_name;
    }

    String getCoupon_site(){
        return coupon_site;
    }

    String getProduct_price(){
        return product_price;
    }

    String getDiscount(){
        return discount;
    }

    String getExpiration(){
        return expiration;
    }

    String getStatus(){
        return status;
    }
    boolean isEmpty(){
        boolean a;
        if( coupon_provider.equals(null) &&
            product_name.equals(null) &&
            product_price.equals(null) &&
            discount.equals(null) &&
            expiration.equals(null) &&
            coupon_site.equals(null))
            a=true;
        else {
            int count1 = 0;
            for (int i = 0; i <= 5; i++)
                if (this.toArray()[i].matches("[\\s]*"))
                    count1++;
            if (count1 == 5)
                a = true;
            else
                a=false;
        }
        return a;
    }
    public String toString(){
        return(coupon_provider+","+product_name+","+product_price+","
                +discount+","+expiration+","+status+","+coupon_site);
    }

    String[] toArray(){
        String[] a = new String[7];
        a[0] = coupon_provider;
        a[1] = product_name;
        a[2] = product_price;
        a[3] = discount;
        a[4] = expiration;
        a[5] = status;
        a[6] = coupon_site;
        return a;
    }

    @Override
    //rewrite the equals method for remove duplicate coupon.
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coupon coupon = (Coupon) o;

        if (coupon_provider != null ? !coupon_provider.equals(coupon.coupon_provider) : coupon.coupon_provider != null)
            return false;
        if (!product_name.equals(coupon.product_name)) return false;
        if (coupon_site != null ? !coupon_site.equals(coupon.coupon_site) : coupon.coupon_site != null) return false;
        if (!product_price.equals(coupon.product_price)) return false;
        if (!discount.equals(coupon.discount)) return false;
        if (expiration != null ? !expiration.equals(coupon.expiration) : coupon.expiration != null) return false;
        return status != null ? status.equals(coupon.status) : coupon.status == null;
    }

    @Override
    //rewrite the hashCode method for remove duplicate coupon.
    public int hashCode() {
        int result = coupon_provider != null ? coupon_provider.hashCode() : 0;
        result = 31 * result + product_name.hashCode();
        result = 31 * result + (coupon_site != null ? coupon_site.hashCode() : 0);
        result = 31 * result + product_price.hashCode();
        result = 31 * result + discount.hashCode();
        result = 31 * result + (expiration != null ? expiration.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
