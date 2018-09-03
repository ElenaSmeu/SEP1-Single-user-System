package GUI;
import javax.swing.*;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUIPredefinedTourOutputPanel extends JPanel
{

   
      private ButtonPanel outputButtonPanel;
      private JTextArea textArea;

      public GUIPredefinedTourOutputPanel()
      {
         createComponents();
         addComponentsToPanel();
      }

      private void createComponents()
      {
         textArea = new JTextArea(3, 5);
         outputButtonPanel = new ButtonPanel(new FlowLayout(), "Back","Finish");
         textArea.setEditable(false);
      }

      private void addComponentsToPanel()
      {
         setLayout(new BorderLayout());
         add(new JScrollPane(textArea), BorderLayout.CENTER);
         add(outputButtonPanel, BorderLayout.SOUTH);
      }
      

      public void setText(String text)
      {
         textArea.setText(text);
      }

      public void addActionListener(ActionListener listener)
      {
         outputButtonPanel.addActionListenerToAllButtons(listener);
      }
}
