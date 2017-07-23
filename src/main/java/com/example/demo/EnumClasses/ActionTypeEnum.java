package com.example.demo.EnumClasses;



public enum ActionTypeEnum {
    ADD(0),
    INCREASE(1),
    DEFAULT(2);

    private long id;

    ActionTypeEnum(long id) {
        this.id = id;
    }

    public long id() {
        return id;
    }

    @Override
    public String toString() {
        switch (this) {
            case ADD:
                return "Add";
            case INCREASE:
                return "Increase";
            default:
                return "Default";
        }
    }
}
