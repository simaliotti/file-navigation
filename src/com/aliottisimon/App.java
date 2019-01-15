package com.aliottisimon;

import java.io.IOException;

public class App {

	MyScanner sc = new MyScanner();
	Fonctions fx = new Fonctions();

	public void launch() throws IOException {
		System.out.println("Bienvenue dans la console");
		System.out.println("");
		System.out.println("=======================================");
		System.out.println("");
		System.out.println("      Les commandes disponibles sont : ");
		System.out.println("");
		System.out.println("      cd = change directory");
		System.out.println("      cd.. = parent directory");
		System.out.println("      ls = list elements");
		System.out.println("      pwd.. = display current directory");
		System.out.println("      rm.. = remove file or folder");
		System.out.println("      mkdir = create folder");
		System.out.println("      touch = create file");
		System.out.println("      Exit : exit the program");
		System.out.println("      Exemeple : touch file.txt");
		System.out.println("      Exemeple : mkdir file.txt");
		System.out.println("      Exemeple : cd subfolder");
		System.out.println("");
		System.out.println("======================================");
		System.out.println("");
		fx.pwd();

		boolean again = true;

		do {

			String phrase = sc.input();
			String fonction = null;
			String path = null;
			boolean hasSpace = phrase.contains(" ");

			if (hasSpace) {
				String[] tabPhrase = phrase.split(" ");
				fonction = tabPhrase[0];
				path = tabPhrase[1];
			} else {
				fonction = phrase;
			}

			switch (fonction) {
			case "ls":
				fx.ls();
				break;
			case "cd":
				fx.cd(path);
				break;
			case "cd..":
				fx.cdParent();
				break;
			case "pwd":
				fx.pwd();
				break;
			case "rm":
				fx.rm(path);
				break;
			case "mkdir":
				fx.mkdir(path);
				break;
			case "touch":
				fx.touch(path);
				break;
			case "exit":
				again = false;
				break;
			}

		} while (again);

		System.out.println("Bye");

	}

}
