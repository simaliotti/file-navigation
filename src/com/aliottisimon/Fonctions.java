package com.aliottisimon;

import java.io.File;
import java.io.IOException;

public class Fonctions {

	File file = null;
	MyScanner sc = new MyScanner();

	/**
	 * Constructeur par defaut qui initialise le repertoire de navigation
	 */
	public Fonctions() {
		this.file = new File("C:\\dossier");
	}

	/**
	 * Liste les dossiers
	 */
	public void ls() {
		String[] tab = file.list();
		for (String row : tab) {
			System.out.println(row);
		}
	}

	/**
	 * Créé un nouveau dossier
	 */
	public void mkdir(String chemin) {
		String path = file.getAbsolutePath();
		path = path + "\\\\" + chemin;
		File fileMkdir = new File(path);
		fileMkdir.mkdir();
		System.out.println("Your folder has been created");

	}

	/**
	 * Créé un nouveau fichier
	 * 
	 * @throws IOException
	 */
	public void touch(String chemin) throws IOException {
		String path = file.getAbsolutePath();
		path = path + "\\\\" + chemin;
		File fileTouch = new File(path);
		fileTouch.createNewFile();
		System.out.println("Your file has been created");

	}

	/**
	 * Supprime un dossier ou fichier
	 */
	public void rm(String chemin) {

		String path = file.getAbsolutePath();
		path = path + "\\\\" + chemin;
		File fileRm = new File(path);

		String[] contentTab = fileRm.list();

		boolean isEmpty;

		try {
			isEmpty = contentTab[0].isEmpty();
			isEmpty = false;
		} catch (Exception e) {
			isEmpty = true;
		}

		if (isEmpty) {
			fileRm.delete();
			System.out.println("Your file/folder has been removed");
		} else {
			for (String string : contentTab) {
				File fileDelete = new File(path + "\\\\" + string);
				fileDelete.delete();

			}
			fileRm.delete();
			System.out.println("Your file/folder has been removed");
		}

	}

	/**
	 * Affiche le repertoire courant
	 */
	public void pwd() {
		System.out.println("Current path "+file.getAbsolutePath());
	}

	/**
	 * change dans un repertoire enfant
	 */
	public void cd(String chemin) {
		String path = file.getAbsolutePath();
		path = path + "\\\\" + chemin;
		File fileCd = new File(path);
		this.file = fileCd;
	}

	/**
	 * Va au repetoire parent
	 */
	public void cdParent() {
		File fileCdParent = new File(file.getParent());
		this.file = fileCdParent;
	}

}
