package com.example.demo.DataBase;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Armor")
public class Armor extends BaseModel implements Serializable {
    private int armor;
    private int quality;
    private List<Mode> suffix;
    private List<Mode> prefix;


    @ManyToMany(cascade = CascadeType.ALL)
    @Access(AccessType.PROPERTY)
    @JoinTable(name = "MODE_AND_ARMOR_PREFIX", joinColumns = { @JoinColumn( name = "mode_id") }, inverseJoinColumns = { @JoinColumn(name = "armor_id") })
    public List<Mode> getPrefix() {
        return this.prefix;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @Access(AccessType.PROPERTY)
    @JoinTable(name = "MODE_AND_ARMOR_SUFFIX", joinColumns = { @JoinColumn( name = "mode_id") }, inverseJoinColumns = { @JoinColumn(name = "armor_id") })
    public List<Mode> getSuffix() {
        return this.suffix;
    }
}
