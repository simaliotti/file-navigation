package com.aliottisimon.club;

import java.io.FileNotFoundException;
import java.io.IOException;

public class App {

	MyScanner sc = new MyScanner();
	ServiceClub sclub = new ServiceClub();
	ServiceMembre smembre = new ServiceMembre();

	public void launchApp() throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("Bienvenue dans l'application club");
		//sclub.writeClub(sc);
		 //sclub.listClub();
		 //sclub.readClub(sc);
		// sclub.deleteClub(sc);

		// teste serviceMembre

		Club club = new Club();
		club.setName("simon");
		club.setIdMembres("Membres-" + club.getName());
		//smembre.writeMembre(sc, club);
		//smembre.readMembre(sc);
		smembre.deleteMembre(sc, club);
		smembre.readMembre(sc);
	}

}
