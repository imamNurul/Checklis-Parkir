/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.widget.render;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author echo
 */
public class TanggalJadwalTableCellRenderer extends DefaultTableCellRenderer {
    
     Locale locale = Locale.forLanguageTag("in-ID");

    private SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, d MMMM", locale);

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (value instanceof Date) {
            Date date = (Date) value;
            label.setText(dateFormat.format(date));
        }
        return label;
    }
}
