package com.ss5.controller;

import com.ss5.model.Music;
import com.ss5.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    IMusicService iMusicService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("musicList", iMusicService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("music", new Music());
        return "create";
    }

    @PostMapping("/create")
    public String createMusic(@ModelAttribute Music music) {
        iMusicService.saveMusic(music);
        return "redirect:/music";
    }

    @GetMapping("/edit")
    public String showEdit(@RequestParam int id, Model model) {
        model.addAttribute("music", iMusicService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String editMusic(@ModelAttribute Music music) {
        iMusicService.editMusic(music.getId(), music);
        return "redirect:/music";
    }

    @GetMapping("/delete")
    public String deleteMusic(@RequestParam int id) {
        iMusicService.delete(id);
        return "redirect:/music";
    }
}
