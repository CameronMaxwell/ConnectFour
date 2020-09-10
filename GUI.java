import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.WindowConstants;

public class GUI extends JFrame {
	
	private static Container contentPane;
	private int cellSize = 100;
	JLabel[][] labels;
	
	/**
	 * Constructor for GUI to set up the whole interface.
	 * @param numRows
	 * @param numCols
	 */
	public GUI (int numRows, int numCols) {
		super("Connect Four Game");
		
		contentPane = getContentPane();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);

		setSize(numCols*cellSize + 50, numRows*cellSize + 50);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		ImageIcon icon;
		labels = new JLabel[numRows][numCols];

		JLabel cell;
		//JButton cell;
		for (int j = 0; j < numCols; j++) {
			for (int i = 0; i < numRows; i++) {
				icon = scaleIcon("empty");
				cell = new JLabel(icon);
				
				//cell = new JButton(icon);
				cell.setSize(cellSize, cellSize);
				cell.setLocation(j*cellSize + 15, i*cellSize + 10);
				labels[i][j] = cell;
				contentPane.add(cell);
			}
		}
		
		addWindowListener(new WindowAdapter( ) {
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}                
		}); 
		contentPane.setFocusable(true);
		contentPane.requestFocusInWindow();
		revalidate();
		repaint();
	}
	
	/**
	 * Sets the image icon at the given row and column indices and updates the graphics.
	 * This method must be called from setElement() in ConnectGame.
	 * @param r
	 * @param c
	 * @param newType
	 */
	public void updateBoard (int r, int c, String newType) {
		ImageIcon icon = scaleIcon(newType);
		labels[r][c] .setIcon(icon);
		revalidate();
		repaint();
	}
	
	/**
	 * Loads the image corresponding to the given type parameter and scales the image.
	 * @param type
	 * @return
	 */
	private ImageIcon scaleIcon (String type) {
		
		String filename = "empty.png";
		if (type.equals("empty")) {
			filename = "empty.png";
		} else if (type.equals("red")) {
			filename = "checker_red.png";
		} else if (type.equals("blue")) {
			filename = "checker_blue.png";
		} else {
			System.out.println("Invalid image type");
		}
		
		// Load checker icons.
		ImageIcon icon = new ImageIcon(filename);
		Image img = icon.getImage();
		Image scaledImage = img.getScaledInstance(cellSize, cellSize, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(scaledImage);
		
		return icon;
	}

}
