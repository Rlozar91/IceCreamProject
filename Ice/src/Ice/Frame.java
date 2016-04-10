package Ice;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Frame {
	private JFrame mainFrame;
	private JFrame saveFrame;
	private JLabel saveLabel;

	private JRadioButton vanillaIceCreamButton;
	private JRadioButton chocolateIceCreamButton;
	private JRadioButton strawberryIceCreamButton;
	private JRadioButton chocolateSyrupButton;
	private JRadioButton caramelSyrupButton;
	private JRadioButton noneSyrupButton;
	private JCheckBox nutsCheckBox;
	private JCheckBox cherriesCheckBox;
	private JButton totalButton;
	private JButton saveButton;
	private JButton openButton;
	private JButton saveYesButton;
	private JButton saveNoButton;
	private JRadioButton oneScoopButton;
	private JRadioButton twoScoopButton;
	private JRadioButton threeScoopButton;

	private JPanel scoopsPanel;
	private JPanel savePanel;
	private JPanel iceCreamPanel;
	private JPanel syrupPanel;
	private JPanel nutsAndCherriesPanel;
	private JPanel totalSaveOpenPanel;
	private ButtonGroup iceCreamButtonGroup;
	private ButtonGroup syrupButtonGroup;
	private ButtonGroup scoopsButtonGroup;
	private DecimalFormat formatter = new DecimalFormat("$0.00");
	private Scanner scanner;
	private String fileLine;
	private File file = new File("order.txt");

	public Frame() {
		formatter.setRoundingMode(RoundingMode.UP);
		vanillaIceCreamButton = new JRadioButton("Vanilla");
		chocolateIceCreamButton = new JRadioButton("Chocolate");
		strawberryIceCreamButton = new JRadioButton("Strawberry");

		oneScoopButton = new JRadioButton("One");
		twoScoopButton = new JRadioButton("Two");
		threeScoopButton = new JRadioButton("Three");

		chocolateSyrupButton = new JRadioButton("Chocolate");
		caramelSyrupButton = new JRadioButton("Caramel");
		noneSyrupButton = new JRadioButton("None");

		nutsCheckBox = new JCheckBox("Nuts?");
		cherriesCheckBox = new JCheckBox("Cherries?");

		totalButton = new JButton("Total");
		saveButton = new JButton("Save");
		openButton = new JButton("Open");

		iceCreamPanel = new JPanel();
		syrupPanel = new JPanel();
		scoopsPanel = new JPanel();
		nutsAndCherriesPanel = new JPanel();
		totalSaveOpenPanel = new JPanel();

		iceCreamButtonGroup = new ButtonGroup();
		scoopsButtonGroup = new ButtonGroup();
		syrupButtonGroup = new ButtonGroup();

		iceCreamButtonGroup.add(vanillaIceCreamButton);
		iceCreamButtonGroup.add(chocolateIceCreamButton);
		iceCreamButtonGroup.add(strawberryIceCreamButton);

		syrupButtonGroup.add(chocolateSyrupButton);
		syrupButtonGroup.add(caramelSyrupButton);
		syrupButtonGroup.add(noneSyrupButton);

		scoopsButtonGroup.add(oneScoopButton);
		scoopsButtonGroup.add(twoScoopButton);
		scoopsButtonGroup.add(threeScoopButton);

		iceCreamPanel.add(vanillaIceCreamButton);
		iceCreamPanel.add(chocolateIceCreamButton);
		iceCreamPanel.add(strawberryIceCreamButton);

		scoopsPanel.add(oneScoopButton);
		scoopsPanel.add(twoScoopButton);
		scoopsPanel.add(threeScoopButton);

		syrupPanel.add(chocolateSyrupButton);
		syrupPanel.add(caramelSyrupButton);
		syrupPanel.add(noneSyrupButton);

		nutsAndCherriesPanel.add(nutsCheckBox);
		nutsAndCherriesPanel.add(cherriesCheckBox);

		totalSaveOpenPanel.add(totalButton);
		totalSaveOpenPanel.add(saveButton);
		totalSaveOpenPanel.add(openButton);

		scoopsPanel.setBorder(BorderFactory.createTitledBorder("Scoops"));
		scoopsPanel.setPreferredSize(new Dimension(274, 50));

		iceCreamPanel.setBorder(BorderFactory.createTitledBorder("Ice Cream Flavors"));
		iceCreamPanel.setPreferredSize(new Dimension(274, 50));

		syrupPanel.setBorder(BorderFactory.createTitledBorder("Syrup Flavor"));
		syrupPanel.setPreferredSize(new Dimension(274, 50));

		nutsAndCherriesPanel.setBorder(BorderFactory.createTitledBorder("Nuts and Cherries"));
		nutsAndCherriesPanel.setPreferredSize(new Dimension(274, 50));

		mainFrame = new JFrame("Ice Cream Orders");
		mainFrame.setSize(350, 310);
		mainFrame.getContentPane().setLayout(new FlowLayout());
		mainFrame.getContentPane().add(iceCreamPanel);
		mainFrame.getContentPane().add(scoopsPanel);
		mainFrame.getContentPane().add(syrupPanel);
		mainFrame.getContentPane().add(nutsAndCherriesPanel);
		mainFrame.getContentPane().add(totalSaveOpenPanel);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		saveButton.addActionListener(new SaveButtonListener());
		totalButton.addActionListener(new TotalButtonListener());
		openButton.addActionListener(new OpenButtonListener());
	}

	private class SaveButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == saveButton) {
				createSaveFrame();
			}

		}

	}

	public void createSaveFrame() {

		saveLabel = new JLabel("Are you sure you want to save?");

		saveYesButton = new JButton("Yes");
		saveNoButton = new JButton("No");
		savePanel = new JPanel();
		savePanel.add(saveYesButton);
		savePanel.add(saveNoButton);
		saveFrame = new JFrame("Save");
		saveFrame.setSize(300, 100);
		saveFrame.setLayout(new FlowLayout());
		saveFrame.add(saveLabel);
		saveFrame.getContentPane().add(savePanel);
		saveFrame.setVisible(true);
		saveNoButton.addActionListener(new SaveNoListener());
		saveYesButton.addActionListener(new SaveYesListener());

	}

	private class SaveNoListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == saveNoButton) {
				saveFrame.dispose();
			}

		}

	}

	private class TotalButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == totalButton) {
				Calculator calculator = new Calculator();
				if (vanillaIceCreamButton.isSelected()) {
					calculator.setVanilla(true);
				}
				if (chocolateIceCreamButton.isSelected()) {
					calculator.setChocolate(true);
				}
				if (strawberryIceCreamButton.isSelected()) {
					calculator.setStrawberry(true);
				}
				if (chocolateSyrupButton.isSelected()) {
					calculator.setChocolateSyrup(true);
				}
				if (caramelSyrupButton.isSelected()) {
					calculator.setCaramelSyrup(true);
				}
				if (nutsCheckBox.isSelected()) {
					calculator.setNuts(true);
				}
				if (cherriesCheckBox.isSelected()) {
					calculator.setCherries(true);
				}
				calculator.calculate();
				calculator.calculateTotalPrice();
				JOptionPane.showMessageDialog(null,
						"Total: " + formatter.format(calculator.getTotalPrice()) + " ( "
								+ formatter.format(calculator.getPrice()) + " + "
								+ formatter.format(calculator.getTaxCost()) + " tax )");

			}

		}

	}

	private class SaveYesListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == saveYesButton) {
				Calculator calculator = new Calculator();
				Receipt receipt = new Receipt();
				if (vanillaIceCreamButton.isSelected()) {
					calculator.setVanilla(true);
					receipt.setIceCreamString("Vanilla");
				}
				if (chocolateIceCreamButton.isSelected()) {
					calculator.setChocolate(true);
					receipt.setIceCreamString("Chocolate");
				}
				if (strawberryIceCreamButton.isSelected()) {
					calculator.setStrawberry(true);
					receipt.setIceCreamString("Strawberry");
				}
				if (chocolateSyrupButton.isSelected()) {
					calculator.setChocolateSyrup(true);
					receipt.setSyrupString("Chocolate Syrup");
				}
				if (caramelSyrupButton.isSelected()) {
					calculator.setCaramelSyrup(true);
					receipt.setSyrupString("Caramel Syrup");
				}
				if (noneSyrupButton.isSelected()) {
					receipt.setSyrupString("No Syrup");
				}
				if (nutsCheckBox.isSelected()) {
					calculator.setNuts(true);
					receipt.setNutsString("With Nuts");

				} else {
					receipt.setNutsString("Without Nuts");
				}
				if (cherriesCheckBox.isSelected()) {
					calculator.setCherries(true);
					receipt.setCherriesString("With Cherries");
				} else {
					receipt.setCherriesString("Without Cherries");
				}
				if (oneScoopButton.isSelected()) {
					receipt.setScoopsString("One Scoop");
				}
				if (twoScoopButton.isSelected()) {
					receipt.setScoopsString("Two Scoops");
				}
				if (threeScoopButton.isSelected()) {
					receipt.setScoopsString("Three Scoops");
				}
				calculator.calculate();
				calculator.calculateTotalPrice();
				receipt.setTotalPrice(calculator.getTotalPrice());
				try {
					receipt.saveReceipt();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				saveFrame.dispose();
			}
		}

	}

	private class OpenButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == openButton) {
				try {
					scanner = new Scanner(file);
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "File Not Found!");
					e1.printStackTrace();
				}
				while (scanner.hasNext()) {
					fileLine = scanner.nextLine();

					if (fileLine.equalsIgnoreCase("Vanilla")) {
						vanillaIceCreamButton.setSelected(true);
					}
					if (fileLine.equalsIgnoreCase("Chocolate")) {
						chocolateIceCreamButton.setSelected(true);
					}
					if (fileLine.equalsIgnoreCase("Strawberry")) {
						strawberryIceCreamButton.setSelected(true);
					}
					if (fileLine.equalsIgnoreCase("One Scoop")) {
						oneScoopButton.setSelected(true);
					}
					if (fileLine.equalsIgnoreCase("Two Scoops")) {
						twoScoopButton.setSelected(true);
					}
					if (fileLine.equalsIgnoreCase("Three Scoops")) {
						threeScoopButton.setSelected(true);
					}
					if (fileLine.equalsIgnoreCase("Chocolate Syrup")) {
						chocolateSyrupButton.setSelected(true);
					}
					if (fileLine.equalsIgnoreCase("Caramel Syrup")) {
						caramelSyrupButton.setSelected(true);
					}
					if (fileLine.equalsIgnoreCase("No Syrup")) {
						noneSyrupButton.setSelected(true);
					}
					if (fileLine.equalsIgnoreCase("With Nuts")) {
						nutsCheckBox.setSelected(true);
					}
					if (fileLine.equalsIgnoreCase("With Cherries")) {
						cherriesCheckBox.setSelected(true);
					}
				}
			}
		}
	}
}
