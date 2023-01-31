package weatherstyle.gestioneutenti.applicationlogic.logic.beans;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Francesco Giuseppe Zammarrelli
 * La classe Admin.
 */
public class Admin {
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private String password;

    /**
     * Instanzia a new Admin.
     */
    public Admin() {
    }

    /**
     * Restituisce id.
     *
     * @return id id
     */
    public int getId() {
        return id;
    }

    /**
     * Imposta id.
     *
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Restituisce nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta nome.
     *
     * @param nome nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce cognome.
     *
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Imposta cognome.
     *
     * @param cognome cognome
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Restituisce email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Imposta email.
     *
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Restituisce password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Imposta password.
     *
     * @param password password
     */
    public void setPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(password.getBytes(StandardCharsets.UTF_8));
            this.password = String.format("%040x",new BigInteger(1,digest.digest()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
