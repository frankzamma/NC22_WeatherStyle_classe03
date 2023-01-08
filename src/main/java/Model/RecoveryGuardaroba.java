package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecoveryGuardaroba {

    private Guardaroba guardaroba;
    private String pathFile;

    public RecoveryGuardaroba(){
        this.guardaroba = new Guardaroba();
        this.pathFile = "src/main/webapp/WEB-INF/CapoAbbigliamentoList";
        recoveryCapoAbbigliamento();
    }

    private void recoveryCapoAbbigliamento(){
        List<Maglia> magliaList = new ArrayList<>();
        List<Pantalone> pantaloneList = new ArrayList<>();
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
                }else if (split[0].equalsIgnoreCase("pantalone")){
                    Pantalone pantalone = new Pantalone();
                    pantalone.setMateriale(split[1]);
                    pantalone.setColore(split[2]);
                    pantalone.setLunghezza(split[3]);
                    pantalone.setStagione(split[4]);
                    pantaloneList.add(pantalone);
                }else {
                    Scarpa scarpa = new Scarpa();
                    scarpa.setTipo(split[1]);
                    scarpa.setScivoloso(Boolean.valueOf(split[2]));
                    scarpa.setImpermeabile(Boolean.valueOf(split[3]));
                    scarpa.setColore(split[4]);
                    scarpa.setStagione(split[5]);
                    scarpaList.add(scarpa);
                }
            }
        }catch (FileNotFoundException fileNotFoundException){
            System.out.println("File capoAbbigliamentoList non trovato!");
        }

        guardaroba.setMagliaList(magliaList);
        guardaroba.setPantaloneList(pantaloneList);
        guardaroba.setScarpaList(scarpaList);

    }

    public Guardaroba getGuardaroba() {
        return guardaroba;
    }

    public String getPathFile() {
        return pathFile;
    }
}
