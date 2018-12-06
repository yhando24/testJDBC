package bean;

public class Livre {

	
private int id;
private String titre;
private String genre;
private String categorie;
private int id_auteur;
private int id_editeur;
private int id_genre;

public Livre() {
	
}

public Livre(int id, String titre, String genre, String categorie, int id_auteur, int id_editeur, int id_genre) {
	this.id = id;
	this.titre = titre;
	this.genre = genre;
	this.categorie = categorie;
	this.id_auteur = id_auteur;
	this.id_editeur = id_editeur;
	this.id_genre = id_genre;
}

public String getTitre() {
	return titre;
}

public void setTitre(String titre) {
	this.titre = titre;
}

public String getGenre() {
	return genre;
}

public void setGenre(String genre) {
	this.genre = genre;
}

public String getCategorie() {
	return categorie;
}

public void setCategorie(String categorie) {
	this.categorie = categorie;
}

public int getId_auteur() {
	return id_auteur;
}

public void setId_auteur(int id_auteur) {
	this.id_auteur = id_auteur;
}

public int getId_editeur() {
	return id_editeur;
}

public void setId_editeur(int id_editeur) {
	this.id_editeur = id_editeur;
}

public int getId_genre() {
	return id_genre;
}

public void setId_genre(int id_genre) {
	this.id_genre = id_genre;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

@Override
public String toString() {
	return "Livre  : id=" + id + ", titre : " + titre + ", genre : " + genre + ", categorie : " + categorie + ", id_auteur :"
			+ id_auteur + ", id_editeur : " + id_editeur + ", id_genre : " + id_genre + "]";
}
	




}
