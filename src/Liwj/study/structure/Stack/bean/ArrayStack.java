package Liwj.study.structure.Stack.bean;

/**
 * Created by Administrator on 2021/4/11.
 */
public class ArrayStack {
    private Integer maxSize;
    private Integer[] Stack;
    private Integer top = -1;

    public ArrayStack(int maxSize) {
        Stack = new Integer[maxSize];
        this.maxSize = maxSize;
    }

    public Integer pop(){
        if (isEmpty()){
            throw new RuntimeException("栈已空");
        }
        return Stack[top];
    }

    public void push(Integer value){
        if (isFull()){
            System.out.println("栈已满");
        }else {
            top++;
            Stack[top] = value;
        }

    }

    public boolean isFull(){
        return top == (maxSize - 1);
    }

    public boolean isEmpty(){
        return  top == -1;
    }
}
