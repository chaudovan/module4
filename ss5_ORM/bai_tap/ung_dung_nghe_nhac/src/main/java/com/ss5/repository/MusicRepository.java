package com.ss5.repository;

import com.ss5.model.Music;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MusicRepository implements IMusicRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Music> findAll() {
        List<Music> musicList = new ArrayList<>();
        TypedQuery<Music> query = entityManager.createQuery("select m from Music as m",Music.class);
        musicList = query.getResultList();
        return musicList;
    }

    @Override
    public Music findById(int id) {
        return entityManager.find(Music.class,id);
    }
    @Transactional
    @Override
    public void saveMusic(Music music) {
        entityManager.persist(music);
    }
    @Transactional
    @Override
    public void editMusic(int id, Music music) {
        Music music1 = findById(id);
        music1.setNameMusic(music.getNameMusic());
        music1.setArtist(music.getArtist());
        music1.setCategory(music.getCategory());
        music1.setLink(music.getLink());
        entityManager.merge(music1);
    }
    @Transactional
    @Override
    public void delete(int id) {
        Music music = findById(id);
        entityManager.remove(music);
    }
}
