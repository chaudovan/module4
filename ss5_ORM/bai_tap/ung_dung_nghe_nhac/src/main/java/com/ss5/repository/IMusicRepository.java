package com.ss5.repository;

import com.ss5.model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> findAll();
    Music findById(int id);
    void saveMusic(Music music);
    void editMusic(int id,Music music);
    void delete(int id);
}
