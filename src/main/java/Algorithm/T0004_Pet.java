package Algorithm;

/**
 * @Created by XDarker
 * @Description TODO
 * @Date 2020/8/9 15:27
 */
public class T0004_Pet {


    private String type;

    public T0004_Pet(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }


    class Dog extends T0004_Pet{
        public Dog() {
            super("Dog");
        }
    }

    class Cat extends T0004_Pet{
        public Cat() {
            super("Cat");
        }
    }
}


