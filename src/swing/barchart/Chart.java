/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package swing.barchart;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.PropertySetter;
import swing.barchart.blankchart.BlankPlotChart;
import swing.barchart.blankchart.BlankPlotChatRender;
import swing.barchart.blankchart.SeriesSize;

/**
 *
 * @author sethk
 */
public class Chart extends javax.swing.JPanel {

    /**
     * Creates new form Chart
     */
    private String labelText;
    private int overIndex = -1;
    private List<ModelLegend> legends = new ArrayList<>();
    private List<ModelChart> model = new ArrayList<>();

    private float animate;
    private Point labelLocation = new Point();
    private Animator animatorLabel;
    private TimingTarget targetLabel;

    private final DecimalFormat df = new DecimalFormat("#,##0.##");
    private final int seriesSize = 12;
    private final int seriesSpace = 6;
    private final Animator animator;

    public Chart() {
        initComponents();
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                animate = fraction;
                repaint();
            }
        };
        
        animator = new Animator(800, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        
        
        blankPlotChart.setBlankPlotChatRender(new BlankPlotChatRender() {
            @Override
            public String getLabelText(int index) {
                return model.get(index).getLabel();
            }

            @Override
            public void renderSeries(BlankPlotChart chart, Graphics2D g2, SeriesSize size, int index) {
                double totalSeriesWidth = (seriesSize * legends.size()) + (seriesSpace * (legends.size() - 1));
                double x = (size.getWidth() - totalSeriesWidth) / 2;
                for (int i = 0; i < legends.size(); i++) {
                    ModelLegend legend = legends.get(i);
                    g2.setColor(legend.getColor());
                    double seriesValues = chart.getSeriesValuesOf(model.get(index).getValues()[i], size.getHeight()) * animate;
                    g2.fillRect((int) (size.getX() + x), (int) (size.getY() + size.getHeight() - seriesValues), seriesSize, (int) seriesValues);
                    x += seriesSpace + seriesSize;
                }
            }

        });

    }

    private float ease(float f, int t) {
        double v = 1 - Math.pow(1 - f, t);
        return (float) v;
    }

    private int toIndex(int index, int i) {
        return index * legends.size() + i;
    }

    private void startAnimateLabel(Point oldLocation, Point newLocation) {
        
        if (animatorLabel.isRunning()) {
            animatorLabel.stop();
        }
        
        animatorLabel.removeTarget(targetLabel);
        
        targetLabel = new PropertySetter(this, "changeLocation", oldLocation, newLocation);
        
        animatorLabel.addTarget(targetLabel);
        
        animatorLabel.start();
        
    }

    public void addLegend(String name, Color color) {
        ModelLegend data = new ModelLegend(name, color);
        legends.add(data);
        panelLegend.add(new LegendItem(data));
        panelLegend.repaint();
        panelLegend.revalidate();
    }

    public void addData(ModelChart data) {
        model.add(data);
        blankPlotChart.setLabelCount(model.size());
        double max = data.getMaxValues();
        if (max > blankPlotChart.getMaxValues()) {
            blankPlotChart.setMaxValues(max);
        }
    }

    public void clear() {
        animate = 0;
        blankPlotChart.setLabelCount(0);
        model.clear();
        repaint();
    }

    public void start() {
        if (!animator.isRunning()) {
            animator.start();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        blankPlotChart = new swing.barchart.blankchart.BlankPlotChart();
        panelLegend = new javax.swing.JPanel();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(blankPlotChart, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addComponent(panelLegend, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(blankPlotChart, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelLegend, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.barchart.blankchart.BlankPlotChart blankPlotChart;
    private javax.swing.JPanel panelLegend;
    // End of variables declaration//GEN-END:variables
}
