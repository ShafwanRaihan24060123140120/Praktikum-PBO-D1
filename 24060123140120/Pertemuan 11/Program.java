/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jdbc.program;

/**
 *
 * @author ThinkPad T14s
 */

import jdbc.service.MysqlMahasiswaService;
import java.util.*;
import jdbc.model.Mahasiswa;

public class Program {
    static MysqlMahasiswaService service = new MysqlMahasiswaService();
    public static void main(String[] args) {
        List<Mahasiswa> listmhs = new ArrayList<>();
        System.out.println("");

        // insert
        System.out.println("=== insert ===");
        Mahasiswa mhsAdd = new Mahasiswa(5, "Haryo");
        service.add(mhsAdd);
        System.out.println("Berhasil insert: " + mhsAdd);
        displayAll();

        // update
        System.out.println("=== update ===");
        Mahasiswa mhsUpdate = service.getById(5); 
        System.out.println("Akan diupdate data lama: " + mhsUpdate);
        mhsUpdate.setNama("Dinaya");
        System.out.println("Dengan data baru: " + mhsUpdate);
        service.update(mhsUpdate);
        displayAll();

        // delete
        System.out.println("=== delete ===");
        System.out.println("Akan dihapus: " + service.getById(5));
        service.delete(5);
        displayAll();
    }

    
    public static void displayAll() {
        List<Mahasiswa> semuaMahasiswa = service.getAll();
        System.out.println("=== Semua Mahasiswa ===");
        for (Mahasiswa m : semuaMahasiswa) {
            System.out.println(m);
        }
        System.out.println("========================\n");
    }
}
 