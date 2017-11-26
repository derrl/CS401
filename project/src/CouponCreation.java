import java.io.*;
import java.util.*;

public class CouponCreation {

	public static void main(String[] args) {
		CouponCreation cc = new CouponCreation();
		ArrayList<Coupon> couponList = new ArrayList<Coupon>();
		for (int i = 0; i < 30000; i++) {
			couponList.add(cc.newCoupon());
		}
		String fileName = "list.txt";
		try {
		    cc.writeFile(fileName, couponList);
		}
		catch (IOException e) {
			System.out.println("Wrong Insertion!");
		}
	}

	public Coupon newCoupon() {
		String str1 = RandomString(5);
		String str2 = RandomString(8);
		String str3 = "www." + str1 + ".com";
		String[] status = new String[2];
		status[0] = "Redeemed";
		status[1] = "Unused";
		String str7 = null;
		if (Math.random() < 0.5) {
		       	str7 = status[0];
		}
		else {
			str7 = status[1];
		}
		Random rd = new Random();
		String str4 = (float) rd.nextDouble() * 1000 + "";
		String str5 = (int) rd.nextInt(80) + 5 + "";
		String str6 = (int) rd.nextInt(365) + "";
		Coupon newCoupon = new Coupon(str1, str2, str3, str4, str5, str6, str7);
		return newCoupon;
	}

	public String RandomString (int length) {
		String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < length) {
			int index = (int) rnd.nextInt(26);
			salt.append(CHARS.charAt(index));
		}
		String rndString = salt.toString();
		return rndString;
	}

	public void writeFile(String fileName, ArrayList x ) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		for (int i = 0; i < x.size(); i++) {
			writer.write(x.get(i).toString());
			writer.newLine();
		}
		writer.flush();
		writer.close();
	}

}
