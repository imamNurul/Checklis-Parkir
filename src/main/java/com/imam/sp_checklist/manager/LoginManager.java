
package com.imam.sp_checklist.manager;

import com.imam.sp_checklist.entity.user_akses.Pengguna;
import com.imam.sp_checklist.service.PenggunaService;

/**
 *
 * @author ImamNH
 */
public class LoginManager {

    private static LoginManager INSTANCE;

    public static LoginManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LoginManager();
        }
        return LoginManager.INSTANCE;
    }

    private String id;

    private LoginManager() {
        // singleton class
    }

    public boolean login(String username, String password) {
        if (getPenggunaService().contains(username, password)) {
            this.id = username;
            return true;
        } else {
            return false;
        }
    }

    public void logout() {
        this.id = null;
    }

    public Pengguna getPengguna() {
        if (id == null) {
            return null;
        } else {
            return getPenggunaService().find(id);
        }
    }

    private PenggunaService getPenggunaService() {
        return SpringManager.getInstance().getBean(PenggunaService.class);
    }
}
