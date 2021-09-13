/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.util;

import java.awt.Component;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Jeferson
 */
public class ValorRender extends DefaultTableCellRenderer {
    NumberFormat nf = NumberFormat.getInstance(new Locale("pt","Br"));
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,int column){
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if(value instanceof Double){
            this.setText(nf.format((Double)value));
        }
        return this;
    }
    
}
