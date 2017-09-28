package com.example.demo.EnumClasses;


public enum ArmorType {
    NORMAL(0),
    MAGIC(1),
    RARE(2);

    private long id;

    ArmorType(long id) {
        this.id = id;
    }

    public long id() {
        return id;
    }

    @Override
    public String toString() {
        switch (this) {
            case MAGIC:
                return "Magic";
            case RARE:
                return "Rare";
            default:
                return "Normal";
        }
    }
}
