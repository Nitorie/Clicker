import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame implements ActionListener {

    private int totalClicks = 0;
    private int speedClicks = 1;

    private JLabel clicksPanel = new JLabel("Your Clicks : " + totalClicks);
    private JLabel text = new JLabel("0");
    private JLabel Price1 = new JLabel("Price:100 clicks");
    private JLabel Price2 = new JLabel("Price:500 clicks");
    private JLabel Price3 = new JLabel("Price:1500 clicks");
    private JLabel Finish = new JLabel("Good Job, u complete my first game :)");

    JButton clicker = new JButton("Click me!");
    JButton storeButton = new JButton("Store");
    JButton buyButton1 = new JButton("+5 Clicks speed");
    JButton buyButton2 = new JButton("+15 Clicks speed");
    JButton buyButton3 = new JButton("+50 Clicks speed");
    JButton closeButton = new JButton("❌");
    JButton finishButton = new JButton("End. 10000 Clicks");

    UI() {
        Font font = new Font("Arial", Font.PLAIN, 24);

        setSize(750, 750);
        setLayout(null);
        clicker.setBounds(225, 225, 200, 200);
        clicker.setBackground(Color.PINK);
        clicksPanel.setBounds(235,400,300,100);
        storeButton.setBounds(625, 10, 100, 50);
        storeButton.setBackground(Color.ORANGE);
        closeButton.setBounds(50,10,50,50);
        closeButton.setBackground(Color.white);
        buyButton1.setBounds(50,100,200,125);
        buyButton2.setBounds(275,100,200,125);
        buyButton3.setBounds(500,100,200,125);
        Price1.setBounds(50,195,200,100);
        Price2.setBounds(275,195,200,100);
        Price3.setBounds(500,195,200,100);
        finishButton.setBounds(225,20,200,100);
        finishButton.setBackground(Color.gray);
        Finish.setBounds(125,225,1000,100);
        Finish.setFont(font);

        Price1.setFont(font);
        Price2.setFont(font);
        Price3.setFont(font);


        clicksPanel.setFont(font);

        add(storeButton);
        add(finishButton);
        add(closeButton);
        add(buyButton1);
        add(buyButton2);
        add(clicker);
        add(clicksPanel);
        add(Price1);
        add(Price2);
        add(Price3);
        add(Finish);
        add(buyButton3);

        clicker.addActionListener(this);
        storeButton.addActionListener(this);
        buyButton1.addActionListener(this);
        buyButton2.addActionListener(this);
        closeButton.addActionListener(this);
        buyButton3.addActionListener(this);
        finishButton.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.white);
        Price1.setVisible(false);
        Price2.setVisible(false);
        Price3.setVisible(false);
        closeButton.setVisible(false);
        buyButton1.setVisible(false);
        buyButton2.setVisible(false);
        buyButton3.setVisible(false);
        Finish.setVisible(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if(text.getText().equals("0"))
            text.setText("");

        switch (b.getText()) {
            case "Click me!":
                totalClicks += speedClicks;
                clicksPanel.setText("Your Clicks : " + totalClicks);
                if (totalClicks >= 1000) {
                    clicksPanel.setBounds(225, 400, 300, 100);
                }
                break;
            case "Store":
                clicksPanel.setBounds(275, 10, 200, 50);
                clicker.setVisible(false);
                finishButton.setVisible(false);
                closeButton.setVisible(true);
                buyButton1.setVisible(true);
                buyButton2.setVisible(true);
                buyButton3.setVisible(true);
                Price3.setVisible(true);
                Price2.setVisible(true);
                Price1.setVisible(true);
                break;
            case "❌":
                clicksPanel.setBounds(235, 400, 300, 100);
                clicker.setVisible(true);
                closeButton.setVisible(false);
                buyButton1.setVisible(false);
                buyButton2.setVisible(false);
                buyButton3.setVisible(false);
                finishButton.setVisible(true);
                Price1.setVisible(false);
                Price2.setVisible(false);
                Price3.setVisible(false);
                if (buyButton1.getText().equals("You don't have enough clicks")) {
                    buyButton1.setText("+5 Clicks speed");
                }
                if (buyButton2.getText().equals("You don't have enough clicks")) {
                    buyButton2.setText("+15 Clicks speed");
                }
                if (buyButton3.getText().equals("You don't have enough clicks")) {
                    buyButton3.setText("+50 Clicks speed");
                }
                break;
            case "+5 Clicks speed":
                if (totalClicks >= 100) {
                    speedClicks += 4;
                    totalClicks -= 100;
                    buyButton1.setText("You already buy this upgrade");
                    buyButton1.removeActionListener(this);
                    clicksPanel.setText("Your Clicks : " + totalClicks);
                } else {
                    buyButton1.setText("You don't have enough clicks");
                }
                break;
            case "+15 Clicks speed":
                if (totalClicks >= 500) {
                    speedClicks += 15;
                    totalClicks -= 500;
                    buyButton2.setText("You already buy this upgrade");
                    buyButton2.removeActionListener(this);
                    clicksPanel.setText("Your Clicks : " + totalClicks);
                } else {
                    buyButton2.setText("You don't have enough clicks");
                }
                break;
            case "+50 Clicks speed":
                if (totalClicks >= 1500) {
                    speedClicks += 50;
                    totalClicks -= 1500;
                    buyButton3.setText("You already buy this upgrade");
                    buyButton3.removeActionListener(this);
                    clicksPanel.setText("Your Clicks : " + totalClicks);
                } else {
                    buyButton3.setText("You don't have enough clicks");
                }
                break;
            case "End. 10000 Clicks":
                if (totalClicks >= 10000) {
                    storeButton.setVisible(false);
                    finishButton.setVisible(false);
                    closeButton.setVisible(false);
                    buyButton1.setVisible(false);
                    buyButton2.setVisible(false);
                    clicker.setVisible(false);
                    clicksPanel.setVisible(false);
                    Price1.setVisible(false);
                    Price2.setVisible(false);
                    Finish.setVisible(true);
                } else {
                    finishButton.setText("You don't have enough clicks");
                }
                break;

        }

    }
}



