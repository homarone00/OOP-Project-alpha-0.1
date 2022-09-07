package Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.second_column;

import Project_take1.MyCharacter;
import Project_take1.containers.top_panels.subtop_panels.bottomlevel_containers.first_column.CircularLabel;
import Project_take1.graphics.UpdatablePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class WeaponsPanel extends JPanel implements UpdatablePanel,MouseListener {
    MyCharacter myCharacter;
    JLabel title;
    JLabel settingsButton;
    int length=4;
    JPanel mainGrid;
    boolean editing;
    int addingPosition;
    boolean settingsButtonhovered=false;
    ArrayList<SingleWeaponPanel> singleWeaponPanelArrayList;
    CircularLabel plusLabel=new CircularLabel("+",-5,9,15);
    public WeaponsPanel(MyCharacter myCharacter){
        super();
        this.myCharacter=myCharacter;
        JPanel topGrid=new JPanel(new BorderLayout());
        topGrid.setOpaque(false);
        addingPosition =length;
        title =new JLabel("Weapons");
        title.setFont(new Font("Comic Sans",Font.BOLD,15));
        title.setOpaque(false);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setPreferredSize(new Dimension(20,30));

        singleWeaponPanelArrayList=new ArrayList<>();

        mainGrid=new JPanel(new GridBagLayout());
        mainGrid.setOpaque(false);

        plusLabel.setPreferredSize(new Dimension(20,20));
        plusLabel.addMouseListener(this);

        setLayout(new BorderLayout());
        GridBagConstraints c=new GridBagConstraints();
        Insets insets=new Insets(2,0,2,0);

        c.gridy=0;
        c.fill=GridBagConstraints.BOTH;
        c.weightx=10;
        c.weighty=10;
        c.insets=insets;

        SingleWeaponPanel panel1=new SingleWeaponPanel(myCharacter,true);
        singleWeaponPanelArrayList.add(panel1);
        mainGrid.add(panel1,c);

        c.gridy=1;
        SingleWeaponPanel panel2=new SingleWeaponPanel(myCharacter,true);
        singleWeaponPanelArrayList.add(panel2);
        mainGrid.add(panel2,c);

        c.gridy=2;
        SingleWeaponPanel panel3=new SingleWeaponPanel(myCharacter,true);
        singleWeaponPanelArrayList.add(panel3);
        mainGrid.add(panel3,c);

        c.gridy=3;
        SingleWeaponPanel panel4=new SingleWeaponPanel(myCharacter,true);
        singleWeaponPanelArrayList.add(panel4);
        mainGrid.add(panel4,c);

        settingsButton=new JLabel(getPalette().getUnpressedSettingsButton());
        settingsButton.addMouseListener(this);
        topGrid.add(settingsButton,BorderLayout.EAST);
        topGrid.add(title,BorderLayout.CENTER);
        topGrid.add(plusLabel,BorderLayout.WEST);

        add(mainGrid,BorderLayout.CENTER);
        add(topGrid,BorderLayout.NORTH);

        setOpaque(false);
    }
    @Override
    public void updateColors() {

    }

    @Override
    public void updatePanel() {

    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void addPanel(){
        GridBagConstraints c=new GridBagConstraints();
        c.insets= new Insets(2,0,2,0);
        c.gridy=addingPosition;
        c.gridx=0;
        c.weighty=10;
        c.weightx=10;
        c.fill=GridBagConstraints.BOTH;
        SingleWeaponPanel newPanel=new SingleWeaponPanel(myCharacter,true);
        mainGrid.add(newPanel,c);
        singleWeaponPanelArrayList.add(newPanel);
        newPanel.setEditable(isEditing());
        revalidate();
        addingPosition++;
        length++;
    }
    public void removePanel(int index){
        if(length>1){
            SingleWeaponPanel singleWeaponPanel=singleWeaponPanelArrayList.get(index);
            if(singleWeaponPanel==null){
                throw new IllegalArgumentException("singleWeaponPanel in WeaponsPanel.removePanel cannot be null");
            }
            mainGrid.remove(singleWeaponPanel);
            singleWeaponPanelArrayList.remove(singleWeaponPanel);
            length--;
        }

    }
    public boolean isEditing() {
        return editing;
    }

    public void setEditing(boolean editing) {
        this.editing = editing;
        for(SingleWeaponPanel i:singleWeaponPanelArrayList){
            i.setEditable(editing);
        }
    }

    public CircularLabel getPlusLabel() {
        return plusLabel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(settingsButton)){
            if(isEditing()){
                settingsButton.requestFocus();
                setEditing(false);
            }
            else{
                settingsButton.requestFocus();
                setEditing(true);
            }
        }
        for(SingleWeaponPanel i:singleWeaponPanelArrayList){
            if(e.getSource().equals(i.getIconLabel())&&isEditing()){
                mainGrid.remove(i);
                revalidate();

            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource().equals(settingsButton)){
            settingsButton.setIcon(getPalette().getPressedSettingsButton());
        }
        if(e.getSource().equals(plusLabel)){
            plusLabel.setPressed(true);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource().equals(settingsButton)){
            if(settingsButtonhovered){
                settingsButton.setIcon(getPalette().getHoveredSettingsButton());
            }
            if(!settingsButtonhovered){
                settingsButton.setIcon(getPalette().getUnpressedSettingsButton());
            }
        }
        if(e.getSource().equals(plusLabel)){
            plusLabel.setPressed(false);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource().equals(settingsButton)){
            settingsButton.setIcon(getPalette().getHoveredSettingsButton());
            settingsButtonhovered=true;
        }
        if(e.getSource().equals(plusLabel)){
            plusLabel.setEntered(true);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource().equals(settingsButton)){
            settingsButton.setIcon(getPalette().getUnpressedSettingsButton());
            settingsButtonhovered=false;
        }
        if(e.getSource().equals(plusLabel)){
            plusLabel.setEntered(false);
        }

    }

    public ArrayList<SingleWeaponPanel> getSingleWeaponPanelArrayList() {
        return singleWeaponPanelArrayList;
    }

    public void setSingleWeaponPanelArrayList(ArrayList<SingleWeaponPanel> singleWeaponPanelArrayList) {
        this.singleWeaponPanelArrayList = singleWeaponPanelArrayList;
    }
}
