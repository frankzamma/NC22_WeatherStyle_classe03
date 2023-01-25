package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecoveryGuardaroba {

    private Guardaroba guardaroba;
    private String pathFile;

    public RecoveryGuardaroba(String pathFile){
        this.guardaroba = new Guardaroba();
        this.pathFile = pathFile;
        recoveryCapoAbbigliamento();
    }

    private void recoveryCapoAbbigliamento(){
        List<Maglia> magliaList = new ArrayList<>();
        List<Pantaloni> pantaloniList = new ArrayList<>();
        List<Scarpa> scarpaList = new ArrayList<>();

        File file = new File(pathFile);

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()){
                String line = scanner.nextLine();
                String[] split = line.split(",");

                if(split[0].equalsIgnoreCase("maglia")){
                    Maglia maglia = new Maglia();
                    maglia.setMateriale(split[1]);
                    maglia.setColore(split[2]);
                    maglia.setLunghezzaManica(split[3]);
                    maglia.setStagione(split[4]);
                    magliaList.add(maglia);
                }else if (split[0].equalsIgnoreCase("pantaloni")){
                    Pantaloni pantaloni = new Pantaloni();
                    pantaloni.setMateriale(split[1]);
                    pantaloni.setColore(split[2]);
                    pantaloni.setLunghezza(split[3]);
                    pantaloni.setStagione(split[4]);
                    pantaloniList.add(pantaloni);
                }else {
                    Scarpa scarpa = new Scarpa();
                    scarpa.setTipo(split[1]);
                    scarpa.setAntiscivolo(Boolean.valueOf(split[2]));
                    scarpa.setImpermeabile(Boolean.valueOf(split[3]));
                    scarpa.setColore(split[4]);
                    scarpa.setStagione(split[5]);
                    scarpaList.add(scarpa);
                }
            }
        }catch (FileNotFoundException fileNotFoundException){
            System.out.println("File CapoAbbigliamentoList non trovato!");
        }

        guardaroba.setMagliaList(magliaList);
        guardaroba.setPantaloneList(pantaloniList);
        guardaroba.setScarpaList(scarpaList);

    }

    public Guardaroba getGuardaroba() {
        return guardaroba;
    }

    public String getPathFile() {
        return pathFile;
    }
}
