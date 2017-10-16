import javax.swing.JOptionPane;


public class Umbrella {
        public static void main(String[] args)
        {
            int answer = JOptionPane.showConfirmDialog(null, "Is it currently raining?");
            boolean rainingStatus = (answer == JOptionPane.YES_OPTION);
            if (rainingStatus)
            {
                JOptionPane.showMessageDialog(null, "Put up your umbrella!");
            }
            else if (answer == JOptionPane.NO_OPTION)
            {
                answer = JOptionPane.showConfirmDialog(null, "Does it look like raining today?");
                boolean looksLikeRain = (answer == JOptionPane.YES_OPTION);
                if (looksLikeRain)
                {
                    JOptionPane.showMessageDialog(null, "Bring your umbrella with you, " +
                            "but don't put it up just yet!");
                }
                else if (answer == JOptionPane.NO_OPTION)
                {
                    JOptionPane.showMessageDialog(null, "No umbrella needed!");
                }
            }
        }
}
