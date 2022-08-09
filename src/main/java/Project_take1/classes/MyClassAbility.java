package Project_take1.classes;

import Project_take1.MyCharacter;

/*
this class is used to implement the specific abilities that each class unlocks by leveling up
the "level" attribute indicates the level, in that class, needed to unlock it.
 */
public class MyClassAbility {
    String name;
    String description;
    boolean hasLimitedUses;
    int numberOfUses; //zero if unlimited
    int usesLeft;
    int lvl;
    MyCharacter myCharacter;
    MyClass myClass;
    public static final int HAS_BEEN_USED=11;
    public static final int CANT_BE_USED=10;
    /*
   istruzioni all'uso.
   nel costruttore dell'abilità, dichiarare se quell'abilità dipende da uno dei seguenti attributi
   della classe.
   nel caso dipendesse da due, il costruttore li sommerà fra di loro
   è obbligatorio specificare un coefficiente moltiplicativo.
   STATIC permette di specificare qualsiasi numero da aggiungere, da inserire nell'attributo MOLT corrispondente
    */
    public static final int STRENGTH = 1;
    public static final int DEXTERITY = 2;
    public static final int CONSTITUTION = 3;
    public static final int INTELLIGENCE = 4;
    public static final int WISDOM = 5;
    public static final int CHARISMA = 6;
    public static final int CLASS_LVL = 7;
    public static final int CHARACTER_LVL=8;
    public static final int PROF_BONUS = 9;
    public static final int STATIC=69;
    /*
    ultimited uses
     */
    public MyClassAbility(String name, String description,MyCharacter myCharacter, MyClass myClass, int lvl){
        initialize(name,description,myCharacter,myClass,lvl);
        setNumberOfUses(0);
        setUsesLeft(0);
    }
    public MyClassAbility(String name, String description,MyCharacter myCharacter, MyClass myClass, int lvl, int ATTR_1,
                          int MOLT_1){
        initialize(name,description,myCharacter,myClass,lvl);
        int stat1;
        try{
            stat1=getStat(ATTR_1);
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("ATTR_1 in the constructor of the MyClassAbility class isn't valid");
        }
        int num1=stat1*MOLT_1;
        setNumberOfUses(num1);
    }
    public MyClassAbility(String name, String description,MyCharacter myCharacter, MyClass myClass, int lvl, int ATTR_1,
                          int MOLT_1,int ATTR_2,int MOLT_2){
        initialize(name,description,myCharacter,myClass,lvl);
        int stat1;
        try{
            stat1=getStat(ATTR_1);
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("ATTR_1 in the constructor of the MyClassAbility class isn't valid");
        }
        int stat2;
        try{
            stat2=getStat(ATTR_2);
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("ATTR_2 in the constructor of the MyClassAbility class isn't valid");
        }
        int num1=stat1*MOLT_1;
        int num2=stat2*MOLT_2;
        setNumberOfUses(num1+num2);
    }
    /*
    this was part of the three constructors. It was moved not to duplicate code
     */
    private void initialize(String name, String description,MyCharacter myCharacter, MyClass myClass, int lvl){
        setName(name);
        setDescription(description);
        setHasLimitedUses(false);
        setLvl(lvl);
        this.myCharacter=myCharacter;
        this.myClass=myClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHasLimitedUses() {
        return hasLimitedUses;
    }

    public void setHasLimitedUses(boolean hasLimitedUses) {
        this.hasLimitedUses = hasLimitedUses;
    }

    public int getNumberOfUses() {
        return numberOfUses;
    }

    public void setNumberOfUses(int numberOfUses) {
        this.numberOfUses = numberOfUses;
    }

    public int getUsesLeft() {
        return usesLeft;
    }

    public void setUsesLeft(int usesLeft) {
        this.usesLeft = usesLeft;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    int use(){
        if(getUsesLeft()>0){
            setUsesLeft(getUsesLeft()-1);
            return HAS_BEEN_USED;
        }
        else{
            return CANT_BE_USED;
        }
    }
    int getStat(int ATTR){
        int stat;
        switch (ATTR) {
            case STRENGTH:
                stat=myCharacter.getAbilityModifier(MyCharacter.STRENGTH);
                break;
            case DEXTERITY:
                stat=myCharacter.getAbilityModifier(MyCharacter.DEXTERITY);
                break;
            case CONSTITUTION:
                stat=myCharacter.getAbilityModifier(MyCharacter.CONSTITUTION);
            case INTELLIGENCE:
                stat=myCharacter.getAbilityModifier(MyCharacter.INTELLIGENCE);
                break;
            case WISDOM:
                stat=myCharacter.getAbilityModifier(MyCharacter.WISDOM);
                break;
            case CHARISMA:
                stat=myCharacter.getAbilityModifier(MyCharacter.CHARISMA);
            case STATIC:
                stat=1;
            case CHARACTER_LVL:
                stat=myCharacter.getLvl();
            case CLASS_LVL:
                stat=myClass.getLevel();
            default:
                throw new IllegalArgumentException("the getStat method of the MyClassAbility class got an illegal argument ");
        }
        return stat;
    }
    public String getClassName(){
        return myClass.getName();
    }
}
