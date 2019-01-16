package com.aliottisimon.club;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class App {

	MyScanner sc = new MyScanner();
	ServiceClub sclub = new ServiceClub();
	ServiceMembre smembre = new ServiceMembre();

	
	/**
	 * Lance l'application
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void launchApp() throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("Bienvenue dans l'application club");

		System.out.println("--------------------------------");

		System.out.println("Voici les fonctions dispnibles :");
		System.out.println("Créer un club : createClub");
		System.out.println("Lire les données d'un club : readClub");
		System.out.println("Lister les clubs : listClubs");
		System.out.println("Supprimer un club : deleteClub");

		System.out.println("Créer un membre : createMembre");
		System.out.println("Lister les membres : listMembres");
		System.out.println("Supprimer un membre : deleteMembre");
		System.out.println("Exit : exit");

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
				System.out.println("Veuillez saisir le nom du club dans lequel vous souhaitez ajouter un membre :");
				String nameClub = sc.input();
				smembre.writeMembre(sc, nameClub);
				break;

			case "listMembres":
				System.out.println("Veuillez saisir le nom du club duquel vous souhaitez afficher les membres :");
				String nameClub2 = sc.input();
				smembre.readMembre(sc, nameClub2);
				break;
			case "deleteMembre":
				System.out.println("Veuillez saisir le nom du club dans lequel vous souhaitez supprimer un membre :");
				String nameClub3 = sc.input();
				smembre.deleteMembre(sc, nameClub3);
				break;
			case "exit":
				again = false;
				System.out.println("Bye bye");
				break;
			}
		} while (again);

	}

	

}
