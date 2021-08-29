import javax.swing.JFrame;

public class RectangleAppWindow {

    public static void main(String[] args)
    {
        RectangleCalculator calc = new RectangleCalculator(); 

        calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calc.pack(); 
        calc.setVisible(true);
    }
    
}
