package com.ss5.service;

import com.ss5.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();
    Music findById(int id);
    void saveMusic(Music music);
    void editMusic(int id,Music music);
    void delete(int id);
}
