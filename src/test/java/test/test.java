package test;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class test {
	@Test
	public void test1(){
		String str = "123456";
		String mds = DigestUtils.md5Hex(str);
		System.out.println(mds);
		String salt="还在吃屎吗";
		mds = DigestUtils.md5Hex(str+salt);
		System.out.println(mds);
	}
	@Test
	public void test2(){
		System.out.println(new f2().getJ());
	}
}



class f1 {
	private int i=10;
	public void t1(){
		
		System.out.println(i);
		i=i+10;
	}
}

class f2 extends f1{
	private int j=30;
	public void t2(){
		System.out.println(getJ());
		setJ(getJ()+20);
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
}

