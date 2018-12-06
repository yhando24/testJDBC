import java.util.ArrayList;
import java.util.Scanner;

import Prepare.Create;
import Prepare.Delete;
import Prepare.Read_book;
import Prepare.Update_Book;
import bean.Livre;

public class main {

	public static void main(String[] args) {

	Livre livre = new Livre();	
	
	Scanner sc = new Scanner(System.in);		
//	System.err.println("Veuillez saisir l'id du livre a recuperer");
//	int id = sc.nextInt();
//	
//	// recuperation du livre grace a l'id
//	livre = Read_book.readBookByid(id);
//	System.out.println(livre.toString());
//	
//	System.err.println("Veuillez saisir le genre des livre a recuperer");
//	sc.nextLine();
//	String genre = sc.nextLine();
//	
//	ArrayList <Livre> livres = Read_book.readBookByGenre(genre);
//	System.err.println("Liste des livres recuperés");
//	
//	for (Livre livre2 : livres) {
//		System.out.println(livre2.toString());
//	}
//	
//	System.err.println("Veuillez saisir l'id de livre a changer");
//	id = sc.nextInt();
//	livre = Read_book.readBookByid(id);
//	String OldName = livre.getTitre();
//	
//	sc.nextLine();
//	System.err.println("Veuillez saisir le nouveau nom a mettre");
//	String NewTtitre = sc.nextLine();
//	Update_Book.updateTitreById(id, NewTtitre);
//	livre = Read_book.readBookByid(id);
//	NewTtitre = livre.getTitre();
//	System.err.println("Update réussit ! \r\n ancien titre : " + OldName + ". Nouveau titre : " + NewTtitre );
	
	// AJOUT AUTEUR
	
	System.err.println("Veuillez saisir l'auteur a ajouter");
	String lol = sc.nextLine();
	Create.AddAuteur(lol);
	
	System.err.println("Veuillez saisir le genre a ajouter");
	
	Create.AddGenre(sc.nextLine());
	
	System.err.println("Veuillez saisir l'id du genre a supprimer");
	
	Delete.deleteGenre(sc.nextInt());
	
	
	}
	
	
	



}
