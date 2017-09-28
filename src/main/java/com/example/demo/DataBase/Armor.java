package com.example.demo.DataBase;


import com.example.demo.EnumClasses.ArmorType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Armor")
public class Armor extends BaseModel implements Serializable {
    private int armor = 400;
    private int quality;
    private ArmorType type;
    private Set<Mode> suffix;
    private Set<Mode> prefix;


    @ManyToMany(cascade = CascadeType.ALL)
    @Access(AccessType.PROPERTY)
    @JoinTable(name = "MODE_AND_ARMOR_PREFIX", joinColumns = { @JoinColumn( name = "mode_id") }, inverseJoinColumns = { @JoinColumn(name = "armor_id") })
    public Set<Mode> getPrefix() {
        return this.prefix;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @Access(AccessType.PROPERTY)
    @JoinTable(name = "MODE_AND_ARMOR_SUFFIX", joinColumns = { @JoinColumn( name = "mode_id") }, inverseJoinColumns = { @JoinColumn(name = "armor_id") })
    public Set<Mode> getSuffix() {
        return this.suffix;
    }
}
