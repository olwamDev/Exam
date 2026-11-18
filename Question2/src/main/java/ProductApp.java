import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class ProductApp extends JFrame {

    private JLabel lblCustomerName, lblSelectProduct, lblEnterPrice;
    private JTextField txtCustomerName, txtPrice;
    private JComboBox<String> cboProduct;
    private JButton btnProcess;

    public ProductApp() {
        setTitle("Product App");
        setSize(420, 340);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // ========== MENU BAR ==========
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");

        JMenuItem mnuExit = new JMenuItem("Exit");
        JMenuItem mnuProcess = new JMenuItem("Process");
        JMenuItem mnuClear = new JMenuItem("Clear");

        fileMenu.add(mnuExit);
        toolsMenu.add(mnuProcess);
        toolsMenu.add(mnuClear);
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        // ========== FORM COMPONENTS ==========
        lblCustomerName = new JLabel("Customer Name:");
        lblCustomerName.setBounds(30, 40, 120, 25);
        add(lblCustomerName);

        lblSelectProduct = new JLabel("Select Product:");
        lblSelectProduct.setBounds(30, 80, 120, 25);
        add(lblSelectProduct);

        lblEnterPrice = new JLabel("Enter Price:");
        lblEnterPrice.setBounds(30, 120, 120, 25);
        add(lblEnterPrice);

        txtCustomerName = new JTextField();
        txtCustomerName.setBounds(160, 40, 190, 25);
        add(txtCustomerName);

        txtPrice = new JTextField();
        txtPrice.setBounds(160, 120, 190, 25);
        add(txtPrice);

        String[] productOptions = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        cboProduct = new JComboBox<>(productOptions);
        cboProduct.setBounds(160, 80, 190, 25);
        add(cboProduct);

        btnProcess = new JButton("PROCESS");
        btnProcess.setBounds(130, 180, 140, 35);
        add(btnProcess);

        // ========== PROCESS METHOD (reused for button AND menu) ==========
        Runnable processAction = () -> {
            try {
                String customer = txtCustomerName.getText();
                String selectedProduct = (String) cboProduct.getSelectedItem();
                double price = Double.parseDouble(txtPrice.getText());

                double vat = price * 0.15;
                double commission = price * 0.05;
                double totalSale = price + vat + commission;

                // Show message box
                String resultMessage =
                        "Customer Name: " + customer +
                        "\nProduct: " + selectedProduct +
                        "\nVAT R " + vat +
                        "\nCOMMISSION R " + commission +
                        "\nTOTAL R " + totalSale;
                JOptionPane.showMessageDialog(null, resultMessage, "Message", JOptionPane.INFORMATION_MESSAGE);

                // ========== SAVE TO data.txt ==========
                FileWriter writer = new FileWriter("data.txt", true);
                writer.write("DATA LOG\n");
                writer.write("****************************************\n");
                writer.write("Customer Name: " + customer + "\n");
                writer.write("Product: " + selectedProduct + "\n");
                writer.write("VAT: R " + vat + "\n");
                writer.write("COMMISSION: R " + commission + "\n");
                writer.write("TOTAL: R " + totalSale + "\n");
                writer.write("****************************************\n\n");
                writer.close();

            } catch (NumberFormatException error) {
                JOptionPane.showMessageDialog(null, "Enter a valid numeric price!", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Failed to save to data.txt!", "File Error", JOptionPane.ERROR_MESSAGE);
            }
        };

        // ========== CLEAR METHOD ==========
        Runnable clearAction = () -> {
            txtCustomerName.setText("");
            txtPrice.setText("");
            cboProduct.setSelectedIndex(0);
        };

        // ========== ASSIGN ACTIONS ==========
        btnProcess.addActionListener(e -> processAction.run());
        mnuProcess.addActionListener(e -> processAction.run());
        mnuClear.addActionListener(e -> clearAction.run());
        mnuExit.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProductApp frame = new ProductApp();
            frame.setVisible(true);
        });
    }
}