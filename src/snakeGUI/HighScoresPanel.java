package snakeGUI;

import snakeLogic.PointsComparator;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import snakeLogic.User;
import static snakeGUI.MainFrame.frame;

/**
 *
 * @author Kuba
 */
public class HighScoresPanel extends javax.swing.JPanel implements ActionListener {

    /**
     * Creates new form HighScoresPanel
     */
    public HighScoresPanel() {
        initComponents();
        setPanelsOpaque();
        tools = new GraphicsTools();
        userScores = new ArrayList<User>();
        try {
            readFromFile();
        } catch (IOException ex) {
            System.out.println(ex + "Nieudana próba odczytu pliku.");
        }
    }

    private List<User> userScores;
    private GraphicsTools tools;
    private Color linesColor = Color.white;

    private void setPanelsOpaque() {
        ButtonContainPanel.setOpaque(false);
        ButtonPanel.setOpaque(false);
        TitlePanel.setOpaque(false);
        ListContainPanel.setOpaque(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        tools.drawLines(g2d, linesColor);
    }

    public void readFromFile() throws IOException {
        DefaultListModel listModel = new DefaultListModel();
        int licznik = 1;
        Scanner file = null;
        String line;
        String name;
        int points;

        try {
            file = new Scanner(new BufferedReader(new FileReader("HighScores.txt")));

            while (file.hasNext()) {
                name = file.next();
                while (!file.hasNextInt()) {
                    name += (" " + file.next());
                }
                points = file.nextInt();
                userScores.add(new User(name, points));

                licznik++;
            }

            Collections.sort(userScores, new PointsComparator());

            for (int i = 0; i < licznik - 1; i++) {
                line = (i + 1) + ".  " + userScores.get(i).getUserName() + "     " + userScores.get(i).getPoints() + " PKT";
                listModel.addElement(line);
            }
            HighScoresList.setModel(listModel);
        } finally {
            if (file != null) {
                file.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitlePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ListContainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        HighScoresList = new javax.swing.JList<>();
        ButtonContainPanel = new javax.swing.JPanel();
        ButtonPanel = new javax.swing.JPanel();
        ClearListButton = new javax.swing.JButton();
        MenuButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("     WYNIKI");

        javax.swing.GroupLayout TitlePanelLayout = new javax.swing.GroupLayout(TitlePanel);
        TitlePanel.setLayout(TitlePanelLayout);
        TitlePanelLayout.setHorizontalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitlePanelLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TitlePanelLayout.setVerticalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitlePanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        HighScoresList.setBackground(new java.awt.Color(0, 0, 0));
        HighScoresList.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        HighScoresList.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(HighScoresList);

        javax.swing.GroupLayout ListContainPanelLayout = new javax.swing.GroupLayout(ListContainPanel);
        ListContainPanel.setLayout(ListContainPanelLayout);
        ListContainPanelLayout.setHorizontalGroup(
            ListContainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListContainPanelLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ListContainPanelLayout.setVerticalGroup(
            ListContainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListContainPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        ButtonPanel.setLayout(new java.awt.GridLayout(1, 0, 150, 0));

        ClearListButton.setBackground(new java.awt.Color(0, 0, 0));
        ClearListButton.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        ClearListButton.setForeground(new java.awt.Color(255, 255, 255));
        ClearListButton.setText("Wyczyść listę");
        ClearListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearListButtonActionPerformed(evt);
            }
        });
        ButtonPanel.add(ClearListButton);

        MenuButton.setBackground(new java.awt.Color(0, 0, 0));
        MenuButton.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        MenuButton.setForeground(new java.awt.Color(255, 255, 255));
        MenuButton.setText("Menu");
        MenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuButtonActionPerformed(evt);
            }
        });
        ButtonPanel.add(MenuButton);

        javax.swing.GroupLayout ButtonContainPanelLayout = new javax.swing.GroupLayout(ButtonContainPanel);
        ButtonContainPanel.setLayout(ButtonContainPanelLayout);
        ButtonContainPanelLayout.setHorizontalGroup(
            ButtonContainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ButtonContainPanelLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(ButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        ButtonContainPanelLayout.setVerticalGroup(
            ButtonContainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonContainPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(ButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ButtonContainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ListContainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ListContainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonContainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void MenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuButtonActionPerformed
        JPanel menu = new MenuPanel();
        frame.getContentPane().removeAll();
        frame.add(menu);
        frame.validate();
        frame.pack();
        repaint();
    }//GEN-LAST:event_MenuButtonActionPerformed

    private void ClearListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearListButtonActionPerformed
        DefaultListModel listModel = new DefaultListModel();
        HighScoresList.setModel(listModel);

        PrintWriter file = null;
        try {
            file = new PrintWriter("HighScores.txt");
            file.print("");
        } catch (FileNotFoundException ex) {
            System.out.println(ex + "Nieudana próba odczytu pliku.");
        } finally {
            if (file != null) {
                file.close();
            }
        }
    }//GEN-LAST:event_ClearListButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonContainPanel;
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JButton ClearListButton;
    private javax.swing.JList<String> HighScoresList;
    private javax.swing.JPanel ListContainPanel;
    private javax.swing.JButton MenuButton;
    private javax.swing.JPanel TitlePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
