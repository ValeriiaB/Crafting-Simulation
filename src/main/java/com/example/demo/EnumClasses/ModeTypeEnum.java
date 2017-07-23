package com.example.demo.EnumClasses;

public enum ModeTypeEnum {
    PREFIX(0) ,
    SUFFIX(1),
    CORRUPTED(2);
    private long id;

    ModeTypeEnum(long id) {
        this.id = id;
    }

    public long id() {
        return id;
    }

    @Override
    public String toString() {
        switch (this) {
            case PREFIX:
                return "Prefix";
            case SUFFIX:
                return "Suffix";
            case CORRUPTED:
                return "Corrupted";
            default:
                return "";
        }
    }
}
