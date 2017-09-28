package com.example.demo;


import com.example.demo.DataBase.Armor;
import com.example.demo.DataBase.Mode;
import com.example.demo.EnumClasses.ArmorType;

import java.util.*;

public class CurrencyManager {

    Random random = new Random();
    List<Mode> suffix;
    List<Mode> prefix;

    public String useTransmutation(Armor armor){
        if (armor.getType() != ArmorType.NORMAL)
            return "Error";
        int numberOfModes = random.nextInt(2) + 1;
        Mode mode;

        if(numberOfModes == 2){
            mode = suffix.get(random.nextInt(suffix.size()));
            mode.setRandomCurrentValues();
            armor.getSuffix().add(mode);
            mode = prefix.get(random.nextInt(prefix.size()));
            mode.setRandomCurrentValues();
            armor.getPrefix().add(mode);
        }
        else if(random.nextInt(2) + 1 == 1){
            mode = suffix.get(random.nextInt(suffix.size()));
            mode.setRandomCurrentValues();
            armor.getSuffix().add(mode);
        }
        else {
            mode = prefix.get(random.nextInt(prefix.size()));
            mode.setRandomCurrentValues();
            armor.getPrefix().add(mode);
        }
        armor.setType(ArmorType.MAGIC);
        return "";
    }

    public String useScouring(Armor armor){
        if (armor.getType() == ArmorType.NORMAL)
            return "Error";
        armor.getSuffix().clear();
        armor.getPrefix().clear();
        armor.setType(ArmorType.NORMAL);
        return "";
    }

    public String useAlteration(Armor armor){
        if (armor.getType() != ArmorType.MAGIC)
            return "Error";
        useScouring(armor);
        useTransmutation(armor);
        return "";
    }

    public String useAugmentation(Armor armor){
        if (armor.getType() == ArmorType.MAGIC && (armor.getSuffix().size() == 0 || armor.getPrefix().size() == 0)) {
            if(armor.getSuffix().size() == 0){
                Mode mode = suffix.get(random.nextInt(suffix.size()));
                mode.setRandomCurrentValues();
                armor.getSuffix().add(mode);
            }
            else{
                Mode mode = prefix.get(random.nextInt(prefix.size()));
                mode.setRandomCurrentValues();
                armor.getPrefix().add(mode);
            }
            return "";
        }
        else {
            return "Error";
        }
    }

    public String useRegal(Armor armor){
        if (armor.getType() != ArmorType.MAGIC)
            return "Error";
        if(random.nextInt(2) + 1 == 1){
            Mode mode = suffix.get(random.nextInt(suffix.size()));
            while(true) {
                if (!suffix.contains(mode))
                    break;
                mode = suffix.get(random.nextInt(suffix.size()));
            }
            mode.setRandomCurrentValues();
            armor.getSuffix().add(mode);
        }
        else {
            Mode mode = prefix.get(random.nextInt(prefix.size()));
            while(true) {
                if (!prefix.contains(mode))
                    break;
                mode = prefix.get(random.nextInt(prefix.size()));
            }
            mode.setRandomCurrentValues();
            armor.getPrefix().add(mode);
        }
        armor.setType(ArmorType.RARE);
        return "";
    }

    public String useAlchemy(Armor armor){
        if (armor.getType() != ArmorType.NORMAL)
            return "Error";
        int numberOfModes = random.nextInt(4) + 3;
        int numberOfSuffixes = 0;
        int numberOfPrefixes = 0;
        switch (numberOfModes){
            case 3:
                numberOfSuffixes = random.nextInt(4);
                numberOfPrefixes = 3 - numberOfSuffixes;
                break;
            case 4:
                numberOfSuffixes = random.nextInt(3) + 1;
                numberOfPrefixes = 4 - numberOfSuffixes;
                break;
            case 5:
                numberOfSuffixes = random.nextInt(2) + 2;
                numberOfPrefixes = 5 - numberOfSuffixes;
                break;
            case 6:
                numberOfSuffixes = 3;
                numberOfPrefixes = 3;
                break;
        }
        for(int i = 0; i < numberOfSuffixes; i++){
            Mode mode = suffix.get(random.nextInt(suffix.size()));
            while(true) {
                if (!suffix.contains(mode))
                    break;
                mode = suffix.get(random.nextInt(suffix.size()));
            }
            mode.setRandomCurrentValues();
            armor.getSuffix().add(mode);
        }
        for (int i = 0; i < numberOfPrefixes ; i++) {
            Mode mode = prefix.get(random.nextInt(prefix.size()));
            while(true) {
                if (!prefix.contains(mode))
                    break;
                mode = prefix.get(random.nextInt(prefix.size()));
            }
            mode.setRandomCurrentValues();
            armor.getPrefix().add(mode);
        }
        armor.setType(ArmorType.RARE);
        return "";
    }
    public String useChaos(Armor armor){
        if (armor.getType() != ArmorType.RARE)
            return "Error";
        useScouring(armor);
        useAlchemy(armor);
        return "";
    }
}

