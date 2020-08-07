/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.widget.render;

import com.imam.sp_checklist.entity.user_akses.Pengguna;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author echo
 */
public class PenggunaTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (value instanceof Pengguna) {
            Pengguna pengguna = (Pengguna) value;
            label.setText(pengguna.getId() + " - " + pengguna.getKaryawan().getNama());
        }
        return label;
    }
}
