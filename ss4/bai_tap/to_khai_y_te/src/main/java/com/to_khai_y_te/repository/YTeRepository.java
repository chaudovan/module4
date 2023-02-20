package com.to_khai_y_te.repository;

import com.to_khai_y_te.model.ToKhaiYTe;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class YTeRepository implements IYTeRepository {
    private static List<ToKhaiYTe> toKhaiYTeList = new ArrayList<>();

    static {
        toKhaiYTeList.add(new ToKhaiYTe(1, "Van Chau", "1990", "nam", "Việt Nam", "321654987", "moto", "06", "02", "2023", "02", "07",
                "2023", "không", "Nại Hiên Đông 10", "0905010203", "chau@gmail.com"));
        toKhaiYTeList.add(new ToKhaiYTe(2, "Van Anh", "1990", "nam", "Việt Nam", "321654987", "moto", "06", "02", "2023", "02", "07",
                "2023", "không", "Nại Hiên Đông 10", "0905010203", "chau@gmail.com"));

    }

    @Override
    public List<ToKhaiYTe> findAll() {
        return toKhaiYTeList;
    }

    @Override
    public void editYTe(int id, ToKhaiYTe toKhaiYTe) {
        for (ToKhaiYTe x : toKhaiYTeList) {
            if (x.getId() == id) {
                x.setHoTen(toKhaiYTe.getHoTen());
                x.setNamSinnh(toKhaiYTe.getNamSinnh());
                x.setCMND(toKhaiYTe.getCMND());
                x.setDiaChi(toKhaiYTe.getDiaChi());
                x.setDienThoai(toKhaiYTe.getDienThoai());
                x.setEmail(toKhaiYTe.getEmail());
                x.setLoaiPhuongTien(toKhaiYTe.getLoaiPhuongTien());
                x.setNgayKhoiHanh(toKhaiYTe.getNgayKhoiHanh());
                x.setNgayKetThuc(toKhaiYTe.getNgayKetThuc());
                x.setQuocTich(toKhaiYTe.getQuocTich());
                x.setDiLai(toKhaiYTe.getDiLai());
                x.setGioiTinh(toKhaiYTe.getGioiTinh());
                x.setThangKetThuc(toKhaiYTe.getThangKetThuc());
                x.setNamKetThuc(toKhaiYTe.getNamKetThuc());
                x.setThangKhoiHanh(toKhaiYTe.getThangKhoiHanh());
                x.setNamKhoiHanh(toKhaiYTe.getNamKhoiHanh());
            }
        }
    }

    @Override
    public ToKhaiYTe findById(int id) {
        ToKhaiYTe toKhaiYTeNew = null;
        for (ToKhaiYTe x : toKhaiYTeList) {
            if (x.getId() == id) {
                toKhaiYTeNew = new ToKhaiYTe(x.getId(), x.getHoTen(), x.getNamSinnh(), x.getGioiTinh(), x.getQuocTich(), x.getCMND(),
                        x.getLoaiPhuongTien(), x.getNgayKhoiHanh(), x.getThangKhoiHanh(), x.getNamKhoiHanh(), x.getNamKetThuc(), x.getThangKetThuc(), x.getNamKetThuc(), x.getDiLai(),
                        x.getDiaChi(), x.getDienThoai(), x.getEmail());
            }
        }
        return toKhaiYTeNew;
    }
}
