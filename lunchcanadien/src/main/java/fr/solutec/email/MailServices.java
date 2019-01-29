package fr.solutec.email;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import fr.solutec.entities.User;

@Service
public class MailServices {
	
	
	
	 private void sendMail(String destinataire, String sujet, String contenu)  {
		final String mail = "usertest.lunch@gmail.com";
		final String password = "lunchcanadien";
		//String contenuMail = "OLALA, gab est le meilleur!!!!";
		//String sujetMail = "IMPORTANT";
		//String mailDestinataire = "anais.poujouly@hotmail.fr";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mail, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mail));
			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(destinataire));
			message.setSubject(sujet);
			message.setText(contenu);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	 }

	 public void envMail(User u) {
			String sujet = "Création d'un LunchCanadien";
			String Newligne=System.getProperty("line.separator");
			String contenu = "Bonjour " + u.getPrenom() + "," + Newligne + Newligne + "Vous venez de poster vos disponibilités. "+ Newligne + "Plus qu'à attendre que des collègues se joignent à votre lunch. " + Newligne + Newligne + "Patience ... et bonne journée !" + Newligne + "Equipe LunchCanadien";
			sendMail(u.getEmail(), sujet, contenu);
		}
	 
	 
	 public void envMailOrganisateur(User user) {
		 String sujet = "[LunchCanadien] Choix du restaurant";
		 String Newligne=System.getProperty("line.separator");
		 String contenu = "Bonjour " + user.getPrenom() + "," + Newligne + Newligne + "Un événement a matché." + Newligne + "Veuillez vous rendre sur le lunch pour choisir le lieu de rencontre." + Newligne + Newligne + "Bonne journée !" + Newligne + "Equipe LunchCanadien";
		 sendMail(user.getEmail(), sujet, contenu);
	 }
	 
	 public void envMailGroupe(List<User> users) {
		 String sujet = "[LunchCanadien] Match !";
		 String Newligne=System.getProperty("line.separator");
		 for (User u:users) {
			String contenu = "Bonjour " + u.getPrenom() + "," + Newligne + Newligne + "L'organisateur de votre lunch à choisi un lieu de rencontre. " + Newligne + "Rendez-vous sur votre Lunch pour le découvrir !" + Newligne + Newligne + "Bonne journée." + Newligne + "Equipe LunchCanadien";
			sendMail(u.getEmail(), sujet, contenu);
		 }
	 }
	 
	 public void envMailRappel(List<User> users) {
			String sujet = "[LunchCanadien] Rappel";
			String Newligne=System.getProperty("line.separator");
			for (User u:users) {
				String contenu = "Bonjour " + u.getPrenom() + "," + Newligne + Newligne + "Noubliez pas votre lunch prévu ce midi... Vos collègues vous attendent ! " + Newligne + Newligne + "Bon appétit." + Newligne + "Equipe LunchCanadien";
				sendMail(u.getEmail(), sujet, contenu);
			}
			
		}
}
