package com.aliottisimon;

import java.util.Scanner;

public class MyScanner {

	Scanner sc;

	public MyScanner() {
		this.sc = new Scanner(System.in);
	}

	public String input() {
		return sc.nextLine();

	}
	
	
}
