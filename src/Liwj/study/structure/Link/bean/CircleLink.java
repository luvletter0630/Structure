package Liwj.study.structure.Link.bean;

/**
 * Created by Administrator on 2021/4/10.
 */
public class CircleLink {
    private LinkObj first;
    private LinkObj cur;

    public void addLink(LinkObj linkObj){
        if (first == null){
            first = linkObj;
            cur = linkObj;
        }else {
            cur.setNext(linkObj);
            cur = cur.getNext();
            cur.setNext(first);
        }
    }

    public void addNode(int num){
        for (int i = 1; i <= num ; i++) {
            addLink(new LinkObj(i));
        }
    }

    public static void main(String[] args) {
        CircleLink link = new CircleLink();
        link.addNode(10);
        System.out.println("finish");
    }
}
