package com.ss4bai1.repository;

import com.ss4bai1.model.HopThuEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EmailRepository implements IEmailRepository{
    private static List<HopThuEmail> hopThuEmailList = new ArrayList<>();
    static {
        hopThuEmailList.add(new HopThuEmail(1,"VietNamese",25,false,"VietNamese ok"));
        hopThuEmailList.add(new HopThuEmail(2,"English",5,true,"English chưa ok"));
        hopThuEmailList.add(new HopThuEmail(3,"Japanese",100,false,"Japanese chưa ok"));
    }
    @Override
    public List<HopThuEmail> findAll() {
        return hopThuEmailList;
    }

    @Override
    public void save(HopThuEmail email) {
            hopThuEmailList.add(email);
    }

    @Override
    public HopThuEmail findById(Integer id) {
        HopThuEmail hopThuEmail=null;
        for (HopThuEmail hopThuEmail1:hopThuEmailList) {
            if(hopThuEmail1.getId()==id){
                hopThuEmail = new HopThuEmail(hopThuEmail1.getId(),hopThuEmail1.getLanguages(),hopThuEmail1.getPageSize(),
                        hopThuEmail1.isSpam(),hopThuEmail1.getContent());
            }
        }
        return hopThuEmail;
    }

    @Override
    public void edit(Integer id, HopThuEmail hopThuEmail) {
        for (HopThuEmail hopThuEmail1:hopThuEmailList) {
            if(id==hopThuEmail1.getId()){
                hopThuEmail1.setLanguages(hopThuEmail.getLanguages());
                hopThuEmail1.setPageSize(hopThuEmail.getPageSize());
                hopThuEmail1.setContent(hopThuEmail.getContent());
                hopThuEmail1.setSpam(hopThuEmail.isSpam());
            }
        }
    }
}
