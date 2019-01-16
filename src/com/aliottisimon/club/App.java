package com.aliottisimon.club;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class App {

	MyScanner sc = new MyScanner();
	ServiceClub sclub = new ServiceClub();
	ServiceMembre smembre = new ServiceMembre();

	public void launchApp() throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("Bienvenue dans l'application club");

		System.out.println("--------------------------------");

		System.out.println("Voici les fonctions dispnibles :");
		System.out.println("Créer un club : ");
		System.out.println("Lire les données d'un club : ");
		System.out.println("Lister les clubs : ");
		System.out.println("Supprimer un club : ");

		System.out.println("Créer un membre : ");
		System.out.println("Lister les membres : ");
		System.out.println("Supprimer un membre : ");

		System.out.println("-----------------------");

		boolean again = true;

		do {

			String command = sc.input();

			switch (command) {
			case "createClub":
				sclub.writeClub(sc);
				break;
			case "readClub":
				sclub.readClub(sc);
				break;
			case "listClubs":
				sclub.listClub();
				break;
			case "deleteClub":
				sclub.deleteClub(sc);
				break;

			case "createMembre":

				smembre.writeMembre(sc);
				break;

			case "listMembres":
				smembre.readMembre(sc);
				break;
			case "deleteMembre":
				smembre.deleteMembre(sc);
				break;
			case "exit":
				again = false;
				break;
			}
		} while (again);

	}
}
