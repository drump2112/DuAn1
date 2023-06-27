/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swing.barchart.blankchart;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

/**
 *
 * @author sethk
 */
public abstract class BlankPlotChatRender {

    public abstract String getLabelText(int index);
    public abstract void renderSeries(BlankPlotChart chart, Graphics2D g2, SeriesSize size, int index);
}
