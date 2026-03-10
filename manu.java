
import java.awt.*;
import java.net.URI;
import javax.swing.*;

public class manu extends JFrame {

    public manu() {
        initComponents();
    }

    private void initComponents() {
        jPanel2 = new JPanel();
        jButton2 = new JButton();
        jButton1 = new JButton();
        siteLink = new JLabel();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jPanel3 = new JPanel();
        jLabel2 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("DIGITAL STEGANOGRAPHY");

        jPanel2.setBackground(new Color(153, 153, 153));
        jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.Y_AXIS));

        jPanel1.setBackground(new Color(46, 46, 46));
        jLabel1.setFont(new java.awt.Font("Arial", Font.BOLD, 36)); // Use common font
        jLabel1.setForeground(new Color(254, 254, 254));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("DIGITAL STEGANOGRAPHY");
        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel1);
        jPanel2.add(Box.createVerticalStrut(30));

        jButton2.setBackground(new Color(223, 223, 223));
        jButton2.setFont(new java.awt.Font("Arial", Font.BOLD, 32));
        jButton2.setForeground(new Color(32, 32, 32));
        jButton2.setText("ENCODE");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(evt -> {
            // Call Encryption
            try {
                new Encryption().setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Encryption functionality not implemented!");
            }
        });

        jPanel2.add(jButton2);
        jPanel2.add(Box.createVerticalStrut(30));

        jButton1.setBackground(new Color(224, 227, 225));
        jButton1.setFont(new java.awt.Font("Arial", Font.BOLD, 32));
        jButton1.setForeground(new Color(23, 23, 23));
        jButton1.setText("DECODE");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(evt -> {
            // Call Decryption
            try {
                new Descryption().setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Decryption functionality not implemented!");
            }
        });

        jPanel2.add(jButton1);
        jPanel2.add(Box.createVerticalStrut(20));

        // Add a clickable site link
        siteLink.setFont(new java.awt.Font("Arial", Font.PLAIN, 18));
        siteLink.setForeground(Color.BLUE.darker());
        siteLink.setText("<html><u>Visit our website</u></html>");
        siteLink.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        siteLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openWebPage("https://yourwebsite.com");
            }
        });

        jPanel2.add(siteLink);
        jPanel2.add(Box.createVerticalStrut(20));

        jPanel3.setBackground(new Color(0, 102, 102));
        jLabel2.setFont(new java.awt.Font("Tahoma", Font.BOLD, 25));
        jLabel2.setForeground(Color.WHITE);
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText("DESIGNED AND DEVELOPED BY \"Sachin Chauhan\"");
        jPanel3.setLayout(new java.awt.BorderLayout());
        jPanel3.add(jLabel2, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3);

        getContentPane().setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        setSize(729, 484);
        setLocationRelativeTo(null);
    }

    private void openWebPage(String url) {
        try {
            URI uri = new URI(url);
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(uri);
            } else {
                JOptionPane.showMessageDialog(this, "Desktop browsing is not supported on your system.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to open website: " + e.getMessage());
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new manu().setVisible(true));
    }

    private JButton jButton1;
    private JButton jButton2;
    private JLabel siteLink;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
}
