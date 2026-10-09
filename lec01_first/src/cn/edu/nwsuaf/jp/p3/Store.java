package cn.edu.nwsuaf.jp.p3;

import javax.swing.JOptionPane;

import cn.edu.nwsuaf.jp.p3.data.*;

public class Store {
	public static void main(String[] args){
		Mobile mobile1 = new Mobile("huawei P30",3366.0f,"huawei");
		Mobile mobile2 = new Mobile("huawei mate30",3200.0f,"huawei");
		Mobile mobile3 = new Mobile("huawei novs5s",3800.0f,"huawei");
		mobile1.sell(2);
		mobile2.sell(2);
		mobile3.sell(2);
		float a = mobile1.getSales() + mobile2.getSales() + mobile3.getSales();
		int b = (int)a;
		JOptionPane.showMessageDialog(null,"There are\n\n"+mobile1.toString()+"\n"+mobile2.toString()+"\n"+mobile3.toString()+"\n\n"+"There are 3 items.The sales is"+a);
	}
}
