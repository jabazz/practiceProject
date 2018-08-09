package awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GuiFrame {
	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;
	private TextField url;

	public GuiFrame() {
		prepareGUI();
	}

	public static void main(String[] args) {
		GuiFrame awtControlDemo = new GuiFrame();
		awtControlDemo.showEventDemo();
	}

	private void prepareGUI() {
		mainFrame = new Frame("Java AWT Examples");
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(new GridLayout(3, 1));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		headerLabel = new Label();
		headerLabel.setAlignment(Label.CENTER);
		statusLabel = new Label();
		statusLabel.setAlignment(Label.CENTER);
		statusLabel.setSize(350, 100);

		controlPanel = new Panel();
		controlPanel.setLayout(new FlowLayout());

		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);
	}

	private void showEventDemo() {
		headerLabel.setText("Control in action: Button");

		url = new TextField();
		Rectangle rec = new Rectangle(100, 2);
		url.setBounds(rec);
		url.setEditable(true);
		Button hitButton = new Button("HIT URL");
		hitButton.setActionCommand("hit");
		hitButton.addActionListener(new ButtonClickListener());
		controlPanel.add(url);
		controlPanel.add(hitButton);
		mainFrame.setVisible(true);
	}

	private class ButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command.equals("hit")) {
				statusLabel.setText(RestServiceClient.callAPI(url.getText()));
			}
		}
	}
}
