package weatherstyle.gestioneutenti.applicationlogic.logic.service;

import weatherstyle.gestionecitta.applicationlogic.logic.beans.Citta;
import weatherstyle.gestioneutenti.applicationlogic.logic.beans.Utente;
import weatherstyle.gestioneutenti.storage.dao.UtenteDAOImpl;
import weatherstyle.gestioneutenti.storage.dao.UtenteDAOInterface;
import weatherstyle.utils.ErrorParameterException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class UtenteLogicImpl implements UtenteLogicService {
    private UtenteDAOInterface utenteDAO;

    public UtenteLogicImpl() {
        utenteDAO = new UtenteDAOImpl();
    }

    public UtenteLogicImpl(UtenteDAOInterface utenteDAO) {
        this.utenteDAO = utenteDAO;
    }

    @Override
    public Utente registraUtente(String nome,String cognome,LocalDate dataNascita,String email,String password,Citta citta) throws ErrorParameterException {
            List<String> errorParameter =  new ArrayList<>();

        if (email == null || (!email.matches("^[a-z0-9\\.\\_]+@[a-z]+\\.[a-z]{2,3}$"))) {
            errorParameter.add("email");
        }

        /*Pattern pattern = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!_;,:+.-]).{8,20}$");
        Matcher matcher = pattern.matcher(password);
        if (password == null || !matcher.matches()) {
            errorParameter.add("password");
        }*/

        if (nome == null || nome.length() < 3 || !nome.matches("^[A-Za-z\\s]{3,30}$")) {
            errorParameter.add("nome");
        }

        if (cognome == null || cognome.length() < 3 || !cognome.matches("^[A-Za-z\\s]{3,30}$")) {
            errorParameter.add("cognome");
        }


        LocalDate today =  LocalDate.now();

        if (!dataNascita.isBefore(today)) {
            errorParameter.add("data-nascita");
        }


        if (errorParameter.isEmpty()) {
            Utente u = new Utente();

            u.setNome(nome);
            u.setCognome(cognome);
            u.setPassword(password);
            u.setDataNascita(dataNascita);
            u.setEcologista(false);
            u.setEmail(email);
            List<Citta> cittaList =  new ArrayList<>();
            if (citta != null) {
                cittaList.add(citta);
            }
            u.setCitta(cittaList);

            utenteDAO.doSaveUtente(u);

            return u;
        } else {
            throw new ErrorParameterException(errorParameter);
        }
    }

    /**
     *
     * @param email
     * @param password
     * @return
     */
    @Override
    public Utente loginUtente(String email,String password) {

        if (email != null && password != null) {
            Pattern pattern =  Pattern.compile("^[a-z0-9\\.\\_]+@[a-z]+\\.[a-z]{2,3}$");
            Matcher matcher = pattern.matcher(email);

            if (matcher.matches()) {
                Utente u = new Utente();

                u.setPassword(password);
                u = utenteDAO.doRetrieveUtenteByUsernameAndPassword(email,u.getPassword());

                if (u != null) {
                    return u;
                } else {
                    throw new IllegalArgumentException("Email e/o password non corretti");
                }
            } else {
                throw new IllegalArgumentException("Formato email non corretto");
            }
        } else {
            throw new IllegalArgumentException("Email e password richiesti per accedere!");
        }
    }



    @Override
    public boolean existsUtente(String email) {
        if (email != null && (email.matches("^[a-z0-9\\.\\_]+@[a-z]+\\.[a-z]{2,3}$"))) {
            return utenteDAO.doExistsEmail(email);
        } else {
            throw new IllegalArgumentException("Formato Email non corretto");
        }
    }
}
