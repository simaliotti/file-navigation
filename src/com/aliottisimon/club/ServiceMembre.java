package com.aliottisimon.club;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe de services permettant de gerer les membres
 * @author simonaliotti
 *
 */
public class ServiceMembre {

	
	/**
	 * Créé un membre
	 * @param sc
	 * @param nameClub
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void writeMembre(MyScanner sc, String nameClub)
			throws FileNotFoundException, IOException, ClassNotFoundException {

		// Récupères les données du fichiers
		List<Membre> listMembres = new LinkedList();
		
		File file = new File("/Users/simonaliotti/membres/Membres-"+nameClub+ ".txt");

		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {

			Membre membre = null;
			while ((membre = (Membre) ois.readObject()) != null) {
				listMembres.add(membre);
			}
		} catch (IOException e) {
			// e.printStackTrace();
		}

		// Ecrit dans le fichier
		Membre membre = createMember(sc);

		try (FileOutputStream fop = new FileOutputStream(file); ObjectOutputStream oop = new ObjectOutputStream(fop)) {

			if (!file.exists()) {
				file.createNewFile();
			}
			if (listMembres.size() == 0) {
				oop.writeObject(membre);
			} else {
				oop.writeObject(membre);
				for (Membre membreDejaPresentDansFichier : listMembres) {
					oop.writeObject(membreDejaPresentDansFichier);
				}
			}
			System.out.println("Membre créé avec succès");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Affiche la liste des membres
	 * @param sc
	 * @param nomClub
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void readMembre(MyScanner sc, String nomClub) throws FileNotFoundException, IOException, ClassNotFoundException {

		List<Membre> listMembres = new LinkedList();
		
		File file = new File("/Users/simonaliotti/membres/Membres-" + nomClub + ".txt");
		

		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {

			Membre membre = null;
			while ((membre = (Membre) ois.readObject()) != null) {
				System.out.println(membre);

			}
		} catch (IOException e) {
			// e.printStackTrace();
		}

	}

	/**
	 * Méthode qui créé un objet membre
	 * @param sc
	 * @return
	 */
	public static Membre createMember(MyScanner sc) {
		Membre membre = new Membre();
		System.out.println("Veuillez saisir l'age du membre :");
		membre.setAge(Integer.parseInt(sc.input()));
		System.out.println("Veuillez saisir le prénom du membre :");
		membre.setFirstname(sc.input());
		System.out.println("Veuillez saisir le nom du membre :");
		membre.setName(sc.input());
		System.out.println("Veuillez saisir le type de licence du membre:");
		membre.setLicence(sc.input());

		return membre;
	}

	/**
	 * Supprimer un membre
	 * @param sc
	 * @param nameClub
	 * @throws ClassNotFoundException
	 */
	public void deleteMembre(MyScanner sc, String nameClub) throws ClassNotFoundException {

		
		// Récupères les données du fichiers
		List<Membre> listMembres = new LinkedList();
		
		File file = new File("/Users/simonaliotti/membres/Membres-" + nameClub + ".txt");

		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {

			Membre membre = null;
			while ((membre = (Membre) ois.readObject()) != null) {
				listMembres.add(membre);
			}
		} catch (IOException e) {
			// e.printStackTrace();
		}

		// Ecrit dans le fichier
		System.out.println("Veuillez saisir le nom du membre à supprimer");
		String nameToDelete = sc.input();
		try (FileOutputStream fop = new FileOutputStream(file); ObjectOutputStream oop = new ObjectOutputStream(fop)) {

			if (!file.exists()) {
				file.createNewFile();
			}
			
				for (Membre membreDejaPresentDansFichier : listMembres) {
					if(!(membreDejaPresentDansFichier.getName().equals(nameToDelete))) {
						oop.writeObject(membreDejaPresentDansFichier);
					} else if (membreDejaPresentDansFichier.getName().equals(nameToDelete)) {
						deleteFileMembre(nameToDelete);
					}
				}
			System.out.println("Membre supprimé avec succès");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Supprime un membre du fichier
	 * @param nomClub
	 */
	public void deleteFileMembre(String nomClub) {
		File fileMembre = new File("/Users/simonaliotti/membres/Membres-"+nomClub+".txt");
		fileMembre.delete();
		
	}
	
}
