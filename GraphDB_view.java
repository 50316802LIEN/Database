package graphdb;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraphDB_view extends Frame implements ActionListener,WindowListener {

	
	DefaultCategoryDataset data;
	public  GraphDB_view(){
	addWindowListener(this);
	setTitle("Graph");
	
	data = new DefaultCategoryDataset();
	int id, score,year;
	String name;
	ResultSet rs;	
	MySQL mysql = new MySQL();
	rs = mysql.selectAll();
		
		try {
			while(rs.next()){	
				name = rs.getString("name");
				score = rs.getInt("score");
				year = rs.getInt("year");
				System.out.println("名前：" + name);
				System.out.println("得点：" + score);
				System.out.println("年：" + year);
				data.addValue(score, name, ""+year);
				}	
			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	
    JFreeChart chart = 
    						ChartFactory.createLineChart
    						("Import Volume",
                                   "Year",
                                   "Performance",
                                   data,
                                   PlotOrientation.VERTICAL,
                                   true,
                                   false,
                                   false);

    ChartPanel cpanel = new ChartPanel(chart);
    add(cpanel, BorderLayout.CENTER);
	}
	
	
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
              
