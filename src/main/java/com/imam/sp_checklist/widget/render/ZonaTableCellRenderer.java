
package com.imam.sp_checklist.widget.render;

import com.imam.sp_checklist.entity.master.Zona;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Imam
 */
public class ZonaTableCellRenderer extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 1L;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel jLabel = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (value instanceof Zona) {
            Zona zona = (Zona) value;
            jLabel.setText(zona.getNama()+" - "+zona.getBasement().getNama());
        }
        return jLabel;
    }
}
