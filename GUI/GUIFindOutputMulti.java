package GUI;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUIFindOutputMulti extends JPanel
{

   
      private ButtonPanel outputButtonPanel;
      private JTextArea textArea;
      private JTextField index;

      public GUIFindOutputMulti()
      {
         createComponents();
         addComponentsToPanel();
      }

      private void createComponents()
      {
         index = new JTextField(3);
         textArea = new JTextArea(3, 5);
         outputButtonPanel = new ButtonPanel(new FlowLayout(), "Back","Change");
         textArea.setEditable(false);
      }

      private void addComponentsToPanel()
      {
         setLayout(new BorderLayout());
         JPanel hjo = new JPanel(new FlowLayout());
         hjo.add(outputButtonPanel);
         hjo.add(index);
         add(new JScrollPane(textArea), BorderLayout.CENTER);
         add(hjo, BorderLayout.SOUTH);
      }
      

      public void setText(String text)
      {
         textArea.setText(text);
      }
      public String[] getInput()
      {
         String[] a = {
               textArea.getText(),index.getText()
         };
         return a;
      }
      public void addActionListener(ActionListener listener)
      {
         outputButtonPanel.addActionListenerToAllButtons(listener);
      }
}
