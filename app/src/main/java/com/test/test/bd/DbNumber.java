package com.test.test.bd;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DbNumber {
    @PrimaryKey
    public long id;

    public String number;

    public String numberText;
}
