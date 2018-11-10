/**
 * Created by IntelliJ IDEA.
 * User: zmajidzada
 * Date: 12-Mar-2010
 * Time: 20:28:51
 * To change this template use File | Settings | File Templates.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KitchenShoppingPanel extends JPanel {

    private Product item[];
    private int index = 0;
    private int size = 15;
    private JButton removeButton;
    private JList productList;
    private JList shoppingList;
    private JButton updateButton;
    private JButton addButton;
    private JButton dispatchShoppingListButton;
    private JButton userInputButton;
    private JTextField calcTextField;
    private JTextField numItemsTextField;

    public KitchenShoppingPanel() {
        item = new Product[size];
        addProduct("ball", 2);
        addProduct("banana", 4);
        addProduct("tea", 1);
        addProduct("spoon", 1.5);
        addProduct("coffee", 2.75);
        addProduct("milk", 0.75);
        addProduct("sausage", 4.0);
        addProduct("apple", 1.59);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        JLabel l = new JLabel("                            " +
                "                         Product Name And Price          " +
                "                             " +
                "         Shopping List And Price");

        panel1.add(l, BorderLayout.NORTH);
        JPanel shoppingPanel=new JPanel();
        JPanel itemListPanel=createItemListPanel();
        shoppingPanel.add(itemListPanel);


        JPanel buttonPanel=createButtonPanel();
        shoppingPanel.add(buttonPanel);
        JPanel shoppingListPanel=createShoppingListPanel();
        shoppingPanel.add(shoppingListPanel);

        panel1.add(shoppingPanel, BorderLayout.CENTER);

        calcTextField = new JTextField("Total Cost: 0");
        panel1.add(calcTextField, BorderLayout.SOUTH);

        numItemsTextField = new JTextField("Total item: 0");

        panel1.add(numItemsTextField, BorderLayout.EAST);
        numItemsTextField.setSize(20, 20);

        add(panel1);
    }

    private JPanel createItemListPanel() {

        JPanel itemListPanel = new JPanel();
        DefaultListModel listModel = new DefaultListModel();
        productList = new JList(listModel);
        for (int i = 0; i < item.length; i++) {
            Product product = item[i];
            listModel.addElement(product);
        }

        productList.setBackground(Color.GREEN);
        productList.setVisibleRowCount(5);
        productList.setFixedCellHeight(15);
        productList.setDragEnabled(true);
        // productList.setBounds(30,40,30,40);

        JScrollPane p = new JScrollPane(productList);
        p.createHorizontalScrollBar();
        itemListPanel.add(p);
        add(itemListPanel);
        return itemListPanel;
    }

    private JPanel createShoppingListPanel() {
        JPanel listPanel = new JPanel();
        shoppingList = new JList(new DefaultListModel());
        shoppingList.setVisibleRowCount(5);
        shoppingList.setFixedCellHeight(15);
        shoppingList.getDropLocation();
        listPanel.add(new JScrollPane(shoppingList));
        return listPanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        addButton = new JButton("Add>>>");
        addButton.addActionListener(new Handler());
        buttonPanel.add(addButton, BorderLayout.NORTH);
        removeButton = new JButton("<<<Remove");
        removeButton.addActionListener(new Handler());
        buttonPanel.add(removeButton, BorderLayout.SOUTH);
        // JPanel spacer = new JPanel();

        updateButton = new JButton("Update");
        updateButton.addActionListener(new Handler());
        buttonPanel.add(updateButton, BorderLayout.WEST);
        //spacer.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        //   buttonPanel.add(spacer, BorderLayout.CENTER);

        dispatchShoppingListButton = new JButton("Dispatch");

        dispatchShoppingListButton.addActionListener(new Handler());
        buttonPanel.add(dispatchShoppingListButton, BorderLayout.EAST);
        userInputButton = new JButton("Add New Products");
        userInputButton.addActionListener(new Handler());
        buttonPanel.add(userInputButton, BorderLayout.CENTER);
      
        return buttonPanel;
    }

    public void addProduct(String itemName, double price) {
        item[index] = new Product(itemName, price);
        index++;
    }

     class Handler implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            Object source = e.getSource();
            DefaultListModel model = (DefaultListModel) shoppingList.getModel();
            if (source == addButton) {
                Object[] data = productList.getSelectedValues();

                for (Object obj : data) {
                    model.addElement(obj);

                }
            } else if (source == removeButton) {
                Object[] data = shoppingList.getSelectedValues();

                for (Object obj : data) {
                    model.removeElement(obj);
                }
            } else if (source == dispatchShoppingListButton) {

                model.clear();
             JOptionPane.showMessageDialog(null,"Dispatched");

            } else if (source ==userInputButton) {

                String newShoppingItem = JOptionPane.showInputDialog("Enter Item Name");
                double newShoppingItemPrice = Double.parseDouble(JOptionPane.showInputDialog("Price"));

               model.addElement(new Product(newShoppingItem,newShoppingItemPrice));



            } else if (source == updateButton) {
                Object[] values = productList.getSelectedValues();
                String display = "Please select a product";
                if (values.length > 0) {
                    display = productList.getSelectedValues()[0].toString();
                }
                String name = JOptionPane.showInputDialog("", display);
                String price = JOptionPane.showInputDialog("", "Enter Price Price");
                Product x = new Product(name, Double.parseDouble(price));
                if (values.length > 0) {
                    int index = productList.getSelectedIndex();
                    DefaultListModel model2 = (DefaultListModel) productList.getModel();

                    model2.removeElementAt(index);
                    model2.add(index, x);
                }
                


            }
            double price = 0.0;
            for (int i = 0; i < model.getSize(); i++) {
                Product p = (Product) model.get(i);
                price += p.getPrice();
            }
            calcTextField.setText("Total Cost: £" + price);
            numItemsTextField.setText("Total Item: " + model.getSize());
        }
    }
}
