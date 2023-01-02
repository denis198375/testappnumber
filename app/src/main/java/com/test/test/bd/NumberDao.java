package com.test.test.bd;



import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NumberDao {
    @Query("SELECT * FROM dbnumber")
    List<DbNumber> getAll();

    @Query("SELECT * FROM dbnumber WHERE id = :id")
    DbNumber getById(long id);

    @Insert
    void insert(DbNumber employee);

    @Update
    void update(DbNumber employee);

    @Delete
    void delete(DbNumber employee);
}
