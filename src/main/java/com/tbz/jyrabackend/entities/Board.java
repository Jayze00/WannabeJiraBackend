package com.tbz.jyrabackend.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean isOpen;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
