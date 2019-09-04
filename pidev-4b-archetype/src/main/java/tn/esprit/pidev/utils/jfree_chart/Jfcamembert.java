package tn.esprit.pidev.utils.jfree_chart;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sana
 */
import java.awt.Font;

import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class Jfcamembert extends JFrame {

    private static final long serialVersionUID = 1L;
    private DefaultPieDataset dataset;
    private static JFreeChart jfc;

    public Jfcamembert() {
        dataset = new DefaultPieDataset();
    }

    public void setValue(String title, Double numDouble) {
        dataset.setValue(title, numDouble);
    }

    public void setChar(String title) {
        jfc = ChartFactory.createPieChart(title, dataset, true, true, false);

        PiePlot pp = (PiePlot) jfc.getPlot();
        //pp.setSectionOutlinesVisible(false);
        pp.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        pp.setNoDataMessage(" no data ");
        pp.setCircular(true);



    }

    private JPanel createPanel() {
        return new ChartPanel(jfc);
    }

    public void Show() {
        setContentPane(createPanel());
        setVisible(true);
    }

    public static void main(String[] args) {
        Connexion con = new Connexion();
        Jfcamembert j = new Jfcamembert();


        double d;
        String ch;


        j.setTitle("Part marhcé Os Mobile");
        j.setSize(640, 430);

//		j.setValue("Android", new Double(20.0));
//		j.setValue("Iphone", new Double(30.0));
//		j.setValue("BlackBerry", new Double(20.0));
//		j.setValue("Windows phone", new Double(10.0));
//		j.setValue("autre", new Double(20.0));
//                j.setValue("tizen", new Double(2.2));

        j.setChar("statistiques");

        j.Show();


        try {
            Connexion.rs = Connexion.st.executeQuery("select * from personne");
            while (Connexion.rs.next()) {
                d = Connexion.rs.getDouble(1);
                ch = Connexion.rs.getString(2);
                System.out.println("" + d);
                System.out.println("" + ch);
                j.setValue(ch, d);
            }

        } catch (SQLException ex) {
            System.out.println(" ");
        }
        //Saugarder le graphique
        try {
            ChartUtilities.saveChartAsJPEG(new File("C:\\chart.jpg"), jfc, 500, 300);
        } catch (Exception e) {
            System.out.println("Problem occurred creating chart.");
        }

    }
}
