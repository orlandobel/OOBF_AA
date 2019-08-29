/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

import static org.jfree.chart.ChartFactory.createXYLineChart;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Odi
 */
public class Grafica {
    
    private JFreeChart grafica;
    
    private XYSeriesCollection series;
    private String ejeX,ejeY,titulo;
    
    public Grafica(String ejeX,String ejeY, String titulo) {
        this.grafica = null;
        this.series = new XYSeriesCollection();
        this.titulo = titulo;
        this.ejeX = ejeX;
        this.ejeY = ejeY;
    }
    
    public void agregarSerie(double[] datos, String id) {
        XYSeries serie = new XYSeries(id);
        
        for(int i=0;i<datos.length;i++) {
            serie.add(i, datos[i]);
        }
        this.series.addSeries(serie);
    }
    
    public void agregarSerie(Double[] datos, String id) {
        XYSeries serie = new XYSeries(id);
        
        for(int i=0;i<datos.length;i++) {
            serie.add(i, datos[i]);
        }
        this.series.addSeries(serie);
    }
    
    public void creaYmuetraGrafica() {
        grafica = createXYLineChart(titulo,ejeX,ejeY,series);
        ChartFrame panel = new ChartFrame(titulo, grafica);
        panel.pack();
        panel.setVisible(true);
    }
    
}
