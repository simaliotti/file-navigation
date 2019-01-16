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

public class ServiceMembre {

	public static void writeMembre(MyScanner sc, Club club)
			throws FileNotFoundException, IOException, ClassNotFoundException {

		// Récupères les données du fichiers
		List<Membre> listMembres = new LinkedList();
		File file = new File("/Users/simonaliotti/membres/" + club.getIdMembres() + ".txt");

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

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void readMembre(MyScanner sc) throws FileNotFoundException, IOException, ClassNotFoundException {

		List<Membre> listMembres = new LinkedList();
		System.out.println("Veuillez saisir le nom du club dont vous souhaitez afficher les membres :");
		String nomClub = sc.input();
		File file = new File("/Users/simonaliotti/membres/Membres-" + nomClub + ".txt");
		System.out.println(file.getAbsolutePath());

		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {

			Membre membre = null;
			while ((membre = (Membre) ois.readObject()) != null) {
				System.out.println(membre);

			}
		} catch (IOException e) {
			// e.printStackTrace();
		}

	}

	public static Membre createMember(MyScanner sc) {
		Membre membre = new Membre();
		membre.setAge(Integer.parseInt(sc.input()));
		membre.setFirstname(sc.input());
		membre.setName(sc.input());
		membre.setLicence(sc.input());

		return membre;
	}

	public void deleteMembre(MyScanner sc, Club club) throws ClassNotFoundException {

		
		// Récupères les données du fichiers
		List<Membre> listMembres = new LinkedList();
		File file = new File("/Users/simonaliotti/membres/" + club.getIdMembres() + ".txt");

		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {

			Membre membre = null;
			while ((membre = (Membre) ois.readObject()) != null) {
				listMembres.add(membre);
			}
		} catch (IOException e) {
			// e.printStackTrace();
		}

		// Ecrit dans le fichier
		String nameToDelete = sc.input();

		try (FileOutputStream fop = new FileOutputStream(file); ObjectOutputStream oop = new ObjectOutputStream(fop)) {

			if (!file.exists()) {
				file.createNewFile();
			}
			
				for (Membre membreDejaPresentDansFichier : listMembres) {
					if(!(membreDejaPresentDansFichier.getName().equals(nameToDelete))) {
						oop.writeObject(membreDejaPresentDansFichier);
					}
					
				}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
