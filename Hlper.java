import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;


public class Hlper
{

   private JFrame frame;

   /**
    * Launch the application.
    */
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
      {
         public void run()
         {
            try
            {
               Hlper window = new Hlper();
               window.frame.setVisible(true);
            }
            catch (Exception e)
            {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the application.
    */
   public Hlper()
   {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize()
   {
      frame = new JFrame();
      frame.setBounds(100, 100, 450, 300);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      JPanel panel = new JPanel();
      frame.getContentPane().add(panel, BorderLayout.CENTER);
      panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
      
      JLabel lblOkok = new JLabel("okok");
      panel.add(lblOkok);
      
      JLabel lblNewLabel = new JLabel("New label");
      frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
   }

}
