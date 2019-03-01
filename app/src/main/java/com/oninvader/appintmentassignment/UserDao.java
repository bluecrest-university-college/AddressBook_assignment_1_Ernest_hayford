package com.oninvader.appintmentassignment;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("Select * FROM user Order by lastname ASC")
    List<User> getAllUsers();

    @Insert
    void addUser(User user);
}
