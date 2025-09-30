/*
package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

interface Notification {
    void send(String message);
    void getStatus();
}

class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        JOptionPane.showMessageDialog(null, "Sending Email: " + message);
    }
    @Override
    public void getStatus() {
        JOptionPane.showMessageDialog(null, "Status: Delivered via Email");
    }
}

class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        JOptionPane.showMessageDialog(null, "Sending SMS: " + message);
    }
    @Override
    public void getStatus() {
        JOptionPane.showMessageDialog(null, "Status: Delivered via SMS");
    }
}

class PushNotification implements Notification {
    @Override
    public void send(String message) {
        JOptionPane.showMessageDialog(null, "Sending Push Notification: " + message);
    }
    @Override
    public void getStatus() {
        JOptionPane.showMessageDialog(null, "Status: Delivered via Push Notification");
    }
}

class NotificationService {
    void notifyCustomer(Notification notification, String message) {
        notification.send(message);
        notification.getStatus();
    }
}

public class NotificationUI extends JFrame {
    private JRadioButton emailBtn, smsBtn, pushBtn;
    private JTextArea messageArea;
    private JButton sendBtn, clearBtn;
    private JLabel statusLabel, header;
    private Color headerColor = new Color(0, 255, 255); // neon cyan
    private int colorStep = 5;

    NotificationService service = new NotificationService();

    public NotificationUI() {
        setTitle("Notification System - Dark Theme");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Dark gradient background
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(20, 20, 20), getWidth(), getHeight(), new Color(5, 5, 5));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        backgroundPanel.setLayout(new BorderLayout());
        add(backgroundPanel);

        // Top Panel
        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false);
        header = new JLabel("Select Notification Method");
        header.setFont(new Font("Arial", Font.BOLD, 18));
        header.setForeground(headerColor);
        topPanel.add(header);
        backgroundPanel.add(topPanel, BorderLayout.NORTH);

        // Center Panel
        JPanel centerPanel = new JPanel(new GridLayout(5, 1, 5, 5));
        centerPanel.setOpaque(false);
        ButtonGroup group = new ButtonGroup();

        emailBtn = new JRadioButton("Email");
        smsBtn = new JRadioButton("SMS");
        pushBtn = new JRadioButton("Push Notification");

        styleRadio(emailBtn);
        styleRadio(smsBtn);
        styleRadio(pushBtn);

        group.add(emailBtn);
        group.add(smsBtn);
        group.add(pushBtn);

        centerPanel.add(emailBtn);
        centerPanel.add(smsBtn);
        centerPanel.add(pushBtn);

        messageArea = new JTextArea(" ");
        messageArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
        messageArea.setBackground(new Color(40, 40, 40));
        messageArea.setForeground(Color.WHITE);
        messageArea.setCaretColor(Color.CYAN);
        centerPanel.add(new JScrollPane(messageArea));

        backgroundPanel.add(centerPanel, BorderLayout.CENTER);

        // Bottom Panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setOpaque(false);

        sendBtn = new JButton("Send Notification");
        styleButton(sendBtn, new Color(0, 123, 255)); // blue

        clearBtn = new JButton("Clear");
        styleButton(clearBtn, new Color(200, 50, 50)); // red

        statusLabel = new JLabel("Status: Waiting...");
        statusLabel.setForeground(Color.LIGHT_GRAY);

        bottomPanel.add(sendBtn);
        bottomPanel.add(clearBtn);
        bottomPanel.add(statusLabel);

        backgroundPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Send button logic
        sendBtn.addActionListener(e -> {
            String message = messageArea.getText().trim();
            if (message.isEmpty() || message.equals(" ")) {
                JOptionPane.showMessageDialog(null, "Please enter a message!");
                return;
            }

            if (emailBtn.isSelected()) {
                service.notifyCustomer(new EmailNotification(), message);
                statusLabel.setText("Sent via Email");
                statusLabel.setForeground(new Color(0, 191, 255));
            } else if (smsBtn.isSelected()) {
                service.notifyCustomer(new SMSNotification(), message);
                statusLabel.setText("Sent via SMS");
                statusLabel.setForeground(new Color(50, 205, 50));
            } else if (pushBtn.isSelected()) {
                service.notifyCustomer(new PushNotification(), message);
                statusLabel.setText("Sent via Push Notification");
                statusLabel.setForeground(new Color(255, 215, 0));
            } else {
                JOptionPane.showMessageDialog(null, "Please select a notification type!");
                return;
            }

            pulseButton(sendBtn);

            // Clear old message automatically
            messageArea.setText("");
        });

        // Clear button logic
        clearBtn.addActionListener(e -> {
            messageArea.setText("");
            statusLabel.setText("Status: Waiting...");
            statusLabel.setForeground(Color.LIGHT_GRAY);
        });

        // Animate header color
        Timer colorTimer = new Timer(50, e ->animateHeaderColor());
        colorTimer.start();

        setLocationRelativeTo(null); //setLocationRelativeTo(null);(Use to lotion )
        setVisible(true);
    }

    private void styleRadio(JRadioButton btn) {
        btn.setOpaque(false);
        btn.setForeground(Color.LIGHT_GRAY);
    }

    private void styleButton(JButton btn, Color color) {
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
    }

    private void animateHeaderColor() {
        int r = headerColor.getRed() + colorStep;
        if (r > 255 || r < 0) colorStep = -colorStep;
        headerColor = new Color(Math.abs(r % 256), 255 - (r % 256), 255);
        header.setForeground(headerColor);
        repaint();
    }

    private void pulseButton(JButton button) {
        Timer pulse = new Timer(50, new ActionListener() {
            int alpha = 0;
            boolean increasing = true;
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setBackground(new Color(button.getBackground().getRed(), button.getBackground().getGreen(), button.getBackground().getBlue(), alpha));
                if (increasing) alpha += 25; else alpha -= 25;
                if (alpha >= 255) increasing = false;
                if (alpha <= 150) {
                    ((Timer) e.getSource()).stop();
                    button.setBackground(new Color(button.getBackground().getRed(), button.getBackground().getGreen(), button.getBackground().getBlue()));
                }
            }
        });
        pulse.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NotificationUI::new);
    }
}
*/
