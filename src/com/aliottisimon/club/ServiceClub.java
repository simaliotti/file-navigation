package com.aliottisimon.club;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Classe de services permettant de gérer les clubs
 * @author simonaliotti
 *
 */
public class ServiceClub {

	

	/**
	 * Créé un club
	 * @param sc
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void writeClub(MyScanner sc) throws FileNotFoundException, IOException, ClassNotFoundException {

		Club club = createClub(sc);
		club.setIdMembres("Membres-"+club.getName());
		
		File fileMembres = new File("/Users/simonaliotti/membres/"+club.getIdMembres()+".txt");
		
		File file = new File("/Users/simonaliotti/club/"+club.getName()+".txt");

		try (FileOutputStream fop = new FileOutputStream(file); ObjectOutputStream oop = new ObjectOutputStream(fop)) {

			if (!fileMembres.exists()) {
				fileMembres.createNewFile();
			}

			if (!file.exists()) {
				file.createNewFile();
			}

			oop.writeObject(club);
			System.out.println("Club enregistré avec succès");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Affiche les informations d'un club
	 * @param sc
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void readClub(MyScanner sc) throws FileNotFoundException, IOException, ClassNotFoundException {
		System.out.println("Veuillez saisir le nom du club à afficher");
		String nomClub = sc.input();
		File file = new File("/Users/simonaliotti/club/"+nomClub+".txt");

		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {

			Club club = (Club) ois.readObject();

			System.out.println("Nom du club : "+club.getName());
			System.out.println("Adresse du club : "+club.getAdress());
				

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Créé un objet club
	 * @param sc
	 * @return
	 */
	public static Club createClub(MyScanner sc) {
		Club club = new Club();
		System.out.println("Veuillez saisir le nom du club à créer :");
		club.setName(sc.input());
		System.out.println("Veuillez saisir l'adresse du club à créer :");
		club.setAdress(sc.input());
		return club;
	}
	
	/**
	 * Affiche la liste des clubs
	 */
	public void listClub() {
		File file = new File("/Users/simonaliotti/club");
		System.out.println("Liste des clubs enregistrés :");
		String[] tabClub = file.list();
		if(tabClub.length==0) {
			System.out.println("La liste est vide, pas de clubs enregistrés");
		} else {
			for (String string : tabClub) {
				String[] nameClub = string.split("(.txt)");
				System.out.println(nameClub[0]);
		}
		
		}
	}

	/**
	 * Supprimer un club. Supprime le fichier membres lié
	 * @param sc
	 */
	public void deleteClub(MyScanner sc) {
		System.out.println("Veuillez saisir le nom du club à supprimer (supprime également la liste des membres affectés): ");
		String nomClub = sc.input();
		File fileClub = new File("/Users/simonaliotti/club/"+nomClub+".txt");
		fileClub.delete();
		File fileMembre = new File("/Users/simonaliotti/membres/Membres-"+nomClub+".txt");
		fileMembre.delete();
		System.out.println("Club supprimé avec succès");
	}
}
