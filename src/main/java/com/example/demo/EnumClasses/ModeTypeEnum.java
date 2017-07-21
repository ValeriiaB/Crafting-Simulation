package com.example.demo.EnumClasses;

public enum ModeTypeEnum {
    PREFIX(1L) ,
    SUFFIX(2L),
    CORRUPTED(3L);
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
            default:
                return "Corrupted";
        }
    }
}
