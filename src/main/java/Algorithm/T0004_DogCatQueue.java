package Algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Created by XDarker
 * @Description 猫狗队列
 * @Date 2020/8/9 15:35
 */
public class T0004_DogCatQueue {

    private Queue<T0004_PetEnterQueue> dogQ;
    private Queue<T0004_PetEnterQueue> catQ;

    private Integer count;

    public T0004_DogCatQueue() {
        this.dogQ = new LinkedList<>();
        this.catQ = new LinkedList<>();
        this.count = 0;
    }

    /**
     * 新增猫狗宠物
     *
     * @param pet
     */
    public void add(T0004_Pet pet) {
        String type = pet.getType();
        if ("dog".equals(type)) {
            this.dogQ.add(new T0004_PetEnterQueue(pet, this.count++));
        } else if ("cat".equals(type)) {
            this.catQ.add(new T0004_PetEnterQueue(pet, this.count++));
        } else {
            throw new RuntimeException("not cat not dog");
        }
    }

    public T0004_Pet pollAll() {

        if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
            if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
                return this.dogQ.poll().getPet();
            } else {
                return this.catQ.poll().getPet();
            }
        } else if (!this.dogQ.isEmpty()) {
            return this.dogQ.poll().getPet();
        } else if (!this.catQ.isEmpty()) {
            return this.catQ.poll().getPet();
        }else {
            throw new RuntimeException("queue is empty");
        }

    }

    public T0004_Pet.Dog pollDog(){
        if (!this.dogQ.isEmpty()) {
            return (T0004_Pet.Dog) this.dogQ.poll().getPet();
        }else {
            throw new RuntimeException("Dog queue is empty");
        }
    }

    public T0004_Pet.Cat pollCat(){
        if (!this.catQ.isEmpty()) {
            return (T0004_Pet.Cat) this.catQ.poll().getPet();
        }else {
            throw new RuntimeException("Dog queue is empty");
        }
    }

    public boolean isEmpty(){
        return this.dogQ.isEmpty() && this.catQ.isEmpty();
    }

    public boolean isDogQueueEmpty(){
        return this.dogQ.isEmpty();
    }

    public boolean isCatQueueEmpty(){
        return this.catQ.isEmpty();
    }
}
