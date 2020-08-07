
package com.imam.sp_checklist.widget.render;

import com.imam.sp_checklist.entity.master.Lot;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Imam
 */
public class CeklisDetailLotTableCellEditorCombo extends AbstractCellEditor implements 
        TableCellEditor, ActionListener{

    private static final long serialVersionUID = 1L;
    
    private Lot lot;
    private List<Lot> listLot;

    public CeklisDetailLotTableCellEditorCombo(List<Lot> listLot) {
        
        this.listLot = listLot;
    }
    
    @Override
    public Object getCellEditorValue() {
        return this.lot;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if(value instanceof Lot){
            this.lot = (Lot) value;
        }
        
        JComboBox<Lot> comboLot = new JComboBox<>();
        
        for(Lot alot : listLot){
            comboLot.addItem(alot);
        }
        
        comboLot.setSelectedItem(lot);
        comboLot.addActionListener(this);
        
        if(isSelected){
            comboLot.setBackground(table.getSelectionBackground());
        }else{
            comboLot.setBackground(table.getSelectionForeground());
            
        }
        
        return comboLot;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<Lot> comboCountry = (JComboBox<Lot>) e.getSource();
        this.lot = (Lot) comboCountry.getSelectedItem();
    }


}
