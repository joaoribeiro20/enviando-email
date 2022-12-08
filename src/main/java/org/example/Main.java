package org.example;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Properties props = new Properties();
        /** Parâmetros de conexão com servidor Gmail */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Usuario usuariop = new Usuario();
        Scanner ler = new Scanner(System.in);

        //usuariop.setNome("joao");
        //System.out.println(usuariop.getNome());

        System.out.println("Digite o seu nome e primeiro sobrenome:");
        String nome = ler.nextLine();
        usuariop.setNome(nome);

        System.out.println("Digite o seu gmail:");
        String gmail = ler.nextLine();
        usuariop.setGmail(gmail);

        System.out.println("Os dados cadastrados foram: -----");
        System.out.println("nome pessoal: -----" + usuariop.getNome());
        System.out.println("gmail: -----" + usuariop.getGmail());

        /** Parâmetros de conexão com servidor Gmail
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");*/

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication()
                    {
                        return new PasswordAuthentication("jvalves217@gmail.com", "iskdzhfzttlniubg");
                    }
                });

        /** Ativa Debug para sessão */
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("jvalves217@gmail.com"));
            //Remetente

            Address[] toUser = InternetAddress.parse(usuariop.getGmail());

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("BEM-VINDO " + usuariop.getNome());//Assunto
            message.setText("É um prazer ter você com a gente, esse email foi cadastrado em nosso banco de dados!!!");
            /**Método para enviar a mensagem criada*/
            Transport.send(message);

            System.out.println(" Feito, email enviado !!!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

