package com.aliottisimon.club;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ServiceClub {

	

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

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void readClub(MyScanner sc) throws FileNotFoundException, IOException, ClassNotFoundException {
		String nomClub = sc.input();
		File file = new File("/Users/simonaliotti/club/"+nomClub+".txt");

		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {

			Club club = (Club) ois.readObject();

			System.out.println(club);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Club createClub(MyScanner sc) {
		Club club = new Club();
		club.setAdress(sc.input());
		club.setName(sc.input());
		return club;
	}
	
	public void listClub() {
		File file = new File("/Users/simonaliotti/club");
		String[] tabClub = file.list();
		for (String string : tabClub) {
			String[] nameClub = string.split("(.txt)");
			System.out.println(nameClub[0]);
		}
	}

	public void deleteClub(MyScanner sc) {
		String nomClub = sc.input();
		File fileClub = new File("/Users/simonaliotti/club/"+nomClub+".txt");
		fileClub.delete();
		File fileMembre = new File("/Users/simonaliotti/membres/Membres-"+nomClub+".txt");
		fileMembre.delete();
	}
}
