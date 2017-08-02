package test;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class bin {
	@Test
	public void testBin(){
		//变量i是2进制数据！！
		int i=-3;
		//输出2进制
		System.out.println(Integer.toBinaryString(i));
		
		System.out.println(i);
	}
	@Test
	public void test(){
		String str = StringUtils.leftPad("101", 32,'0');
		System.out.println(str);
	}
	@Test
	public void test1(){
		//01111011 11010100 10011111 01011101
		//   7   b    d   4    9   f    a   d
		int i=0xac;
		System.out.println(Integer.toBinaryString(i));
	}
	@Test
	public void test2(){ 
		int i=0x80000000;
		System.out.println(8&-6);
		System.out.println(Integer.toBinaryString(i));
	}
	@Test
	//二进制的运算
	public void test3(){
		//二进制&的算法 拆分的
		/**
		 * 
		 * 
		 * 
		 */
		int n = 0x4977aa55;
		int m = 0x3f;
		int k= n&m;
		System.out.println(Integer.toBinaryString(k));
		//'|' 或运算（逻辑+）合并的
		n=0x2d;
		m=0x80;
		k=n|m;
		System.out.println(Integer.toBinaryString(k));
		//'>>>' 逻辑右移位
		n = 0x227aaabb;
		m=n>>>1;
		k=n>>>2;
		int j= n>>>6;
		System.out.println(Integer.toBinaryString(k));
		System.out.println(Integer.toBinaryString(j));
		
		
	}
	@Test
	//中文字符转码的截取原理
	public void test4(){
		char n='中';
		int m = 0x3f;
		int k= (n&m) | 0x80;
		System.out.println(Integer.toBinaryString(k));
		int b1 = (n>>>12) | 0xe0;
		System.out.println(Integer.toBinaryString(b1));
		//左移的符号
		n=50;
		m=n<<2;
		System.out.println(m);
		
	}
}
