package weatherstyle.gestioneutenti.applicationlogic.logic.beans;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Utente {
    /**
     * identificatore di un utente.
     */
    private Integer id;
    /**
     * nome di un utente.
     */
    private String nome;
    /**
     * cognome di un utente.
     */
    private String cognome;
    /**
     * data di nascita di un utente.
     */
    private String dataNascita;
    /**
     * email di un utente.
     */
    private String email;
    /**
     * password hash.
     */
    private String password;
    /**
     * città preferite di un utente.
     */
    private List<Citta> citta;
    /**
     * indica se l'utente è un ecologista o meno.
     */
    private boolean ecologista;
    /**
     * Costruttore senza parametri
    */
    public Utente() {
    }
    /**
     * @return Utente.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id = identificatore utente
     */
    public void setId(Integer id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(password.getBytes(StandardCharsets.UTF_8));
            this.password = String.format("%040x", new BigInteger(1, digest.digest()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Citta> getCitta() {
        return citta;
    }

    public void setCitta(List<Citta> citta) {
        this.citta = citta;
    }

    public boolean isEcologista() {
        return ecologista;
    }

    public void setEcologista(boolean ecologista) {
        this.ecologista = ecologista;
    }
}
