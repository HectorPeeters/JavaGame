package resources;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class ResourceWindow extends JPanel {
	private static final long serialVersionUID = 1L;

	private static JList<String> list;

	private static DefaultListModel<String> model;

	public ResourceWindow() {
		setLayout(new BorderLayout());
		model = new DefaultListModel<String>();
		list = new JList<String>(model);
		JScrollPane pane = new JScrollPane(list);
		JLabel label = new JLabel("Resources");
		label.setFont(new Font("Tahoma", Font.PLAIN, 29));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		add(label, BorderLayout.NORTH);
		add(pane, BorderLayout.CENTER);
	}

	public static void createWindow() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new ResourceWindow());
		frame.setSize(200, 400);
		frame.setLocation(1200, 200);
		frame.setVisible(true);
	}

	public static void updateList(Map<String, Integer> resources) {
		model.clear();
		for (Map.Entry<String, Integer> resource : resources.entrySet())
			model.addElement(resource.getValue() + ": " + resource.getKey());
	}
}
