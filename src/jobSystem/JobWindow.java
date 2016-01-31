package jobSystem;

import jobSystem.Jobs.JobType;
import math.Vector2i;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class JobWindow extends JFrame {
    private static final long serialVersionUID = 1L;

    private static JComboBox<Jobs.JobType> comboBox;

    public static void openJobWindow() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JobWindow frame = new JobWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public JobWindow() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 262, 98);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setResizable(false);
        setContentPane(contentPane);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(Jobs.JobType.values()));
        contentPane.add(comboBox, BorderLayout.CENTER);

        JLabel lblJobs = new JLabel("Jobs");
        lblJobs.setFont(new Font("Tahoma", Font.PLAIN, 29));
        lblJobs.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblJobs, BorderLayout.NORTH);
    }

    public static Job getSelectedJob(Vector2i mousePos) {
        if (comboBox == null)
            openJobWindow();
        return Jobs.getJob((JobType) comboBox.getSelectedItem(), mousePos);
    }

}
