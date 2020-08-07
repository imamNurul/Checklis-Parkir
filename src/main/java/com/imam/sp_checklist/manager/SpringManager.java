
package com.imam.sp_checklist.manager;

import com.imam.sp_checklist.entity.master.Jabatan;
import com.imam.sp_checklist.entity.master.Karyawan;
import com.imam.sp_checklist.entity.user_akses.Grup;
import com.imam.sp_checklist.entity.user_akses.HakAkses;
import com.imam.sp_checklist.entity.user_akses.HakAksesConstant;
import com.imam.sp_checklist.entity.user_akses.Pengguna;
import com.imam.sp_checklist.service.GrupService;
import com.imam.sp_checklist.service.HakAksesService;
import com.imam.sp_checklist.service.JabatanService;
import com.imam.sp_checklist.service.KaryawanService;
import com.imam.sp_checklist.service.PenggunaService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author ImamNH
 */
public class SpringManager {

    private ApplicationContext applicationContext;

    private SpringManager() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        context.registerShutdownHook();

        this.applicationContext = context;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public <T> T getBean(Class<T> requiredType) throws BeansException {
        return applicationContext.getBean(requiredType);
    }

    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return applicationContext.getBean(name, requiredType);
    }

    private static SpringManager INSTANCE;

    public static SpringManager getInstance() {
        if (SpringManager.INSTANCE == null) {
            SpringManager.INSTANCE = new SpringManager();

            HakAksesService hakAksesService = SpringManager.getInstance().getBean(HakAksesService.class);
            for (HakAksesConstant constant : HakAksesConstant.values()) {
                HakAkses hakAkses = hakAksesService.find(constant.toString());
                if (hakAkses == null) {
                    hakAkses = new HakAkses();
                    hakAkses.setId(constant.toString());
                    hakAkses.setNama(constant.toString());
                    hakAkses.setWaktuDibuat(new Date());
                    hakAkses.setBuatBy("Administrator");
                    hakAkses.setWaktuUbah(new Date());
                    hakAkses.setUbahBy("Administrator");
                    hakAksesService.save(hakAkses);
                }
            }

            GrupService grupService = SpringManager.getInstance().getBean(GrupService.class);
            Grup grup = grupService.find("ADMIN");
            
            System.out.println("Add Group : "+grup);
            
            if (grup == null) {
                grup = new Grup();
                grup.setId("ADMIN");
                grup.setNama("Administrator");
                List<HakAkses> akseses = hakAksesService.findAll();
                for (HakAkses akses : akseses) {
                    grup.tambahHakAkses(akses);
                }
                grup.setBuatBy("Administrator");
                grup.setWaktuDibuat(new Date());
                grup.setWaktuUbah(new Date());
                grup.setUbahBy("Administrator");
                grupService.save(grup);
                
            }

            JabatanService jabatanService = SpringManager.getInstance().getBean(JabatanService.class);
            Jabatan jabatan = jabatanService.find("admin");
            if (jabatan == null) {
                jabatan = new Jabatan();
                jabatan.setId("admin");
                jabatan.setNama("Administrator");
                jabatan.setBuatBy("Administrator");
                jabatan.setWaktuDibuat(new Date());
                jabatan.setWaktuUbah(new Date());
                jabatan.setUbahBy("Administrator");
                jabatanService.save(jabatan);
            }

            KaryawanService karyawanService = SpringManager.getInstance().getBean(KaryawanService.class);
            Karyawan karyawan = karyawanService.find("admin");
            if (karyawan == null) {
                karyawan = new Karyawan();
                karyawan.setId("admin");
                karyawan.setJabatan(jabatan);
                karyawan.setTmpt_lahir("Jakarta");
                karyawan.setAlamat("Jl. Pisangan Bekasi");
                karyawan.setJekel("L");
                karyawan.setPhoto("C:\\Users\\Imam-pc\\Pictures\\Foto.jpg");
                karyawan.setFlag(true);
                karyawan.setNama("Administrator");
                karyawan.setTanggalLahir(new Date());
                karyawan.setTelepon("085000000000");
                karyawan.setBuatBy("Administrator");
                karyawan.setWaktuDibuat(new Date());
                karyawan.setWaktuUbah(new Date());
                karyawan.setUbahBy("Administrator");
                karyawanService.save(karyawan);
            }

            PenggunaService penggunaService = SpringManager.getInstance().getBean(PenggunaService.class);
            Pengguna pengguna = penggunaService.find("admin");
            if (pengguna == null) {
                pengguna = new Pengguna();
                pengguna.setAktif(true);
                pengguna.setGrup(grup);
                pengguna.setId("admin");
                pengguna.setKaryawan(karyawan);
                pengguna.setKataSandi("admin");
                pengguna.setBuatBy("Administrator");
                pengguna.setWaktuDibuat(new Date());
                pengguna.setWaktuUbah(new Date());
                pengguna.setUbahBy("Administrator");
                penggunaService.save(pengguna);
            }

       }
        return SpringManager.INSTANCE;
    }
}
