package Model;

import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Guardaroba;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Maglia;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Pantaloni;
import weatherstyle.gestioneguardaroba.applicationlogic.logic.beans.Scarpe;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecoveryGuardaroba {

    private Guardaroba guardaroba;
    private String pathFile;

    public RecoveryGuardaroba(String pathFile) {
        this.guardaroba = new Guardaroba();
        this.pathFile = pathFile;
        recoveryCapoAbbigliamento();
    }

    private void recoveryCapoAbbigliamento() {
        List<Maglia> magliaList = new ArrayList<>();
        List<Pantaloni> pantaloniList = new ArrayList<>();
        List<Scarpe> scarpaList = new ArrayList<>();

        File file = new File(pathFile);

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] split = line.split(",");

                if ("maglia".equalsIgnoreCase(split[0])) {
                    Maglia maglia = new Maglia();
                    maglia.setMateriale(split[1]);
                    maglia.setColore(split[2]);
                    maglia.setLunghezzaManica(split[3]);
                    maglia.setStagione(split[4]);
                    magliaList.add(maglia);
                } else if ("pantaloni".equalsIgnoreCase(split[0])) {
                    Pantaloni pantaloni = new Pantaloni();
                    pantaloni.setMateriale(split[1]);
                    pantaloni.setColore(split[2]);
                    pantaloni.setLunghezza(split[3]);
                    pantaloni.setStagione(split[4]);
                    pantaloniList.add(pantaloni);
                } else {
                    Scarpe scarpe = new Scarpe();
                    scarpe.setTipo(split[1]);
                    scarpe.setAntiscivolo(Boolean.valueOf(split[2]));
                    scarpe.setImpermeabile(Boolean.valueOf(split[3]));
                    scarpe.setColore(split[4]);
                    scarpe.setStagione(split[5]);
                    scarpaList.add(scarpe);
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File CapoAbbigliamentoList non trovato!");
        }

        guardaroba.setMaglie(magliaList);
        guardaroba.setPantaloni(pantaloniList);
        guardaroba.setScarpe(scarpaList);

    }

    public Guardaroba getGuardaroba() {
        return guardaroba;
    }

    public String getPathFile() {
        return pathFile;
    }
}
