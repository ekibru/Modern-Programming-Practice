package assignment1;

public final class myImmutableClass {
    enum SIZES  {SMALL,MEDIUM,LARGE};
   private final SIZES size;

    myImmutableClass(SIZES size){
        this.size = size;

    }

    public void checkSize()
    {
        switch(size){
            case LARGE :{ System.out.println("The size is Large");break;}
            case MEDIUM :{ System.out.println("The size is Medium");break;}
            case SMALL :{ System.out.println("The size is Small");break;}
            default :{ System.out.println("Wrong Size ");break;}
        }
    }


}
