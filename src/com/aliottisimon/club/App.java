package com.aliottisimon.club;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;

public class App {

	MyScanner sc = new MyScanner();
	ServiceClub sclub = new ServiceClub();
	ServiceMembre smembre = new ServiceMembre();

	/**
	 * Lance l'application
	 * 
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
			boolean clubExist = false;

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
				clubExist = isClubExist(nameClub);
				if (clubExist) {
					smembre.writeMembre(sc, nameClub);
				} else {
					System.out.println("Le club n'existe pas. Veuillez d'abord le créer");
				}

				break;

			case "listMembres":
				System.out.println("Veuillez saisir le nom du club duquel vous souhaitez afficher les membres :");
				String nameClub2 = sc.input();
				clubExist = isClubExist(nameClub2);
				if (clubExist) {
					smembre.readMembre(sc, nameClub2);
				} else {
					System.out.println("Le club n'existe pas. Veuillez d'abord le créer");
				}
				
				break;
			case "deleteMembre":
				System.out.println("Veuillez saisir le nom du club dans lequel vous souhaitez supprimer un membre :");
				String nameClub3 = sc.input();
				clubExist = isClubExist(nameClub3);
				if (clubExist) {
					smembre.deleteMembre(sc, nameClub3);
				} else {
					System.out.println("Le club n'existe pas. Veuillez d'abord le créer");
				}
				
				break;
			case "exit":
				again = false;
				System.out.println("Bye bye");
				break;
			}
		} while (again);

	}

	public boolean isClubExist(String name) {
		boolean clubExist = false;
		List<String> listClubs = new LinkedList<>();
		listClubs = listClub();
		
		
		for (String club : listClubs) {
			if (club.equals(name)) {
				clubExist = true;
			} else {
				clubExist = false;
			}
		}
		return clubExist;
	}

	/**
	 * Retourne la liste des clubs pour la vérification
	 */
	public List<String> listClub() {
		List<String> listClubs = new LinkedList<>();
		
		File file = new File("/Users/simonaliotti/club");
		String[] tabClub = file.list();
		
			for (String string : tabClub) {
				String[] nameClub = string.split("(.txt)");
				listClubs.add(nameClub[0]);	
		}
		return listClubs;
	}
	
}
