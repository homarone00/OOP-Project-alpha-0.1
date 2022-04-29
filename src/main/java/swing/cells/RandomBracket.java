package swing.cells;
import java.awt.*;
import java.util.Random;
import javax.swing.*;
import static java.lang.Math.abs;

public class RandomBracket extends JPanel {
    int min;
    int max;
    JTextField text;
    Random rand;
    public RandomBracket(int min, int max){
        rand=new Random();
        this.min=min;
        this.max=max;
        text= new JTextField();
        text.setEditable(false);
        this.setPreferredSize(new Dimension(150,50));
        text.setPreferredSize(new Dimension(20,getPreferredSize().height));
        this.add(text);
    }
    public void randomUpdate(){
        int i=abs((rand.nextInt(min,max))+1); //da finire
        text.setText(String.valueOf(i));
        System.out.println(i);

    }
    public int getValue(){
        return Integer.parseInt(text.getText());
    }
    public void initRand(RandomBracket d100, RandomBracket d2){
        randomUpdate();
        if (getValue()<=10){
            d100.randomUpdate();
            d2.randomUpdate();
        }
    }
}
