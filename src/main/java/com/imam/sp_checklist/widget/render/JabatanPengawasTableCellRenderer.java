
package com.imam.sp_checklist.widget.render;

import com.imam.sp_checklist.entity.master.Basement;
import com.imam.sp_checklist.entity.master.Jabatan;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Imam
 */
public class JabatanPengawasTableCellRenderer extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 1L;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel jLabel = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (value instanceof Boolean) {
            Boolean bl = (Boolean) value;
            if(bl == true){
                jLabel.setText("Ya");
            }else{
                jLabel.setText("Tidak");
            }
            
        }
        return jLabel;
    }
}
