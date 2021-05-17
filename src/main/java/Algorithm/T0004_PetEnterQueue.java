package Algorithm;

/**
 * @Created by XDarker
 * @Description TODO
 * @Date 2020/8/9 15:32
 */
public class T0004_PetEnterQueue {

    private T0004_Pet pet;
    private Integer count;

    public T0004_PetEnterQueue(T0004_Pet pet, Integer count) {
        this.pet = pet;
        this.count = count;
    }

    public T0004_Pet getPet() {
        return pet;
    }

    public Integer getCount() {
        return count;
    }

    public String getPetType() {
        return pet.getType();
    }
}
