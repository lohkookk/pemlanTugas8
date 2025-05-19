import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DaftarUlangMahasiswa extends JFrame {
    private JTextField tfNama, tfTanggalLahir, tfNoPendaftaran, tfNoTelp, tfAlamat, tfEmail;
    private JButton btnSubmit;

    public DaftarUlangMahasiswa() {
        setTitle("Form Daftar Ulang Mahasiswa Baru");
        setSize(400, 350);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        JLabel lblNama = new JLabel("Nama Lengkap");
        tfNama = new JTextField(20);
        
        JLabel lblTanggalLahir = new JLabel("Tanggal Lahir");
        tfTanggalLahir = new JTextField(20);
        
        JLabel lblNoPendaftaran = new JLabel("Nomor Pendaftaran");
        tfNoPendaftaran = new JTextField(20);
        
        JLabel lblNoTelp = new JLabel("No. Telp");
        tfNoTelp = new JTextField(20);
        
        JLabel lblAlamat = new JLabel("Alamat");
        tfAlamat = new JTextField(20);
        tfAlamat.setPreferredSize(new Dimension(200, 40));
        
        JLabel lblEmail = new JLabel("E-mail");
        tfEmail = new JTextField(20);
        
        btnSubmit = new JButton("Submit");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); 

        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
        add(lblNama, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        add(tfNama, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        add(lblTanggalLahir, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        add(tfTanggalLahir, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        add(lblNoPendaftaran, gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        add(tfNoPendaftaran, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        add(lblNoTelp, gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        add(tfNoTelp, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        add(lblAlamat, gbc);
        gbc.gridx = 1; gbc.gridy = 4;
        add(tfAlamat, gbc);

        gbc.gridx = 0; gbc.gridy = 5;
        add(lblEmail, gbc);
        gbc.gridx = 1; gbc.gridy = 5;
        add(tfEmail, gbc);

        gbc.gridx = 1; 
        gbc.gridy = 6; 
        gbc.anchor = GridBagConstraints.EAST; 
        add(btnSubmit, gbc);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfNama.getText().isEmpty() || tfTanggalLahir.getText().isEmpty() || tfNoPendaftaran.getText().isEmpty() ||
                    tfNoTelp.getText().isEmpty() || tfAlamat.getText().isEmpty() || tfEmail.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                } else {
                    int pilihan = JOptionPane.showConfirmDialog(null, "Apakah anda yakin data yang Anda isi sudah benar?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION);
                    if (pilihan == JOptionPane.OK_OPTION) {
                        String data = 
                                      "Nama             : " + tfNama.getText() + "\n" +
                                      "Tanggal Lahir    : " + tfTanggalLahir.getText() + "\n" +
                                      "Nomor Pendaftaran: " + tfNoPendaftaran.getText() + "\n" +
                                      "No.Telp          : " + tfNoTelp.getText() + "\n" +
                                      "Alamat           : " + tfAlamat.getText() + "\n" +
                                      "E-mail           : " + tfEmail.getText();

                        showFormattedDataDialog(data);
                    }
                }
            }
        });
    }

    private void showFormattedDataDialog(String data) {
        JDialog dataDialog = new JDialog(this, "Data Mahasiswa", true);
        dataDialog.setLayout(new BorderLayout());
        dataDialog.getContentPane().setBackground(new Color(45, 45, 45));
    
        // Judul
        JLabel titleLabel = new JLabel("Data Mahasiswa", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(30, 30, 30));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
    
        // JTextArea lebih lebar
        JTextArea dataArea = new JTextArea(10, 45); // 45 kolom = lebih lebar
        dataArea.setText(data);
        dataArea.setEditable(false);
        dataArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        dataArea.setBackground(new Color(60, 63, 65));
        dataArea.setForeground(Color.WHITE);
        dataArea.setCaretPosition(0);
        dataArea.setLineWrap(true);
        dataArea.setWrapStyleWord(true);
        dataArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dataArea.setPreferredSize(new Dimension(500, 200)); // Ukuran lebih lebar
    
        // Panel tengah dengan GridBagLayout dan padding simetris
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(new Color(45, 45, 45));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 30, 30, 30); // Padding kiri-kanan-bawah
        centerPanel.add(dataArea, gbc);
    
        // Tombol
        JButton closeButton = new JButton("Tutup");
        closeButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        closeButton.setFocusPainted(false);
        closeButton.setBackground(new Color(100, 100, 100));
        closeButton.setForeground(Color.WHITE);
        closeButton.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
        closeButton.addActionListener(e -> dataDialog.dispose());
    
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(45, 45, 45));
        buttonPanel.add(closeButton);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    
        // Tambahkan komponen
        dataDialog.add(titleLabel, BorderLayout.NORTH);
        dataDialog.add(centerPanel, BorderLayout.CENTER);
        dataDialog.add(buttonPanel, BorderLayout.SOUTH);
    
        dataDialog.setSize(600, 400); // Ukuran dialog diperbesar sesuai area teks
        dataDialog.setLocationRelativeTo(this);
        dataDialog.setVisible(true);
    }
            
    
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DaftarUlangMahasiswa().setVisible(true);
            }
        });
    }
}
