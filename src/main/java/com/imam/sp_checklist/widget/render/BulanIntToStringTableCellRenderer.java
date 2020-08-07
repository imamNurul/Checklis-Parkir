
package com.imam.sp_checklist.widget.render;

import com.imam.sp_checklist.entity.master.Basement;
import com.imam.sp_checklist.entity.master.Jabatan;
import java.awt.Component;
import java.text.DateFormatSymbols;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Imam
 */
public class BulanIntToStringTableCellRenderer extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 1L;
    private Locale locale = Locale.forLanguageTag("in-ID");
    

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel jLabel = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (value instanceof Integer) {
            Integer bl = (Integer) value;
            
            DateFormatSymbols dfs = new DateFormatSymbols(locale);
            String namaBln = dfs.getMonths()[bl-1];
            
            jLabel.setText(namaBln);
            
        }
        return jLabel;
    }
}
