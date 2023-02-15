package com.ss5.service;

import com.ss5.model.Music;
import com.ss5.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService{
    @Autowired
    IMusicRepository iMusicRepository;
    @Override
    public List<Music> findAll() {
        return iMusicRepository.findAll();
    }

    @Override
    public Music findById(int id) {
        return iMusicRepository.findById(id);
    }

    @Override
    public void saveMusic(Music music) {
        iMusicRepository.saveMusic(music);
    }

    @Override
    public void editMusic(int id, Music music) {
        iMusicRepository.editMusic(id,music);
    }

    @Override
    public void delete(int id) {
        iMusicRepository.delete(id);
    }
}
