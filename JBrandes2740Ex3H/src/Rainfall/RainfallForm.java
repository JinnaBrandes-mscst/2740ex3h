package Rainfall;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class RainfallForm extends JFrame {

	private JPanel contentPane;
	private JList rainfallList;
	private JLabel totalLabel;
	private JLabel averageLabel;
	private JLabel maxLabel;
	private JLabel minLabel;
	private JButton updateBtn;
	private JButton calcBtn;
	private String [] strRainfall = {
			"2.2", "4.2", "1.8", "5.1", "6.1", "2.8", "1.2", "3.5", "5.5", "2.7", "1.4", "6.9"};
	private JTextField inputMonthTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RainfallForm frame = new RainfallForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RainfallForm() {
		setTitle("JBrandes Ex3H Rainfall");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMonthlyRainfall = new JLabel("Monthly Rainfall");
		lblMonthlyRainfall.setBounds(10, 11, 85, 14);
		contentPane.add(lblMonthlyRainfall);
		
		JList monthlist = new JList();
		monthlist.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		monthlist.setEnabled(false);
		monthlist.setModel(new AbstractListModel() {
			String[] values = new String[] {"01 Jan", "02 Feb", "03 Mar", "04 Apr", "05 May", "06 Jun", "07 Jul", "08 Aug", "09 Sep", "10 Oct", "11 Nov", "12 Dec"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		monthlist.setBounds(20, 36, 44, 223);
		contentPane.add(monthlist);
		
		rainfallList = new JList(strRainfall);
		rainfallList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				do_rainfallList_valueChanged(e);
			}
		});
		rainfallList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		rainfallList.setBounds(74, 36, 85, 223);
		contentPane.add(rainfallList);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(185, 37, 69, 14);
		contentPane.add(lblTotal);
		
		JLabel lblAverage = new JLabel("Average:");
		lblAverage.setBounds(185, 75, 69, 14);
		contentPane.add(lblAverage);
		
		JLabel lblMaximun = new JLabel("Maximun:");
		lblMaximun.setBounds(185, 110, 69, 14);
		contentPane.add(lblMaximun);
		
		JLabel lblMinimum = new JLabel("Minimum:");
		lblMinimum.setBounds(185, 145, 69, 14);
		contentPane.add(lblMinimum);
		
		totalLabel = new JLabel("0.0");
		totalLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totalLabel.setBounds(267, 32, 69, 24);
		contentPane.add(totalLabel);
		
		averageLabel = new JLabel("0.0");
		averageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		averageLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		averageLabel.setBounds(267, 70, 69, 24);
		contentPane.add(averageLabel);
		
		maxLabel = new JLabel("0.0");
		maxLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		maxLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		maxLabel.setBounds(267, 105, 69, 24);
		contentPane.add(maxLabel);
		
		minLabel = new JLabel("0.0");
		minLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		minLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		minLabel.setBounds(267, 140, 69, 24);
		contentPane.add(minLabel);
		
		updateBtn = new JButton("Update");
		updateBtn.setEnabled(false);
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_updateBtn_actionPerformed(e);
			}
		});
		updateBtn.setBounds(70, 308, 89, 23);
		contentPane.add(updateBtn);
		
		calcBtn = new JButton("Calculate");
		calcBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_calcBtn_actionPerformed(e);
			}
		});
		calcBtn.setBounds(267, 205, 89, 23);
		contentPane.add(calcBtn);
		
		inputMonthTextField = new JTextField();
		inputMonthTextField.addFocusListener(new FocusAdapter() {
			
		});
		inputMonthTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		inputMonthTextField.setText("0.0");
		inputMonthTextField.setBounds(74, 277, 86, 20);
		contentPane.add(inputMonthTextField);
		inputMonthTextField.setColumns(10);
	}
	protected void do_calcBtn_actionPerformed(ActionEvent e) {
		Rainfall rainfallData = new Rainfall(strRainfall);

		DecimalFormat fmt = new DecimalFormat("0.0");
		totalLabel.setText(fmt.format(rainfallData.getTotal()));		
		averageLabel.setText(fmt.format(rainfallData.getAverage()));		
		maxLabel.setText(fmt.format(rainfallData.getHighest()));		
		minLabel.setText(fmt.format(rainfallData.getLowest()));
	}
	protected void do_updateBtn_actionPerformed(ActionEvent e) {
		int selectedIndex = rainfallList.getSelectedIndex();
		double r = Double.parseDouble(inputMonthTextField.getText());
		strRainfall[selectedIndex] = Double.toString(r);
		rainfallList.repaint();

		inputMonthTextField.setText("0.0");
		updateBtn.setEnabled(false);
		totalLabel.setText("0.0");
		averageLabel.setText("0.0");
		maxLabel.setText("0.0");
		minLabel.setText("0.0");
	}
	protected void do_rainfallList_valueChanged(ListSelectionEvent e) {
		updateBtn.setEnabled(true);
		inputMonthTextField.setText((String) rainfallList.getSelectedValue());
		inputMonthTextField.requestFocus();
		inputMonthTextField.selectAll();
		
		
	}
	
}
