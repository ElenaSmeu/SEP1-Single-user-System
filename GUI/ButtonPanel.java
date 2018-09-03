package GUI;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel
{
   private JButton[] buttons;

   public ButtonPanel(LayoutManager layout, String... buttonTexts)
   {
      buttons = new JButton[buttonTexts.length];
      for (int i = 0; i < buttons.length; i++)
         buttons[i] = new JButton(buttonTexts[i]);

      addButtonsToPanel(layout);
   }

   public ButtonPanel(String... buttonTexts) // vertical
   {
      this(new GridLayout(buttonTexts.length, 1, 5, 5), buttonTexts);
   }

   public ButtonPanel(LayoutManager layout, int numberOfButtons)
   {
      String[] buttonTexts = new String[numberOfButtons];
      for (int i = 0; i < buttonTexts.length; i++)
         buttonTexts[i] = String.valueOf((i + 1));

      buttons = new JButton[buttonTexts.length];
      for (int i = 0; i < buttons.length; i++)
         buttons[i] = new JButton(buttonTexts[i]);

      addButtonsToPanel(layout);
   }

   public ButtonPanel(int numberOfButtons) // vertical
   {
      this(new GridLayout(numberOfButtons, 1, 5, 5), numberOfButtons);
   }

   public int getNumberOfButtons()
   {
      return buttons.length;
   }

   public void setButtonLabels(String... labels)
   {
      int length = Math.min(labels.length, buttons.length);
      for (int i = 0; i < length; i++)
      {
         buttons[i].setText(labels[i]);
      }
   }

   public JButton getButton(int index)
   {
      if (index < buttons.length && index >= 0)
         return buttons[index];
      return null;
   }

   public JButton getButton(String text)
   {
      for (int i = 0; i < buttons.length; i++)
         if (buttons[i].getText().equals(text))
            return buttons[i];
      return null;
   }

   public void addActionListenerToAllButtons(ActionListener listener)
   {
      if (listener == null)
         return;
      for (int i = 0; i < buttons.length; i++)
      {
         if (buttons[i] != null)
         {
            buttons[i].addActionListener(listener);
         }
      }
   }

   public void addActionListenerToOneButton(ActionListener listener, int index)
   {
      JButton oneButton = getButton(index);
      if (oneButton != null)
         oneButton.addActionListener(listener);
   }

   public void addActionListenerToOneButton(ActionListener listener,
         String buttonText)
   {
      JButton oneButton = getButton(buttonText);
      if (oneButton != null)
         oneButton.addActionListener(listener);
   }

   private void addButtonsToPanel(LayoutManager layout)
   {
      if (layout == null)
      {
         layout = new GridLayout(buttons.length, 1, 5, 5);
      }
      setLayout(layout);
      if (layout instanceof BorderLayout)
      {
         String[] position = { BorderLayout.NORTH, BorderLayout.SOUTH,
               BorderLayout.WEST, BorderLayout.EAST, BorderLayout.CENTER };
         int size = Math.min(position.length, buttons.length);
         for (int i = 0; i < size; i++)
         {
            add(buttons[i], position[i]);
         }
      }
      else
      {
         for (int i = 0; i < buttons.length; i++)
         {
            add(buttons[i]);
         }
      }
   }

}
