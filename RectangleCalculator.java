import java.awt.GridBagConstraints; 
import java.awt.GridBagLayout; 
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent; 
import java.awt.Insets; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JTextField; 
import javax.swing.JFormattedTextField; 
import javax.swing.JButton; 
import java.text.NumberFormat; 
import javax.swing.JOptionPane;



public class RectangleCalculator extends JFrame implements ActionListener {

    private JLabel lengthLabel; 
    private JLabel widthLabel; 
    private JLabel areaLabel; 
    private JTextField lengthField; 
    private JTextField widthField; 
    private JTextField areaField; 
    private JFormattedTextField lengthInput; 
    private JFormattedTextField widthInput; 
    private JButton calculate; 


    RectangleCalculator() 
    {
        GridBagConstraints layout = null; 

        setTitle("Rectangle Area Calculator"); 


        //label 
        lengthLabel = new JLabel("Length"); 
        widthLabel = new JLabel("Width"); 
        areaLabel = new JLabel("Area"); 

        //text fields 
        lengthField = new JTextField(15); 
        lengthField.setEditable(false); 

        widthField = new JTextField(15); 
        widthField.setEditable(false); 

        areaField = new JTextField(15); 
        areaField.setEditable(false); 

        //button 
        calculate = new JButton("Calculate"); 
        calculate.addActionListener(this); 

        //input fields 
        lengthInput = new JFormattedTextField(NumberFormat.getIntegerInstance()); 
        lengthInput.setEditable(true); 
        lengthInput.setText("0"); 
        lengthInput.setColumns(14); 

        widthInput = new JFormattedTextField(NumberFormat.getIntegerInstance()); 
        widthInput.setEditable(true); 
        widthInput.setText("0"); 
        widthInput.setColumns(14); 


        //layout for the components 
        setLayout(new GridBagLayout()); 

        //position the length label 
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10); 
        layout.gridx = 0; 
        layout.gridy = 0; 
        add(lengthLabel,layout);


        //position the length input text field 
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10); 
        layout.gridx = 1; 
        layout.gridy = 0; 
        add(lengthInput,layout); 


        //position the width label 
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10); 
        layout.gridx = 0; 
        layout.gridy = 1; 
        add(widthLabel, layout); 

        //position the width input text field 
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10); 
        layout.gridx = 1; 
        layout.gridy = 1; 
        add(widthInput,layout);

        //position the result label
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10); 
        layout.gridx = 0; 
        layout.gridy = 2; 
        add(areaLabel,layout); 


        //position the text field 
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10); 
        layout.gridx = 1; 
        layout.gridy = 2; 
        add(areaField,layout);

        //position the button 
        layout = new GridBagConstraints(); 
        layout.insets = new Insets(10,10,10,10); 
        layout.gridx = 2; 
        layout.gridy = 0; 
        add(calculate,layout); 

    }

    @Override 
    public void actionPerformed(ActionEvent event) 
    {

        int length; 
        int width; 
        int result;

        CalcArea calc = new CalcArea();


        try    
        {
            length = ((Number) lengthInput.getValue()).intValue(); 
            width = ((Number) widthInput.getValue()).intValue(); 

            if(length < 0 || width < 0)
            {
                throw new Exception("Length or width cannot be negative");
            }

            areaField.setText(Integer.toString(calc.getArea(length,width)));

        
        }

        catch(Exception excpt) 
        {
            JOptionPane.showMessageDialog(this,excpt.getMessage());
        }


    }

    
    
}
