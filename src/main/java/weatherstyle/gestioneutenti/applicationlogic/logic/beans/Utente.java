package weatherstyle.gestioneutenti.applicationlogic.logic.beans;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Guardaroba;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Francesco Giuseppe Zammarrelli
 * La classe Utente.
 */
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
    private LocalDate dataNascita;
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
    private Guardaroba guardaroba;
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
     * Restituisce id.
     *
     * @return Utente.id id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Imposta id.
     *
     * @param id = identificatore utente
     */
    public void setId(Integer id) {
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
     * Restituisce data nascita.
     *
     * @return the data nascita
     */
    public LocalDate getDataNascita() {
        return dataNascita;
    }

    /**
     * Imposta data nascita.
     *
     * @param dataNascita data nascita
     */
    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
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

    /**
     * Restituisce citta.
     *
     * @return the citta
     */
    public List<Citta> getCitta() {
        return citta;
    }

    /**
     * Imposta citta.
     *
     * @param citta citta
     */
    public void setCitta(List<Citta> citta) {
        this.citta = citta;
    }

    /**
     * Is ecologista boolean.
     *
     * @return the boolean
     */
    public boolean isEcologista() {
        return ecologista;
    }

    /**
     * Imposta ecologista.
     *
     * @param ecologista ecologista
     */
    public void setEcologista(boolean ecologista) {
        this.ecologista = ecologista;
    }

    /**
     * Restituisce guardaroba.
     *
     * @return the guardaroba
     */
    public Guardaroba getGuardaroba() {
        return guardaroba;
    }

    /**
     * Imposta guardaroba.
     *
     * @param guardaroba guardaroba
     */
    public void setGuardaroba(Guardaroba guardaroba) {
        this.guardaroba = guardaroba;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", citta=" + citta +
                ", guardaroba=" + guardaroba +
                ", ecologista=" + ecologista +
                '}';
    }
}
