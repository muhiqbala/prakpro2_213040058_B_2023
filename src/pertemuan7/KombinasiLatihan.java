package pertemuan7;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class KombinasiLatihan extends JFrame {
    private JTextField textFieldNama;
    private JTextField textFieldNomorHP;
    private JRadioButton radioButtonLaki;
    private JRadioButton radioButtonPerempuan;
    private JCheckBox checkBoxWNA;
    private JTextArea textAreaAlamat;
    private JTable jTableBiodata;
    private DefaultTableModel tableModel;

    public KombinasiLatihan() {
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setTitle("Aplikasi Biodata");

        JLabel labelNama = new JLabel("Nama : ");
        labelNama.setBounds(15, 15, 350, 30);

        textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 45, 350, 30);

        JLabel labelNomorHP = new JLabel("Nomor HP : ");
        labelNomorHP.setBounds(15, 85, 350, 30);

        textFieldNomorHP = new JTextField();
        textFieldNomorHP.setBounds(15, 115, 350, 30);

        JLabel labelGender = new JLabel("Gender : ");
        labelGender.setBounds(15, 155, 350, 30);

        radioButtonLaki = new JRadioButton("Laki-laki");
        radioButtonLaki.setBounds(15, 185, 100, 30);

        radioButtonPerempuan = new JRadioButton("Perempuan");
        radioButtonPerempuan.setBounds(115, 185, 100, 30);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(radioButtonLaki);
        genderGroup.add(radioButtonPerempuan);

        checkBoxWNA = new JCheckBox("Warga Negara Asing");
        checkBoxWNA.setBounds(15, 215, 200, 30);

        JLabel labelAlamat = new JLabel("Alamat : ");
        labelAlamat.setBounds(15, 255, 350, 30);

        textAreaAlamat = new JTextArea();
        textAreaAlamat.setBounds(15, 285, 350, 100);

        JButton buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(15, 400, 100, 40);

        JButton buttonEdit = new JButton("Edit");
        buttonEdit.setBounds(130, 400, 100, 40);

        JButton buttonHapus = new JButton("Hapus");
        buttonHapus.setBounds(245, 400, 100, 40);

        JButton buttonSimpanKeFile = new JButton("Simpan ke File");
        buttonSimpanKeFile.setBounds(360, 400, 150, 40);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nama");
        tableModel.addColumn("Jenis Kelamin");
        tableModel.addColumn("Nomor HP");
        tableModel.addColumn("Alamat");
        jTableBiodata = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(jTableBiodata);
        scrollPane.setBounds(525, 15, 400, 425);

        buttonSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String nomorHP = textFieldNomorHP.getText();
                String gender = radioButtonLaki.isSelected() ? "Laki-laki" :
                        radioButtonPerempuan.isSelected() ? "Perempuan" : "Tidak Diketahui";
                String alamat = textAreaAlamat.getText();

                if (nama.isEmpty() || nomorHP.isEmpty() || gender.isEmpty() || alamat.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Harap isi semua kolom input.");
                } else {
                    tableModel.addRow(new String[]{nama, gender, nomorHP, alamat});
                    resetInputFields();
                }
            }
        });

        this.add(buttonSimpan);
        this.add(buttonEdit);
        this.add(buttonHapus);
        this.add(buttonSimpanKeFile);
        this.add(textFieldNama);
        this.add(labelNomorHP);
        this.add(textFieldNomorHP);
        this.add(labelGender);
        this.add(radioButtonLaki);
        this.add(radioButtonPerempuan);
        this.add(checkBoxWNA);
        this.add(labelNama);
        this.add(textAreaAlamat);
        this.add(labelAlamat);
        this.add(scrollPane);

        this.setSize(950, 500);
        this.setLayout(null);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(null, "Apakah Anda yakin ingin keluar?",
                        "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    private void resetInputFields() {
        textFieldNama.setText("");
        textFieldNomorHP.setText("");
        radioButtonLaki.setSelected(false);
        radioButtonPerempuan.setSelected(false);
        checkBoxWNA.setSelected(false);
        textAreaAlamat.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                KombinasiLatihan app = new KombinasiLatihan();
                app.setVisible(true);
            }
        });
    }
}
