package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Model.Item;

public class GUIChangeExtras extends JPanel
{
   private JTextArea textAreaExtras;
   private JButton buttonHome;
   private JButton buttonBack;
   private JButton buttonSave;

   public GUIChangeExtras()
   {
      initializing();
      addComponentsToPanel();
   }
   
   public void initializing()
   {
      textAreaExtras = new JTextArea();
      buttonHome = new JButton("Home");
      buttonBack = new JButton ("Back");
      buttonSave = new JButton ("Save");
   }
   
   
   public void addComponentsToPanel()
   {
      setLayout(new BorderLayout());
      add(new JScrollPane(textAreaExtras), BorderLayout.CENTER);
      
      JPanel buttonPanel = new JPanel();
      buttonPanel.add(buttonHome);
      buttonPanel.add(buttonBack);
      buttonPanel.add(buttonSave);
      
      add(buttonPanel, BorderLayout.SOUTH);
      
   }
   
   public void addActionListener(ActionListener listener)
   {
      buttonHome.addActionListener(listener);
      buttonBack.addActionListener(listener);
      buttonSave.addActionListener(listener);
   }
   public void loadExtras(ArrayList<Item> extra)
   {
      String s ="";
      for(int i = 0;i<extra.size();i++)
      {
         s+=extra.get(i)+"\n";
      }
      textAreaExtras.setText(s);
   }
   
   public String[] getInput()
   {
      String[] input = { textAreaExtras.getText()};
      return input;
   }
}
