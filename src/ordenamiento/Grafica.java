/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;

/**
 *
 * @author CRUZLEIJA
 */
public class Grafica {
    
    // grafica 
    private JFreeChart grafica;
    // colección de series 
    private XYSeriesCollection series;
    private String ejeX,ejeY,titulo;
    
    public Grafica (String ejeX,String ejeY,String titulo){
        this.grafica = null;
        this.series = new XYSeriesCollection();
        this.titulo = titulo;
        this.ejeX = ejeX;
        this.ejeY = ejeY;
    } 
    
    public void agregarSerie(double[] datos, String id){
     // crear la serie
        XYSeries serie = new XYSeries(id);
        for(int x=0;x<datos.length;x++){
            serie.add(x, datos[x]);
        }
        this.series.addSeries(serie);
    
    }
        public void agregarSerie(Double[] datos, String id){
     // crear la serie
        XYSeries serie = new XYSeries(id);
        for(int x=0;x<datos.length;x++){
            serie.add(x, datos[x]);
        }
        this.series.addSeries(serie);
    }
    
    public void creaYmuestraGrafica(){
    
        this.grafica = ChartFactory.
                createXYLineChart(titulo, ejeX, ejeY, series);
        ChartFrame panel = new ChartFrame(titulo, grafica);


        panel.pack();
        panel.setVisible(true);
            
    }
    public void creaYmuestraGrafica(boolean trans){

        this.grafica = ChartFactory.
                createXYLineChart(titulo, ejeX, ejeY, series);
        ChartFrame panel = new ChartFrame(titulo, grafica);

        if(trans){
            Color cTrans= new Color(0xFF,0xFF,0xFF,0);
            this.grafica.setBackgroundPaint(cTrans);
            this.grafica.getPlot().setBackgroundPaint(cTrans);

        }

        panel.pack();
        panel.setVisible(true);

    }
    
}
