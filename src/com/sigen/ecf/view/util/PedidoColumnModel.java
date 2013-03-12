/**
 * <p>Title: SIGEN</p> <p>Description: Classe que será utilizada para mostrar as
 * colunas da tabela.</p>
 *
 * <p>The MIT License</p>
 *
 * <p>Copyright: Copyright (C) 2010 T2Ti.COM</p>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * The author may be contacted at: t2ti.com@gmail.com</p>
 *
 * @author Albert Eije (T2Ti.COM)
 * @version 1.0
 */
package com.sigen.ecf.view.util;

import java.awt.FontMetrics;

import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class PedidoColumnModel extends DefaultTableColumnModel {

    public PedidoColumnModel(FontMetrics fm) {
        addColumn(criaColuna(0, 20, fm, false, "Pedido"));
        addColumn(criaColuna(1, 35, fm, false, "Valor"));
        addColumn(criaColuna(2, 200, fm, false, "Tipo de Pedido"));
        addColumn(criaColuna(3, 300, fm, true, "Situação"));
//        addColumn(criaColuna(4, 80, fm, false, "Órgão RG"));
//        addColumn(criaColuna(4, 80, fm, false, "CEP"));
//        addColumn(criaColuna(5, 80, fm, false, "FONE"));        
//        addColumn(criaColuna(5, 80, fm, false, "Inscrição Estadual"));
//        addColumn(criaColuna(6, 80, fm, false, "Inscrição Municipal"));
//        addColumn(criaColuna(5, 80, fm, false, "Cliente Desde"));
    }

    private TableColumn criaColuna(int columnIndex, int largura, FontMetrics fm, boolean resizable, String titulo) {
        int larguraTitulo = fm.stringWidth(titulo + "  ");
        if (largura < larguraTitulo) {
            largura = larguraTitulo;
        }

        TableColumn col = new TableColumn(columnIndex);
        col.setCellRenderer(new ClienteCellRenderer());
        col.setHeaderRenderer(null);
        col.setHeaderValue(titulo);
        col.setPreferredWidth(largura);
        if (!resizable) {
            col.setMaxWidth(largura);
            col.setMinWidth(largura);
        }
        col.setResizable(resizable);
        return col;
    }
}